import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Doctor {
    int employeeID;
    String doctorName;
    String contactNo;
    String specialization;
    String department;
    LocalDate joiningDate;
    String doctorType; // Full-time, Part-time, Visiting
    String shiftTiming; // Morning, Evening, Night
    int yearsOfExperience;
    int numberOfPatients; // Current workload
    boolean isAvailable;
    private Double salary;
    List<Patient> consultationHistory; // List of patients

    // Constructor
    public Doctor(String doctorName, String contactNo, String specialization, String department, 
                  String joiningDate, double salary, String doctorType, String shiftTiming) {
        this.doctorName = doctorName;
        this.contactNo = contactNo;
        this.specialization = specialization;
        this.department = department;
        this.salary = salary;
        this.doctorType = doctorType;
        this.shiftTiming = shiftTiming;
        this.isAvailable = true; // By default, the doctor is available
        this.consultationHistory = new ArrayList<>();
        employeeID++;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            this.joiningDate = LocalDate.parse(joiningDate, formatter);
            calculateYearsOfExperience();
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
            this.joiningDate = null;
        }
    }

    // Calculate Years of Experience
    public void calculateYearsOfExperience() {
        if (this.joiningDate != null) {
            LocalDate now = LocalDate.now();
            this.yearsOfExperience = Period.between(this.joiningDate, now).getYears();
        } else {
            this.yearsOfExperience = 0;
        }
    }

    // Add a patient to consultation history
    public void addConsultation(Patient patient) {
        this.consultationHistory.add(patient);
        this.numberOfPatients++;
    }

    // Set the availability status
    public void setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    // Getters and Setters for salary and other attributes
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary amount.");
        }
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getShiftTiming() {
        return shiftTiming;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public List<Patient> getConsultationHistory() {
        return consultationHistory;
    }
    // Display Doctor Details
    public void displayDetails() {
        System.out.println("\nDoctor Details:");
        System.out.println("Name: " + doctorName);
        System.out.println("Contact No: " + contactNo);
        System.out.println("Specialization: " + specialization);
        System.out.println("Department: " + department);
        System.out.println("Doctor Type: " + doctorType);
        System.out.println("Shift Timing: " + shiftTiming);
        System.out.println("Years of Experience: " + yearsOfExperience);
        System.out.println("Number of Patients: " + numberOfPatients);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }
}
