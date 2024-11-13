import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ConferenceGUI extends JFrame {
    private Conference conference;
    private JTextArea displayArea;

    public ConferenceGUI(Conference conference) {
        this.conference = conference;
        setupGUI();
    }

    private void setupGUI() {
        setTitle("Conference Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Display area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));

        // Register Attendee Button
        JButton registerAttendeeButton = new JButton("Register Attendee");
        registerAttendeeButton.addActionListener(new RegisterAttendeeAction());
        buttonPanel.add(registerAttendeeButton);

        // View Sessions Button
        JButton viewSessionsButton = new JButton("View Sessions");
        viewSessionsButton.addActionListener(new ViewSessionsAction());
        buttonPanel.add(viewSessionsButton);

        // Generate Certificate Button
        JButton generateCertificateButton = new JButton("Generate Certificate");
        generateCertificateButton.addActionListener(new GenerateCertificateAction());
        buttonPanel.add(generateCertificateButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    // Action for registering a new attendee
    private class RegisterAttendeeAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = JOptionPane.showInputDialog("Enter Attendee Name:");
            String email = JOptionPane.showInputDialog("Enter Attendee Email:");
            if (name != null && email != null) {
                Attendee attendee = new Attendee("ID" + (conference.getAttendees().size() + 1), name, email);
                conference.registerAttendee(attendee);
                displayArea.append("Registered Attendee: " + name + "\n");
            }
        }
    }

    // Action for viewing session details
    private class ViewSessionsAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            displayArea.setText("Sessions:\n");
            for (Session session : conference.getSessionDetails()) {
                displayArea.append(session.getSessionDetails() + "\n");
            }
        }
    }

    // Action for generating attendance certificates
    private class GenerateCertificateAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String attendeeID = JOptionPane.showInputDialog("Enter Attendee ID:");
            Attendee attendee = conference.findAttendeeById(attendeeID);
            if (attendee != null) {
                attendee.createCertificate();
                displayArea.append("Certificate generated for: " + attendee.getName() + "\n");
            } else {
                JOptionPane.showMessageDialog(null, "Attendee not found!");
            }
        }
    }

    public static void main(String[] args) {
        Conference conference = new Conference("GAF-AI 2025", "2025-01-01", "2025-01-07");
        ConferenceGUI gui = new ConferenceGUI(conference);
        gui.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        String attendeeID = JOptionPane.showInputDialog("Enter Attendee ID:");
        Attendee attendee = conference.findAttendeeById(attendeeID);
        
        if (attendee != null) {
            attendee.createCertificate();
            displayArea.append("Certificate generated for: " + attendee.getName() + "\n");
        } else {
            JOptionPane.showMessageDialog(null, "Attendee not found!");
        }
    }
}

