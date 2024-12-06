import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.util.List;

public class HealthcareSystemGUI {
    private JFrame frame;
    private JTextArea logArea;
    private HealthcareSystem healthcareSystem;

    public HealthcareSystemGUI() {
        healthcareSystem = new HealthcareSystem();
        frame = new JFrame("Healthcare System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null); // Center the window on the screen

        // Create a tabbed pane for different sections
        JTabbedPane tabbedPane = new JTabbedPane();

        // Add tabs with custom styles
        tabbedPane.addTab("Patient Management", createPatientPanel());
        tabbedPane.addTab("Appointment Scheduling", createAppointmentPanel());
        tabbedPane.addTab("Prescription", createPrescriptionPanel());
        tabbedPane.addTab("Billing", createBillingPanel());
        tabbedPane.addTab("Logs", createLogPanel());

        tabbedPane.setBackground(Color.LIGHT_GRAY);

        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    // Create the patient management tab
    private JPanel createPatientPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE, 2), "Add Patient", 0, 0, new Font("Arial", Font.BOLD, 14), Color.BLACK));
        panel.setBackground(Color.WHITE);

        // Patient input fields
        JTextField patientNameField = new JTextField();
        JComboBox<String> roomTypeComboBox = new JComboBox<>(new String[] {"General", "Semi-Private", "Private", "ICU"});
        JButton addPatientButton = new JButton("Add Patient");

        addPatientButton.setBackground(new Color(0, 122, 204));  // Blue background for buttons
        addPatientButton.setForeground(Color.WHITE);  // White text on the button
        addPatientButton.setFocusPainted(false);  // Remove focus highlight
        addPatientButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  // Padding inside button

        panel.add(new JLabel("Patient Name:"));
        panel.add(patientNameField);
        panel.add(new JLabel("Room Type:"));
        panel.add(roomTypeComboBox);
        panel.add(new JLabel(""));
        panel.add(addPatientButton);

        addPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = patientNameField.getText();
                String roomType = (String) roomTypeComboBox.getSelectedItem();
                Room.RoomType roomEnum = Room.RoomType.valueOf(roomType.toUpperCase().replace("-", "_"));
                Patient patient = new Patient(name, Patient.BloodGroup.O_POSITIVE, 30, "555-1234", "123 Main St", "Male", null, null, null);
                healthcareSystem.addPatient(patient);
                healthcareSystem.assignRoomToPatient(patient, roomEnum);
                logArea.append("Patient added: " + name + "\n");
            }
        });

        return panel;
    }

    // Create the appointment scheduling tab
    private JPanel createAppointmentPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE, 2), "Schedule Appointment", 0, 0, new Font("Arial", Font.BOLD, 14), Color.BLACK));
        panel.setBackground(Color.WHITE);

        // Appointment input fields
        JComboBox<String> doctorComboBox = new JComboBox<>(new String[] {"Dr. Alice", "Dr. Bob"});
        JTextField appointmentDateField = new JTextField();
        JButton scheduleButton = new JButton("Schedule Appointment");

        scheduleButton.setBackground(new Color(0, 122, 204));  // Blue background for buttons
        scheduleButton.setForeground(Color.WHITE);  // White text on the button
        scheduleButton.setFocusPainted(false);  // Remove focus highlight
        scheduleButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  // Padding inside button

        panel.add(new JLabel("Doctor:"));
        panel.add(doctorComboBox);
        panel.add(new JLabel("Appointment Date (yyyy-mm-dd HH:mm):"));
        panel.add(appointmentDateField);
        panel.add(new JLabel(""));
        panel.add(scheduleButton);

        scheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Doctor doctor = healthcareSystem.getDoctors().get(0); // Get first doctor (can improve this logic)
                    Patient patient = healthcareSystem.getPatients().get(0); // Get first patient (can improve this logic)
                    String appointmentDateString = appointmentDateField.getText();
                    LocalDateTime appointmentDate = LocalDateTime.parse(appointmentDateString);
                    healthcareSystem.scheduleAppointment(patient, doctor, appointmentDate);
                    logArea.append("Appointment scheduled for " + patient.getName() + "\n");
                } catch (Exception ex) {
                    logArea.append("Invalid date format or missing data.\n");
                }
            }
        });

        return panel;
    }

    // Create the prescription tab
    private JPanel createPrescriptionPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE, 2), "Create Prescription", 0, 0, new Font("Arial", Font.BOLD, 14), Color.BLACK));
        panel.setBackground(Color.WHITE);

        // Prescription input fields
        JTextField medicationsField = new JTextField();
        JTextField dosageInstructionsField = new JTextField();
        JButton createPrescriptionButton = new JButton("Create Prescription");

        createPrescriptionButton.setBackground(new Color(0, 122, 204));  // Blue background for buttons
        createPrescriptionButton.setForeground(Color.WHITE);  // White text on the button
        createPrescriptionButton.setFocusPainted(false);  // Remove focus highlight
        createPrescriptionButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  // Padding inside button

        panel.add(new JLabel("Medications:"));
        panel.add(medicationsField);
        panel.add(new JLabel("Dosage Instructions:"));
        panel.add(dosageInstructionsField);
        panel.add(new JLabel(""));
        panel.add(createPrescriptionButton);

        createPrescriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String medications = medicationsField.getText();
                String dosage = dosageInstructionsField.getText();
                Doctor doctor = healthcareSystem.getDoctors().get(0); // Assuming Dr. Alice
                Patient patient = healthcareSystem.getPatients().get(0); // Assuming first patient
                List<String> medsList = List.of(medications.split(","));
                healthcareSystem.createPrescription(doctor, patient, medsList, dosage);
                logArea.append("Prescription created for " + patient.getName() + "\n");
            }
        });

        return panel;
    }

    // Create the billing tab
    private JPanel createBillingPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE, 2), "Generate Bill", 0, 0, new Font("Arial", Font.BOLD, 14), Color.BLACK));
        panel.setBackground(Color.WHITE);

        // Billing input fields
        JTextField itemizedChargesField = new JTextField();
        JTextField amountPaidField = new JTextField();
        JTextField paymentMethodField = new JTextField();
        JButton generateBillButton = new JButton("Generate Bill");

        generateBillButton.setBackground(new Color(0, 122, 204));  // Blue background for buttons
        generateBillButton.setForeground(Color.WHITE);  // White text on the button
        generateBillButton.setFocusPainted(false);  // Remove focus highlight
        generateBillButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  // Padding inside button

        panel.add(new JLabel("Itemized Charges:"));
        panel.add(itemizedChargesField);
        panel.add(new JLabel("Amount Paid:"));
        panel.add(amountPaidField);
        panel.add(new JLabel("Payment Method:"));
        panel.add(paymentMethodField);
        panel.add(new JLabel(""));
        panel.add(generateBillButton);

        generateBillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String charges = itemizedChargesField.getText();
                double amountPaid = Double.parseDouble(amountPaidField.getText());
                String paymentMethod = paymentMethodField.getText();
                List<String> chargeList = List.of(charges.split(","));
                HospitalStaff staff = new HospitalStaff("Staff Member", 45, "Billing", "Accountant", "Admin", "01/01/2023", "555-5678", 30000, "Day");
                Patient patient = healthcareSystem.getPatients().get(0); // Assuming first patient
                healthcareSystem.generateBill(patient, staff, chargeList, amountPaid, paymentMethod);
                logArea.append("Bill generated for " + patient.getName() + ". Total: " + amountPaid + "\n");
            }
        });

        return panel;
    }

    // Create the logs tab
    private JScrollPane createLogPanel() {
        logArea = new JTextArea();
        logArea.setEditable(false);
        logArea.setBackground(Color.LIGHT_GRAY);
        logArea.setFont(new Font("Arial", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(logArea);
        return scrollPane;
    }

    public static void main(String[] args) {
        new HealthcareSystemGUI();
    }
}
