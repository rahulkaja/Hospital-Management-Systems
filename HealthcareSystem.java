import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HealthcareSystem {
    private List<Patient> patients;
    private List<Room> rooms;
    private Pharmacy pharmacy;
    private List<Prescription> prescriptions;
    private List<Doctor> doctors;
    private List<Appointment> appointments;
    private List<Billing> billings;
    private List<Equipment> equipmentList;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public HealthcareSystem() {
        initializeSystem();
    }

    private void initializeSystem() {
        patients = new ArrayList<>();
        rooms = initializeRooms();
        pharmacy = new Pharmacy("Central Pharmacy");
        prescriptions = new ArrayList<>();
        doctors = initializeDoctors();
        appointments = new ArrayList<>();
        billings = new ArrayList<>();
        equipmentList = initializeEquipment();
    }

    private List<Room> initializeRooms() {
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room("101", Room.RoomType.GENERAL, 500));
        rooms.add(new Room("102", Room.RoomType.SEMI_PRIVATE, 1000));
        rooms.add(new Room("103", Room.RoomType.PRIVATE, 1500));
        rooms.add(new Room("ICU-1", Room.RoomType.ICU, 2500));
        return rooms;
    }

    private List<Doctor> initializeDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Dr. Alice", "Cardiology"));
        doctors.add(new Doctor("Dr. Bob", "Neurology"));
        return doctors;
    }

    private List<Equipment> initializeEquipment() {
        List<Equipment> equipmentList = new ArrayList<>();
        HospitalStaff staff = new HospitalStaff("Technician Joe", 40, "Maintenance", "Technician", "Support", "01/01/2023", "555-8765", 25000, "Day");

        // Using the parameterized constructor with parsed date
        equipmentList.add(new Equipment("MRI Machine", "Imaging", "Radiology", staff, parseDate("01/01/2022"), parseDate("01/01/2023"), "Operational"));
        
        // Using the default constructor and setting values manually
        Equipment xRayMachine = new Equipment();
        xRayMachine.equipmentName = "X-Ray Machine";
        xRayMachine.equipmentType = "Imaging";
        xRayMachine.department = "Radiology";
        xRayMachine.staff = staff;
        xRayMachine.dateOfPurchase = parseDate("01/06/2021");
        xRayMachine.dateOfLastService = parseDate("01/06/2022");
        xRayMachine.serviceRecord = "Operational";
        equipmentList.add(xRayMachine);

        return equipmentList;
    }

    private Date parseDate(String dateString) {
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
            return null;
        }
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Added patient: " + patient.getName());
    }

    public void assignRoomToPatient(Patient patient, Room.RoomType roomType) {
        Room availableRoom = findAvailableRoom(roomType);
        if (availableRoom != null) {
            availableRoom.checkIn(patient);
            System.out.println("Assigned room " + availableRoom + " to patient " + patient.getName());
        } else {
            System.out.println("No available room of type " + roomType);
        }
    }

    public Room findAvailableRoom(Room.RoomType roomType) {
        for (Room room : rooms) {
            if (room.getRoomType() == roomType && !room.isOccupied()) {
                return room;
            }
        }
        return null;
    }

    public boolean scheduleAppointment(Patient patient, Doctor doctor, LocalDateTime appointmentDate) {
        Appointment appointment = new Appointment(appointments.size() + 1, patient, doctor, appointmentDate);
        appointments.add(appointment);
        System.out.println("Scheduled appointment for patient " + patient.getName() + " with Doctor " + doctor.getName() + " on " + appointmentDate);
        return true;
    }

    public void createPrescription(Doctor doctor, Patient patient, List<String> medications, String dosageInstructions) {
        Prescription prescription = new Prescription(prescriptions.size() + 1, doctor, patient, medications, dosageInstructions, pharmacy, LocalDateTime.now().toString());
        prescriptions.add(prescription);
        System.out.println("Prescription created for patient " + patient.getName() + " by Dr. " + doctor.getName());
    }

    public void generateBill(Patient patient, HospitalStaff staff, List<String> itemizedCharges, double amountPaid, String paymentMethod) {
        Billing bill = new Billing(patient, staff, itemizedCharges, amountPaid, paymentMethod);
        billings.add(bill);
        System.out.println("Generated bill for patient " + patient.getName() + ". Total: " + bill.totalAmount + ", Due: " + bill.amountDue);
    }

    public void conductLabTest(Patient patient, Doctor doctor, Equipment equipment, String testType, LocalDateTime testDateTime) {
        Labs labTest = new Labs(patient, doctor, null, equipment, null, null, findAvailableRoom(Room.RoomType.GENERAL), null, testDateTime);
        System.out.println("Conducted " + testType + " test for patient " + patient.getName() + " using " + equipment.equipmentName);
    }

    public void demonstrateFunctionality() {
        Patient patient = new Patient("John Doe", Patient.BloodGroup.O_POSITIVE, 30, "555-1234", "123 Main St", "Male", null, null, null);
        addPatient(patient);

        assignRoomToPatient(patient, Room.RoomType.SEMI_PRIVATE);

        Doctor doctor = doctors.get(0);
        scheduleAppointment(patient, doctor, LocalDateTime.now().plusDays(1));

        List<String> medications = List.of("MedicationA", "MedicationB");
        createPrescription(doctor, patient, medications, "Take twice daily");

        List<String> charges = List.of("Consultation: 200", "Lab Test: 150");
        HospitalStaff staff = new HospitalStaff("Staff Member", 45, "Billing", "Accountant", "Admin", "01/01/2023", "555-5678", 30000, "Day");
        generateBill(patient, staff, charges, 200, "Cash");

        Equipment equipment = equipmentList.get(0);
        conductLabTest(patient, doctor, equipment, "MRI Scan", LocalDateTime.now());
    }

    public static void main(String[] args) {
        HealthcareSystem system = new HealthcareSystem();
        system.demonstrateFunctionality();
    }
}
