import java.util.*;
import java.io.*;

public class Conference {
    private String conferenceName;
    private String startDate;
    private String endDate;
    private List<Session> sessions;
    private List<Attendee> attendees;

    public Conference(String name, String start, String end) {
        this.conferenceName = name;
        this.startDate = start;
        this.endDate = end;
        this.sessions = new ArrayList<>();
        this.attendees = new ArrayList<>();
    }

    public void registerAttendee(Attendee attendee) {
        attendees.add(attendee);
    }
    
    public List<Attendee> getAttendees() {
        return attendees;
    }
    
    public Attendee findAttendeeById(String attendeeID) {
        for (Attendee attendee : attendees) {
            if (attendee.getAttendee().equals(attendeeID)) {
                return attendee;  
            }
        }
        return null;  
    }

    public void addSession(Session session) {
        sessions.add(session);
    }

    public List<Session> getSessionDetails() {
        return sessions;
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
