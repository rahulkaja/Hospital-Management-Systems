import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Patient {
    // Private fields for sensitive data
    private int patientID;
    private MedicalRecord medicalRecord;
    private Insurance insurance;
    private String emergencyContactName;
    private String emergencyContactNumber;
    private String emergencyContactRelation;
    private String allergies;
    private String currentMedication;
    private String prescription;
    private LocalDate admissionDate;
    private LocalDate dischargeDate;

    // Protected fields for general information
    protected String name;
    protected String bloodGroup;
    protected Doctor doctor;
    protected int age;
    protected LocalDate registrationDate;
    protected String patientType;
    protected String phoneNumber;
    protected String address;
    protected String gender;
    protected String roomNumber;

    // Constructor
    public Patient(String name, String bloodGroup, int age, String registrationDate, String patientType,
                   String phoneNumber, String address, String gender, String emergencyContactName,
                   String emergencyContactNumber, String emergencyContactRelation, String allergies,
                   String insuranceProvider, String insurancePolicyNo, String coverageStartDate,
                   String coverageEndDate, MedicalRecord medicalRecord, String currentMedication,
                   String roomNumber, String prescription) {

        this.name = name;
        this.bloodGroup = bloodGroup;
        this.age = age;
        this.patientType = patientType;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gender = gender;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactNumber = emergencyContactNumber;
        this.emergencyContactRelation = emergencyContactRelation;
        this.allergies = allergies;
        this.medicalRecord = medicalRecord;
        this.currentMedication = currentMedication;
        this.roomNumber = roomNumber;
        this.prescription = prescription;

        // Parse the registration date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            this.registrationDate = LocalDate.parse(registrationDate, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid registration date format. Please use dd/MM/yyyy.");
            this.registrationDate = null;
        }

        // Initialize the Insurance object
        this.insurance = new Insurance(insuranceProvider, insurancePolicyNo, coverageStartDate, coverageEndDate);
    }

    // Getters and Setters for private fields
    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public String getEmergencyContactRelation() {
        return emergencyContactRelation;
    }

    public void setEmergencyContactRelation(String emergencyContactRelation) {
        this.emergencyContactRelation = emergencyContactRelation;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getCurrentMedication() {
        return currentMedication;
    }

    public void setCurrentMedication(String currentMedication) {
        this.currentMedication = currentMedication;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    // Display Patient details
    public void displayDetails() {
        System.out.println("\nPatient Details:");
        System.out.println("Name: " + name);
        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("Doctor: " + (doctor != null ? doctor.name : "No Doctor Assigned"));
        System.out.println("Age: " + age);
        System.out.println("Patient Type: " + patientType);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("Gender: " + gender);
        System.out.println("Emergency Contact: " + emergencyContactName + " (" + emergencyContactRelation + "), Phone: " + emergencyContactNumber);
        System.out.println("Allergies: " + allergies);
        System.out.println("Insurance: " + insurance); // Calls the toString() method of Insurance
        if (medicalRecord != null) {
            medicalRecord.displayMedicalRecord(); // Display medical record details
        }
        System.out.println("Current Medication: " + currentMedication);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Prescription: " + prescription);
        System.out.println("Registration Date: " + registrationDate);
    }
}
