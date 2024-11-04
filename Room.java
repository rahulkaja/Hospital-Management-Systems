public class Room {
   private String roomNumber; // Unique identifier for the room
    private String roomType; // Type of room (e.g., , shared, ICU)
    private boolean isOccupied; // Status indicating if the room is currently occupied
   private  double dailyRate; // Cost of the room per day
   private Patient currentPatient;
    private HospitalStaff nurse; // Patient currently occupying the room 
    // Constructor
    public Room(String roomNumber, String roomType, double dailyRate) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isOccupied = false; // Initially, the room is not occupied
        this.dailyRate = dailyRate;
        this.currentPatient = null; // No patient assigned initially
    }

    // Method to check in a patient to the room
    public void checkIn(Patient patient) {
        if (!isOccupied) {
            this.currentPatient = patient;
            this.isOccupied = true;
            System.out.println("Patient " + patient.name + " has been checked into room " + roomNumber + ".");
        } else {
            System.out.println("Room " + roomNumber + " is already occupied.");
        }
    }

    // Method to check out the current patient from the room
    public void checkOut() {
        if (isOccupied) {
            System.out.println("Patient " + currentPatient.name + " has been checked out from room " + roomNumber + ".");
            this.currentPatient = null; // No patient after checkout
            this.isOccupied = false; // Room is now unoccupied
        }
        else {
            System.out.println("Room " + roomNumber + " is already vacant.");
        }
    }

    // Method to display room details
    public void displayRoomDetails() {
        System.out.println("\nRoom Details:");
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Room Type: " + roomType);
        System.out.println("Daily Rate: $" + dailyRate);
        System.out.println("Occupied: " + (isOccupied ? "Yes" : "No"));
        if (isOccupied) {
            System.out.println("Current Patient: " + currentPatient.name);
        }
    }

    // Getters and Setters
    public String getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public Patient getCurrentPatient() {
        return currentPatient;
    }
}
