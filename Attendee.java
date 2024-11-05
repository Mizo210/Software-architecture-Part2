import java.util.*;

public class Attendee {
    private String attendeeID;
    private String name;
    private String email;
    private List<Session> personalizedSchedule;

    public Attendee(String id, String name, String email) {
        this.attendeeID = id;
        this.name = name;
        this.email = email;
        this.personalizedSchedule = new ArrayList<>();
    }
    
        public String getName() {
        return name;
    }


    public void trackAttendance(Session session) {
        personalizedSchedule.add(session);
    }

    public List<Session> getPersonalizedSchedule() {
        return personalizedSchedule;
    }

    public void createCertificate() {
        System.out.println("Certificate for " + name);
    }
    
    public void addToSchedule(Session session) {
        personalizedSchedule.add(session);
    }

    // Search for a session by ID in the attendee's schedule
    public Session searchSession(String sessionID) {
        for (Session session : personalizedSchedule) {
            if (session.getSessionID().equals(sessionID)) {
                return session;
            }
        }
        return null; // Session not found
    }
}
