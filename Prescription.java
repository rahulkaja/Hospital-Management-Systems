import java.util.List;

public class Prescription {
    private int prescriptionID; // Only accessible within the Prescription class
    private Doctor doctor; // Only accessible within the Prescription class
    protected Patient patient; // Accessible in subclasses and same package
    private List<String> medications; // Only accessible within the Prescription class
    protected String dosageInstructions; // Accessible in subclasses and same package
    private Pharmacy pharmacy; // Only accessible within the Prescription class
    public String prescriptionDate; // Accessible from any class

    // Constructor (public to allow external access when creating instances)
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

    // Method to check medication availability (public to allow external access)
    public void checkMedicationAvailability() {
        for (String medication : medications) {
            boolean isAvailable = pharmacy.isMedicationAvailable(medication);
            System.out.println("Medication: " + medication + " is " + (isAvailable ? "available" : "not available") + " at the pharmacy.");
        }
    }

    // Protected method, accessible in subclasses and within the same package
    protected void displayPrescriptionDetails() {
        System.out.println("\nPrescription ID: " + prescriptionID);
        System.out.println("Patient: " + patient.getName());
        System.out.println("Doctor: " + doctor.getName());
        System.out.println("Prescribed Medications: " + medications);
        System.out.println("Dosage Instructions: " + dosageInstructions);
        System.out.println("Prescription Date: " + prescriptionDate);
    }

    // Getters and Setters
    public int getPrescriptionID() {
        return prescriptionID;
    }

    // Setting prescriptionID privately to limit external modification
    private void setPrescriptionID(int prescriptionID) {
        this.prescriptionID = prescriptionID;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<String> getMedications() {
        return medications;
    }

    // Protected to allow modification in subclasses
    protected void setMedications(List<String> medications) {
        this.medications = medications;
    }

    public String getDosageInstructions() {
        return dosageInstructions;
    }

    public void setDosageInstructions(String dosageInstructions) {
        this.dosageInstructions = dosageInstructions;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public String getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(String prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }
}
