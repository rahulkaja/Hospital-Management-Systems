import java.time.Duration;
import java.time.LocalDateTime;

public class Labs {
    protected Patient patient;
    private Doctor doctor;
    private HospitalStaff hospitalStaff;
   private  Equipment equipment;
    private Tests test;
   private  Appointment appointment;
    private Room room;

    // Additional attributes
    private HospitalStaff labTechnician;
    private LocalDateTime testDateTime;
    private LocalDateTime testCompletionTime;
    private String testResults;
   private String status; 
    private double cost;
    String labType;
    Duration testDuration;
    String notes;

    // Constructor to initialize the primary fields
    public Labs(Patient patient, Doctor doctor, HospitalStaff hospitalStaff, Equipment equipment, Tests test, Appointment appointment, Room room, HospitalStaff labTechnician, LocalDateTime testDateTime) {
        this.patient = patient;
        this.doctor = doctor;
        this.hospitalStaff = hospitalStaff;
        this.equipment = equipment;
        this.test = test;
        this.appointment = appointment;
        this.room = room;
        this.labTechnician = labTechnician;
        this.testDateTime = testDateTime;
    }
    // Additional Getters and Setters for new attributes
    public LocalDateTime getTestCompletionTime() { 
        return testCompletionTime;
    }
    public void setTestCompletionTime(LocalDateTime testCompletionTime) { 
        this.testCompletionTime = testCompletionTime; 
    }
    public String getTestResults() { 
        return testResults;
    }
    public void setTestResults(String testResults) { 
        this.testResults = testResults; 
    }
    public String getStatus() { return status; }
    public void setStatus(String status) { 
        this.status = status; 
    }
    public double getCost() { 
        return cost; 
    }
    public void setCost(double cost) {
         this.cost = cost; 
    }
    public String getLabType() { 
        return labType; 
    }
    public void setLabType(String labType) { 
        this.labType = labType; 
    }
    public Duration getTestDuration() { 
        return testDuration;
    }
    public void setTestDuration(Duration testDuration) { 
        this.testDuration = testDuration;
    }
    public String getNotes() { 
        return notes; 
    }
    public void setNotes(String notes) {
         this.notes = notes; 
    }
    // Additional methods can go here (e.g., calculate cost, update status)
}
