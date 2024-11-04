import java.util.List;

public class Prescription {
    private int prescriptionID;
    private Doctor doctor;
    private Patient patient;
    private List<String> medications;
    private String dosageInstructions;
    private Pharmacy pharmacy;
    private String prescriptionDate;

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

    public void checkMedicationAvailability() {
        for (String medication : medications) {
            boolean isAvailable = pharmacy.isMedicationAvailable(medication);
            System.out.println("Medication: " + medication + " is " + (isAvailable ? "available" : "not available") + " at the pharmacy.");
        }
    }

    @Override
    public String toString() {
        return "Prescription [ID=" + prescriptionID + ", patient=" + patient.getName() + ", medications=" + medications + "]";
    }
}
