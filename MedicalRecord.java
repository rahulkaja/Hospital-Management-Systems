import java.time.LocalDate;

public class MedicalRecord {
    private int recordID;
    private String medicalHistory;
    private LocalDate recordDate;

    public MedicalRecord(int recordID, String medicalHistory, LocalDate recordDate) {
        this.recordID = recordID;
        this.medicalHistory = medicalHistory;
        this.recordDate = recordDate;
    }

    public void displayMedicalRecord() {
        System.out.println("Medical Record ID: " + recordID);
        System.out.println("Medical History: " + medicalHistory);
        System.out.println("Record Date: " + recordDate);
    }
}
