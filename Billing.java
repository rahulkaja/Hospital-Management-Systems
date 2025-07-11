import java.util.List;

public class Billing {
    int billingID;
    Patient patient; // Link to the patient
    HospitalStaff generatedBy; // Hospital staff member who generated the bill
    List<String> itemizedCharges; // List of services or items billed as Service: Amount
    double totalAmount;
    double amountPaid;
    double amountDue;
    String paymentMethod; // Cash, Card, Insurance
    Insurance insurance; // Reference to patient's insurance

    // Constructor
    public Billing(Patient patient, HospitalStaff generatedBy, List<String> itemizedCharges, double amountPaid, String paymentMethod) {
        this.patient = patient;
        this.generatedBy = generatedBy; // Bill generated by staff
        this.itemizedCharges = itemizedCharges;
        this.totalAmount = calculateTotalAmount(itemizedCharges); // Calculate total from itemized charges
        this.amountPaid = amountPaid;
        this.amountDue = this.totalAmount - this.amountPaid;
        this.paymentMethod = paymentMethod;
        this.insurance = patient.getInsurance(); // Link to the patient's insurance details
    }

    // Calculate total amount based on itemized charges
    private double calculateTotalAmount(List<String> itemizedCharges) {
        double total = 0;
        // Assume each itemized charge represents a cost as a String in the format "Service:Amount"
        for (String charge : itemizedCharges) {
            String[] parts = charge.split(":");
            if (parts.length == 2) {
                try {
                    double amount = Double.parseDouble(parts[1].trim());
                    total += amount;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid charge amount format in: " + charge);
                }
            }
        }
        return total;
    }

    // Display billing details
    public void displayBillingDetails() {
        System.out.println("\nBilling Details for Patient: " + patient.getName());
        System.out.println("Generated By: " + generatedBy.name + " (Position: " + generatedBy.position + ")");
        System.out.println("Itemized Charges:");
        for (String charge : itemizedCharges) {
            System.out.println(charge);
        }
        System.out.println("Total Amount: " + totalAmount);
        System.out.println("Amount Paid: " + amountPaid);
        System.out.println("Amount Due: " + amountDue);
        System.out.println("Payment Method: " + paymentMethod);
        
        if (paymentMethod.equalsIgnoreCase("Insurance") && insurance != null) {
            System.out.println("Insurance Details: " + insurance); // Uses toString() from Insurance
        } else if (paymentMethod.equalsIgnoreCase("Insurance")) {
            System.out.println("No insurance details available.");
        }
    }

    public void addCharge(String charge) {
        this.itemizedCharges.add(charge);
        this.totalAmount = calculateTotalAmount(this.itemizedCharges);
        this.amountDue = this.totalAmount - this.amountPaid;
    }

    public void makePayment(double payment) {
        this.amountPaid += payment;
        this.amountDue = this.totalAmount - this.amountPaid;
    }
}
