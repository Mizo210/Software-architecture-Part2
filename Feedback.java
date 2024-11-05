import java.util.*;
import java.io.*;

public class Feedback {
    private Attendee attendee;
    private Session session;
    private String comments;
    private int ratings;

    public Feedback(Attendee attendee, Session session, String comments, int ratings) {
        this.attendee = attendee;
        this.session = session;
        this.comments = comments;
        this.ratings = ratings;
    }

    public String getFeedbackDetails() {
        return "Feedback by " + attendee.getName() + ": " + comments + " - Rating: " + ratings;
    }
    
        public static void saveFeedback(List<Feedback> feedbackList, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(feedbackList);
            System.out.println("Feedback saved to file.");
        } catch (IOException e) {
            System.err.println("Error saving feedback: " + e.getMessage());
        }
    }


    @SuppressWarnings("unchecked")
    public static List<Feedback> loadFeedback(String filename) {
        List<Feedback> feedbackList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            feedbackList = (ArrayList<Feedback>) ois.readObject();
            System.out.println("Feedback loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading feedback: " + e.getMessage());
        }
        return feedbackList;
    }
}
