import java.time.LocalDate;

public class Treatment {
    int treatmentID;
    Patient patient;       // Link to the patient receiving the treatment
    Doctor doctor;         // Doctor administering or overseeing the treatment
    String treatmentType;  // Description or type of treatment (e.g., "Chemotherapy")
    LocalDate treatmentDate; // Date of the treatment
    String treatmentNotes; // Any additional notes about the treatment
    
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
        System.out.println("Patient Name: " + patient.name); // Access patient's name
        System.out.println("Doctor: " + doctor.name);        // Access doctor's name
        System.out.println("Treatment Type: " + treatmentType);
        System.out.println("Treatment Date: " + treatmentDate);
        System.out.println("Notes: " + treatmentNotes);
    }
    // Getters and Setters if needed
}
