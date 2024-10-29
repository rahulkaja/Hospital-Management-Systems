import java.util.List;

public class MedicalRecord {
    private int recordID;
    private Patient patient;                 // Link to the associated patient
    private List<String> pastDiagnoses;      // List of past diagnoses
    private List<Treatment> treatmentHistory; // List of treatments the patient has received
    private List<String> medications;        // List of current and past medications
    private String allergies;                // Allergies (could also be in the Patient class if preferred)
    private String notes;                    // Additional notes on the patient's health history

    // Constructor
    public MedicalRecord(int recordID, Patient patient, List<String> pastDiagnoses, List<Treatment> treatmentHistory,
                         List<String> medications, String allergies, String notes) {
        this.recordID = recordID;
        this.patient = patient;
        this.pastDiagnoses = pastDiagnoses;
        this.treatmentHistory = treatmentHistory;
        this.medications = medications;
        this.allergies = allergies;
        this.notes = notes;
    }

    // Display medical record details
    public void displayMedicalRecord() {
        System.out.println("\nMedical Record for Patient: " + patient.name);
        System.out.println("Record ID: " + recordID);
        System.out.println("Past Diagnoses: " + pastDiagnoses);
        System.out.println("Treatment History: ");
        for (Treatment treatment : treatmentHistory) {
            treatment.displayTreatmentDetails();
        }
        System.out.println("Medications: " + medications);
        System.out.println("Allergies: " + allergies);
        System.out.println("Notes: " + notes);
    }

    // Add treatment to the record
    public void addTreatment(Treatment treatment) {
        this.treatmentHistory.add(treatment);
    }

    // Getters and Setters if needed
}
