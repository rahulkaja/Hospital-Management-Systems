
public class Patient {
    private int patientID;
    private String name;
    private BloodGroup bloodGroup;
    private int age;
    private String phoneNumber;
    private String address;
    private String gender;
    private EmergencyContact emergencyContact;
    private MedicalRecord medicalRecord;
    private Insurance insurance;

    public Patient(String name, BloodGroup bloodGroup, int age, String phoneNumber, String address, String gender,
                   EmergencyContact emergencyContact, MedicalRecord medicalRecord, Insurance insurance) {
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gender = gender;
        this.emergencyContact = emergencyContact;
        this.medicalRecord = medicalRecord;
        this.setInsurance(insurance);
    }

    public Insurance getInsurance() {
        return insurance;
        
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
        
    }

    public String getName() {
        return name;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public enum BloodGroup {
        A_POSITIVE, A_NEGATIVE, B_POSITIVE, B_NEGATIVE, AB_POSITIVE, AB_NEGATIVE, O_POSITIVE, O_NEGATIVE
    }
}

class EmergencyContact {
    private String name;
    private String phoneNumber;
    private String relation;

    public EmergencyContact(String name, String phoneNumber, String relation) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.relation = relation;
    }
}
