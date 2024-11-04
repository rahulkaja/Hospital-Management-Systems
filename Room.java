public class Room {
    private String roomNumber;
    private RoomType roomType;
    private boolean isOccupied;
    private Patient currentPatient;
 
    public Room(String roomNumber, RoomType roomType, double dailyRate) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isOccupied = false;
        this.currentPatient = null;
    }
 
    public void checkIn(Patient patient) {
        if (!isOccupied) {
            this.currentPatient = patient;
            this.isOccupied = true;
            System.out.println("Patient " + patient.getName() + " has been checked into room " + roomNumber + ".");
        } else {
            System.out.println("Room " + roomNumber + " is already occupied.");
        }
    }
 
    public void checkOut() {
        if (isOccupied) {
            System.out.println("Patient " + currentPatient.getName() + " has been checked out from room " + roomNumber + ".");
            this.currentPatient = null;
            this.isOccupied = false;
        } else {
            System.out.println("Room " + roomNumber + " is already vacant.");
        }
    }
 
    public RoomType getRoomType() {
        return roomType;
    }
 
    public boolean isOccupied() {
        return isOccupied;
    }
 
    public Patient getCurrentPatient() {
        return currentPatient;
    }
 
    public enum RoomType {
        GENERAL, SEMI_PRIVATE, PRIVATE, ICU
    }
 }
 
