import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Patient {
    int patientID;
    String name;
    String bloodGroup;
    Doctor doctor;
    int age;
    LocalDate registrationDate;
    String patientType;
    String phoneNumber;
    String address;
    LocalDate admissionDate;
    LocalDate dischargeDate;
    String gender;
    String emergencyContactName;
    String emergencyContactNumber;
    String emergencyContactRelation;
    String allergies;
    String insuranceProvider;           
    String insurancePolicyNo;
    LocalDate insuranceValidity;
    String medicalHistory;
    String currentMedication;
    String roomNumber;
    String prescription; // Prescription can be a class with more details 
   

    // Constructor
    public Patient(String name, String bloodGroup, int age, String registrationDate, String patientType, 
                    String phoneNumber, String address, String gender, String emergencyContactName,
                    String emergencyContactNumber, String emergencyContactRelation, String allergies,
                    String insuranceProvider, String insurancePolicyNo, String insuranceValidity,
                    String medicalHistory, String currentMedication, String roomNumber, String prescription) {

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
        this.insuranceProvider = insuranceProvider;
        this.insurancePolicyNo = insurancePolicyNo;
        this.medicalHistory = medicalHistory;
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

        // Parse the insurance validity date
        try {
            this.insuranceValidity = LocalDate.parse(insuranceValidity, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid insurance validity date format. Please use dd/MM/yyyy.");
            this.insuranceValidity = null;
        }
    }

    // Display Patient details
    public void displayDetails() {
        System.out.println("\nPatient Details:");
        System.out.println("Name: " + name);
        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("Doctor: " + (doctor != null ? doctor.doctorName : "No Doctor Assigned"));
        System.out.println("Age: " + age);
        System.out.println("Patient Type: " + patientType);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("Gender: " + gender);
        System.out.println("Emergency Contact: " + emergencyContactName + " (" + emergencyContactRelation + "), Phone: " + emergencyContactNumber);
        System.out.println("Allergies: " + allergies);
        System.out.println("Insurance Provider: " + insuranceProvider);
        System.out.println("Insurance Policy No: " + insurancePolicyNo);
        System.out.println("Insurance Validity: " + insuranceValidity);
        System.out.println("Medical History: " + medicalHistory);
        System.out.println("Current Medication: " + currentMedication);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Prescription: " + prescription);
        System.out.println("Registration Date: " + registrationDate);
    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
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

        System.out.print("Enter insurance validity date (dd/MM/yyyy): ");
        String insuranceValidity = sc.nextLine();

        System.out.print("Enter medical history: ");
        String medicalHistory = sc.nextLine();

        System.out.print("Enter current medication: ");
        String currentMedication = sc.nextLine();

        System.out.print("Enter room number: ");
        String roomNumber = sc.nextLine();

        System.out.print("Enter prescription details: ");
        String prescription = sc.nextLine();

        Patient patient = new Patient(name, bloodGroup, age, registrationDate, patientType, phoneNumber, address, gender, 
                                      emergencyContactName, emergencyContactNumber, emergencyContactRelation, allergies, 
                                      insuranceProvider, insurancePolicyNo, insuranceValidity, medicalHistory, currentMedication, 
                                      roomNumber, prescription);
        patient.displayDetails();
    }
}
