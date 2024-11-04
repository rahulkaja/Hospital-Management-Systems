import java.time.LocalDate;

public class Treatment {
    private int treatmentID;
    private Patient patient;       // Link to the patient receiving the treatment
    private Doctor doctor;         // Doctor administering or overseeing the treatment
    private String treatmentType;  // Description or type of treatment (e.g., "Chemotherapy")
    private LocalDate treatmentDate; // Date of the treatment
    private String treatmentNotes; // Any additional notes about the treatment
    
    // Constructor
    public Treatment(int treatmentID, Patient patient, Doctor doctor, String treatmentType, LocalDate treatmentDate, String treatmentNotes) {
        this.treatmentID = treatmentID;
        this.patient = patient;
        this.doctor = doctor;
        this.treatmentType = treatmentType;
        this.treatmentDate = treatmentDate;
        this.treatmentNotes = treatmentNotes;
    }

    // Display treatment details
    public void displayTreatmentDetails() {
        System.out.println("\nTreatment Details:");
        System.out.println("Treatment ID: " + treatmentID);
        System.out.println("Patient Name: " + patient.getName()); // Access patient's name
        System.out.println("Doctor: " + doctor.getName());        // Access doctor's name
        System.out.println("Treatment Type: " + treatmentType);
        System.out.println("Treatment Date: " + treatmentDate);
        System.out.println("Notes: " + treatmentNotes);
    }
    // Getters and Setters if needed
}
