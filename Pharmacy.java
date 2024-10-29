import java.util.HashMap;
import java.util.Map;

public class Pharmacy {
    private String pharmacyName; // Name of the pharmacy
    private Map<String, Integer> medicationStock; // Maps medication names to their available quantities

    // Constructor
    public Pharmacy(String pharmacyName) {
        this.pharmacyName = pharmacyName;
        this.medicationStock = new HashMap<>();
    }

    // Method to add medications to the stock
    public void addMedication(String medication, int quantity) {
        medicationStock.put(medication, medicationStock.getOrDefault(medication, 0) + quantity);
        System.out.println(quantity + " units of " + medication + " added to the stock.");
    }

    // Method to remove medications from the stock
    public void removeMedication(String medication, int quantity) {
        if (medicationStock.containsKey(medication)) {
            int currentStock = medicationStock.get(medication);
            if (currentStock >= quantity) {
                medicationStock.put(medication, currentStock - quantity);
                System.out.println(quantity + " units of " + medication + " removed from the stock.");
            } else {
                System.out.println("Not enough stock to remove " + quantity + " units of " + medication + ".");
            }
        } else {
            System.out.println(medication + " is not in stock.");
        }
    }

    // Method to check if a medication is available
    public boolean isMedicationAvailable(String medication) {
        return medicationStock.containsKey(medication) && medicationStock.get(medication) > 0;
    }

    // Method to display all medications in stock
    public void displayStock() {
        System.out.println("\nCurrent Medication Stock in " + pharmacyName + ":");
        for (Map.Entry<String, Integer> entry : medicationStock.entrySet()) {
            System.out.println("Medication: " + entry.getKey() + ", Quantity: " + entry.getValue());
        }
    }

    // Getters and Setters
    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }
}
