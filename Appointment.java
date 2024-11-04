import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Appointment {
    int appointmentID;            // Unique identifier for the appointment
    Patient patient;               // Link to the associated patient
    Doctor doctor;                 // Link to the assigned doctor
    LocalDateTime appointmentDate; // Date and time of the appointment
    String status;                 // Status (Scheduled, Completed, Cancelled, No Show)
    List<String> notes;            // Notes related to the appointment

    // Appointment Status Constants
    public static final String STATUS_SCHEDULED = "Scheduled";
    public static final String STATUS_COMPLETED = "Completed";
    public static final String STATUS_CANCELLED = "Cancelled";
    public static final String STATUS_NO_SHOW = "No Show";

    // Constructor
    public Appointment(int appointmentID, Patient patient, Doctor doctor, LocalDateTime appointmentDate) {
        this.appointmentID = appointmentID;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
        this.status = STATUS_SCHEDULED; // Default status
        this.notes = new ArrayList<>();  // Initialize notes list
    }

    // Method to display appointment details
    public void displayAppointmentDetails() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("\nAppointment Details:");
        System.out.println("Appointment ID: " + appointmentID);
        System.out.println("Patient: " + (patient != null ? patient.getName() : "No Patient Assigned"));
        System.out.println("Doctor: " + (doctor != null ? doctor.getName() : "No Doctor Assigned"));
        System.out.println("Appointment Date: " + appointmentDate.format(formatter));
        System.out.println("Status: " + status);
        if (!notes.isEmpty()) {
            System.out.println("Notes: " + String.join(", ", notes));
        } else {
            System.out.println("Notes: None");
        }
    }

    // Method to change the status of the appointment
    public void updateStatus(String newStatus) {
        if (isValidStatus(newStatus)) {
            this.status = newStatus;
            System.out.println("Appointment status updated to: " + newStatus);
        } else {
            System.out.println("Invalid status: " + newStatus);
        }
    }

    // Method to add notes to the appointment
    public void addNotes(String note) {
        this.notes.add(note);
        System.out.println("Note added: " + note);
    }

    // Method to check if appointment is upcoming
    public boolean isUpcoming() {
        return appointmentDate.isAfter(LocalDateTime.now());
    }

    // Method to check if appointment is overdue
    public boolean isOverdue() {
        return appointmentDate.isBefore(LocalDateTime.now());
    }

    // Validate status
    private boolean isValidStatus(String status) {
        return status.equals(STATUS_SCHEDULED) || status.equals(STATUS_COMPLETED) ||
               status.equals(STATUS_CANCELLED) || status.equals(STATUS_NO_SHOW);
    }

    // Getters and Setters
    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        updateStatus(status);
    }

    public List<String> getNotes() {
        return notes;
    }
}
