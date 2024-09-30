import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class Doctor {
    int EmployeeID;
    String DoctorName;
    String Specialization;
    String Department;
    LocalDate JoiningDate;
    private Double Salary;
    public Doctor(String doctorName, String specialization, String department, String joiningDate, double salary) {
        this.DoctorName = doctorName;
        this.Specialization = specialization;
        this.Department = department;
        this.Salary = salary;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            this.JoiningDate = LocalDate.parse(joiningDate, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
            this.JoiningDate = null;
        }
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.Salary = salary;
        } else {
            System.out.println("Invalid salary amount.");
        }
    }

}
