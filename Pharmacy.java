import java.util.HashMap;
import java.util.Map;

public class Pharmacy {
    private String pharmacyName;
    private Map<String, Integer> medicationStock;

    public Pharmacy(String pharmacyName) {
        this.pharmacyName = pharmacyName;
        this.medicationStock = new HashMap<>();
    }

    public void addMedication(String medication, int quantity) {
        if (medication == null || medication.isEmpty()) {
            throw new IllegalArgumentException("Medication name cannot be null or empty.");
        }
        medicationStock.put(medication, medicationStock.getOrDefault(medication, 0) + quantity);
    }

    public void removeMedication(String medication, int quantity) throws Exception {
        if (!medicationStock.containsKey(medication)) {
            throw new Exception("Medication not in stock.");
        }
        
        int currentStock = medicationStock.get(medication);
        if (currentStock < quantity) {
            throw new Exception("Not enough stock to remove " + quantity + " units of " + medication + ".");
        }

        medicationStock.put(medication, currentStock - quantity);
    }

    public boolean isMedicationAvailable(String medication) {
        return medicationStock.getOrDefault(medication, 0) > 0;
    }

    @Override
    public String toString() {
        return "Pharmacy [name=" + pharmacyName + ", stock=" + medicationStock + "]";
    }

    // Getters and displayStock method here
}
