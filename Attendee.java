import java.util.List;
import java.util.ArrayList;

public class Attendee extends Person {
    private String attendeeID;
    private String name;
    private String email;
    private List<Session> personalizedSchedule;

    public Attendee(String ID, String name, String email) {
        super(ID,name);
        this.attendeeID = ID;
        this.name = name;
        this.email = email;
        this.personalizedSchedule = new ArrayList<>();
    }
    
        public String getName() {
        return name;
    }
    
        public String getAttendee() {
        return attendeeID;
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

    
    public Session searchSession(String sessionID) {
        for (Session session : personalizedSchedule) {
            if (session.getSessionID().equals(sessionID)) {
                return session;
            }
        }
        return null; 
    }
}

