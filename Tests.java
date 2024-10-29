import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Tests extends Labs {
    // Attributes
    public int testID;                   // Unique identifier for the test
    public String testName;              // Name of the test
    public LocalDateTime testDate;       // Date and time the test was conducted
    public String testResult;             // Result of the test
    public String notes;                  // Additional notes related to the test
    public List<String> previousResults;  // List of previous test results for comparison

    // Constructor
    public Tests(Patient patient, Doctor doctor, HospitalStaff hospitalStaff, Equipment equipment, 
                 Tests test, Appointment appointment, Room room, HospitalStaff labTechnician, 
                 LocalDateTime testDateTime, int testID, String testName, LocalDateTime testDate) {
        super(patient, doctor, hospitalStaff, equipment, test, appointment, room, labTechnician, testDateTime);
        this.testID = testID;
        this.testName = testName;
        this.testDate = testDate;
        this.testResult = "Pending"; // Default result status
        this.notes = "";
        this.previousResults = new ArrayList<>();
    }

    // Method to display test details
    public void displayTestDetails() {
        System.out.println("\nTest Details:");
        System.out.println("Test ID: " + testID);
        System.out.println("Patient: " + (patient != null ? patient.name : "No Patient Assigned"));
        System.out.println("Test Name: " + testName);
        System.out.println("Test Date: " + testDate);
        System.out.println("Test Result: " + testResult);
        System.out.println("Notes: " + notes);
        if (!previousResults.isEmpty()) {
            System.out.println("Previous Results: " + String.join(", ", previousResults));
        } else {
            System.out.println("No Previous Results");
        }
    }

    // Method to set the test result
    public void setTestResult(String result) {
        this.testResult = result;
        System.out.println("Test result updated to: " + result);
    }

    // Method to add previous results
    public void addPreviousResult(String result) {
        this.previousResults.add(result);
        System.out.println("Previous result added: " + result);
    }

    // Method to add notes to the test
    public void addNotes(String note) {
        this.notes += note + " "; // Append note
        System.out.println("Note added: " + note);
    }
}
