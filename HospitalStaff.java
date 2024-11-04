import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class HospitalStaff {
    protected int staffId;
    protected String name;
    protected LocalDate joiningDate;
    protected int age;
    protected String department;
    protected String position;
    protected String staffType; // Nurse, Janitor, Receptionist, etc.
    protected String contactNo;
    protected double salary;
    protected String shiftTiming; // Morning, Evening, Night
    protected int yearsOfExperience;
    protected boolean isAvailable;

    // Constructor
    public HospitalStaff(String name, int age, String department, String position, String staffType, 
                         String joiningDate, String contactNo, double salary, String shiftTiming) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.position = position;
        this.staffType = staffType;
        this.contactNo = contactNo;
        this.salary = salary;
        this.shiftTiming = shiftTiming;
        this.isAvailable = true; // By default, staff is available
        this.staffId++;

        // Parse the joining date
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

    // Display Staff Details
    public void displayDetails() {
        System.out.println("\nHospital Staff Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Department: " + department);
        System.out.println("Position: " + position);
        System.out.println("Staff Type: " + staffType);
        System.out.println("Contact No: " + contactNo);
        System.out.println("Joining Date: " + joiningDate);
        System.out.println("Shift Timing: " + shiftTiming);
        System.out.println("Years of Experience: " + yearsOfExperience);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
        System.out.println("Salary: " + salary);
    }
}
