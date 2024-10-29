import java.util.List;
public class Prescription {
     int prescriptionID; // Unique ID for the prescription
     Doctor doctor; // The doctor who issued the prescription
     Patient patient; // The patient receiving the prescription
     List<String> medications; // List of medications prescribed
     String dosageInstructions; // Instructions for taking the medication
     Pharmacy pharmacy; // Reference to the pharmacy to check medication availability
     String prescriptionDate; // Date the prescription was issued

    // Constructor
    public Prescription(int prescriptionID, Doctor doctor, Patient patient, List<String> medications, 
                       String dosageInstructions, Pharmacy pharmacy, String prescriptionDate) {
        this.prescriptionID = prescriptionID;
        this.doctor = doctor;
        this.patient = patient;
        this.medications = medications;
        this.dosageInstructions = dosageInstructions;
        this.pharmacy = pharmacy;
        this.prescriptionDate = prescriptionDate;
    }

    // Method to check medication availability
    public void checkMedicationAvailability() {
        for (String medication : medications) {
            boolean isAvailable = pharmacy.isMedicationAvailable(medication);
            System.out.println("Medication: " + medication + " is " + (isAvailable ? "available" : "not available") + " at the pharmacy.");
        }
    }

    // Display prescription details
    public void displayPrescriptionDetails() {
        System.out.println("\nPrescription ID: " + prescriptionID);
        System.out.println("Patient: " + patient.name);
        System.out.println("Doctor: " + doctor.name);
        System.out.println("Prescribed Medications: " + medications);
        System.out.println("Dosage Instructions: " + dosageInstructions);
        System.out.println("Prescription Date: " + prescriptionDate);
    }

    // Getters and Setters (if needed)
}
