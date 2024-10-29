import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Doctor extends HospitalStaff {
    private String specialization;
    private String doctorType; // Full-time, Part-time, Visiting
    private int numberOfPatients; // Current workload
    private List<Patient> consultationHistory; // List of patients

    // Constructor
    public Doctor(String name, int age, String department, String specialization, String joiningDate, 
                  double salary, String doctorType, String shiftTiming, String contactNo) {
        super(name, age, department, "Doctor", "Medical", joiningDate, contactNo, salary, shiftTiming);
        this.specialization = specialization;
        this.doctorType = doctorType;
        this.consultationHistory = new ArrayList<>();
    }

    // Add a patient to consultation history
    public void addConsultation(Patient patient) {
        this.consultationHistory.add(patient);
        this.numberOfPatients++;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getNumberOfPatients() {
        return numberOfPatients;
    }

    public List<Patient> getConsultationHistory() {
        return consultationHistory;
    }

    // Display Doctor Details
    @Override
    public void displayDetails() {
        super.displayDetails(); // Display general hospital staff details
        System.out.println("Specialization: " + specialization);
        System.out.println("Doctor Type: " + doctorType);
        System.out.println("Number of Patients: " + numberOfPatients);
        System.out.println("Consultation History: " + consultationHistory.size() + " patients");
    }
}
