import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HealthcareSystem {
    private List<Patient> patients;
    private List<Room> rooms;
    private Pharmacy pharmacy;
    private List<Prescription> prescriptions;
    private List<Doctor> doctors;
    private int patientIDCounter = 1;
    private int prescriptionIDCounter = 1;

    public HealthcareSystem() {
        initializeSystem();
    }

    private void initializeSystem() {
        patients = new ArrayList<>();
        rooms = new ArrayList<>(Arrays.asList(
            new Room("101", Room.RoomType.GENERAL, 500),
            new Room("102", Room.RoomType.SEMI_PRIVATE, 1000),
            new Room("103", Room.RoomType.PRIVATE, 1500),
            new Room("ICU-1", Room.RoomType.ICU, 2500)
        ));
        
        pharmacy = new Pharmacy("Central Pharmacy");
        prescriptions = new ArrayList<>();
        doctors = new ArrayList<>(Arrays.asList(
            new Doctor("Dr. Smith", "Cardiology"),
            new Doctor("Dr. Emily", "Neurology"),
            new Doctor("Dr. John", "Oncology")
        ));
        
        stockPharmacy();
    }

    private void stockPharmacy() {
        pharmacy.addMedication("Aspirin", 100);
        pharmacy.addMedication("Paracetamol", 150);
        pharmacy.addMedication("Ibuprofen", 120);
        System.out.println("Pharmacy stocked with initial medications.");
    }

    public Patient admitPatient(String name, Patient.BloodGroup bloodGroup, int age, String phoneNumber, String address, String gender) {
        EmergencyContact emergencyContact = new EmergencyContact("John Doe", "1234567890", "Brother");
        Insurance insurance = new Insurance("XYZ Health Insurance", "ABC123", "01/01/2024", "31/12/2024");
        MedicalRecord medicalRecord = new MedicalRecord(patientIDCounter, "No major health issues", LocalDate.now());

        Patient patient = new Patient(name, bloodGroup, age, phoneNumber, address, gender, emergencyContact, medicalRecord, insurance);
        patient.setPatientID(patientIDCounter++);
        patients.add(patient);
        System.out.println("Admitted " + patient);
        return patient;
    }

    public void assignRoomToPatient(Patient patient, Room.RoomType roomType) {
        for (Room room : rooms) {
            if (room.getRoomType() == roomType && !room.isOccupied()) {
                room.checkIn(patient);
                System.out.println("Room assigned: " + room);
                return;
            }
        }
        System.out.println("No available rooms of type " + roomType);
    }

    public void createPrescription(Patient patient, Doctor doctor, List<String> medications, String dosageInstructions) {
        Prescription prescription = new Prescription(
            prescriptionIDCounter++, doctor, patient, medications, dosageInstructions, pharmacy, LocalDate.now().toString()
        );

        prescription.checkMedicationAvailability();
        prescriptions.add(prescription);
        System.out.println("Created " + prescription);
    }

    public void dischargePatient(Patient patient) {
        for (Room room : rooms) {
            if (room.getCurrentPatient() == patient) {
                room.checkOut();
                System.out.println("Discharged " + patient.getName());
                return;
            }
        }
        System.out.println("Patient not found in any room.");
    }

    public void listAllPatients() {
        System.out.println("Current Patients:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    public static void main(String[] args) {
        HealthcareSystem system = new HealthcareSystem();

        Patient patient = system.admitPatient("Alice Brown", Patient.BloodGroup.A_POSITIVE, 30, "123-456-7890", "123 Main St", "Female");
        Doctor doctor = system.doctors.get(0);

        system.assignRoomToPatient(patient, Room.RoomType.SEMI_PRIVATE);
        system.createPrescription(patient, doctor, Arrays.asList("Aspirin", "Ibuprofen"), "Take twice daily after meals");
        system.listAllPatients();
        system.dischargePatient(patient);
    }
}
