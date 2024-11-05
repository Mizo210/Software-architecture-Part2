import java.util.*;
import java.io.*;

public class Speaker {
    private String name;
    private String bio;
    private List<Session> sessions;
    private List<Speaker> speakers;

    public Speaker(String name, String bio) {
        this.name = name;
        this.bio = bio;
        this.sessions = new ArrayList<>();
        this.speakers = new ArrayList<>();
    }

    public void assignSession(Session session) {
        sessions.add(session);
    }

    public String getBio() {
        return bio;
    }
    
        public void saveAttendeesToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(speakers);
            System.out.println("Speakers saved to file.");
        } catch (IOException e) {
            System.err.println("Error saving speakers: " + e.getMessage());
        }
    }
    
        @SuppressWarnings("unchecked")
    public void loadSpeakersFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
         speakers = (ArrayList<Speaker>) ois.readObject();
            System.out.println("Speakers loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading speakers: " + e.getMessage());
        }
    }
}
