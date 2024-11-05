import java.util.*;
import java.io.*;

public class Session {
    private String sessionID;
    private String sessionName;
    private Speaker speaker;
    private String date;
    private String time;
    private String room;
    private List<Attendee> attendees;

    public Session(String id, String name, Speaker speaker, String date, String time, String room) {
        this.sessionID = id;
        this.sessionName = name;
        this.speaker = speaker;
        this.date = date;
        this.time = time;
        this.room = room;
        this.attendees = new ArrayList<>();
    }
    
        public String getSessionID() {
        return sessionID;
    }


    public void registerAttendee(Attendee attendee) {
        attendees.add(attendee);
    }

    public String getSessionDetails() {
        return sessionName + " by " + speaker.getBio();
    }

    public String getSpeakerBio() {
        return speaker.getBio();
    }
    
        public void saveAttendeesToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(attendees);
            System.out.println("Attendees saved to file.");
        } catch (IOException e) {
            System.err.println("Error saving attendees: " + e.getMessage());
        }
    }
    


        @SuppressWarnings("unchecked")
    public void loadAttendeesFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            attendees = (ArrayList<Attendee>) ois.readObject();
            System.out.println("Attendees loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading attendees: " + e.getMessage());
        }
    }
    }
