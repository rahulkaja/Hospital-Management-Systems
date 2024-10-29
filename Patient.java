import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Patient {
    int patientID;
    String name;
    String bloodGroup;
    Doctor doctor; // Reference to the assigned doctor
    int age;
    LocalDate registrationDate;
    String patientType; // Inpatient or Outpatient
    String phoneNumber;
    String address;
    LocalDate admissionDate;
    LocalDate dischargeDate;
    String gender;
    String emergencyContactName;
    String emergencyContactNumber;
    String emergencyContactRelation;
    String allergies;
    Insurance insurance;
    MedicalRecord medicalRecord; // Link to the MedicalRecord class
    String currentMedication;
    String roomNumber; // Room number can be a class
    String prescription; // Prescription can be a class with more details

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

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter patient name: ");
        String name = sc.nextLine();

        System.out.print("Enter blood group: ");
        String bloodGroup = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter registration date (dd/MM/yyyy): ");
        String registrationDate = sc.nextLine();

        System.out.print("Enter patient type (Inpatient/Outpatient): ");
        String patientType = sc.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = sc.nextLine();

        System.out.print("Enter address: ");
        String address = sc.nextLine();

        System.out.print("Enter gender: ");
        String gender = sc.nextLine();

        System.out.print("Enter emergency contact name: ");
        String emergencyContactName = sc.nextLine();

        System.out.print("Enter emergency contact relation: ");
        String emergencyContactRelation = sc.nextLine();

        System.out.print("Enter emergency contact number: ");
        String emergencyContactNumber = sc.nextLine();

        System.out.print("Enter allergies (if any): ");
        String allergies = sc.nextLine();

        System.out.print("Enter insurance provider: ");
        String insuranceProvider = sc.nextLine();

        System.out.print("Enter insurance policy number: ");
        String insurancePolicyNo = sc.nextLine();

        System.out.print("Enter insurance coverage start date (dd/MM/yyyy): ");
        String coverageStartDate = sc.nextLine();

        System.out.print("Enter insurance coverage end date (dd/MM/yyyy): ");
        String coverageEndDate = sc.nextLine();

        // Collect medical record details
        System.out.print("Enter record ID for Medical Record: ");
        int recordID = sc.nextInt();
        sc.nextLine();

        List<String> pastDiagnoses = new ArrayList<>();
        System.out.print("Enter past diagnoses (comma-separated): ");
        String[] diagnosisInput = sc.nextLine().split(",");
        for (String diagnosis : diagnosisInput) {
            pastDiagnoses.add(diagnosis.trim());
        }

        List<Treatment> treatmentHistory = new ArrayList<>();
        // You may want to prompt user to enter treatment details or create Treatment objects beforehand

        List<String> medications = new ArrayList<>();
        System.out.print("Enter medications (comma-separated): ");
        String[] medicationInput = sc.nextLine().split(",");
        for (String medication : medicationInput) {
            medications.add(medication.trim());
        }

        System.out.print("Enter additional notes for Medical Record: ");
        String notes = sc.nextLine();

        // Create the MedicalRecord instance
        MedicalRecord medicalRecord = new MedicalRecord(recordID, null, pastDiagnoses, treatmentHistory, medications, allergies, notes);

        // Create Patient instance
        Patient patient = new Patient(name, bloodGroup, age, registrationDate, patientType, phoneNumber, address, gender, 
                                      emergencyContactName, emergencyContactNumber, emergencyContactRelation, allergies, 
                                      insuranceProvider, insurancePolicyNo, coverageStartDate, coverageEndDate, 
                                      medicalRecord, "", "", "");
        
        patient.displayDetails();
    }
}
