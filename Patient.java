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
    String phoneNumber;
    String address;
    LocalDate admissionDate;
    LocalDate dischargeDate;
    String gender;
    String emergencyContactName;
    String emergencyContactNumber;
    String medicalHistory;
    String roomNumber;
    String prescription; // Prescription can be a class with more details
    Double totalBillDue;
    Double amountPaid;
    Double amountDue;

    // Constructor
    public Patient(String name, String bloodGroup, int age, String registrationDate) {
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.age = age;

        // Parse the registration date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            this.registrationDate = LocalDate.parse(registrationDate, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
            this.registrationDate = null;
        }
    }

    // Method to calculate AmountDue
    public void calculateAmountDue() {
        if (totalBillDue != null && amountPaid != null) {
            this.amountDue = totalBillDue - amountPaid;
        } else {
            this.amountDue = null;
        }
    }

    // Display Patient details
    public void displayDetails() {
        System.out.println("\nPatient Details:");
        System.out.println("Name: " + name);
        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("Doctor: " + (doctor != null ? doctor.DoctorName : "No Doctor Assigned"));
        System.out.println("Age: " + age);
        System.out.println("Registration Date: " + registrationDate);
        System.out.println("Total Bill: " + totalBillDue);
        System.out.println("Amount Paid: " + amountPaid);
        System.out.println("Amount Due: " + amountDue);
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
        sc.nextLine();  // Consume the newline

        System.out.print("Enter registration date (dd/MM/yyyy): ");
        String registrationDate = sc.nextLine();

        // Create a Patient object
        Patient patient = new Patient(name, bloodGroup, age, registrationDate);

        // Input Bill details
        System.out.print("Enter total bill due: ");
        patient.totalBillDue = sc.nextDouble();
        System.out.print("Enter amount paid: ");
        patient.amountPaid = sc.nextDouble();

        // Calculate the amount due
        patient.calculateAmountDue();

        // Display Patient details
        patient.displayDetails();
    }
}
