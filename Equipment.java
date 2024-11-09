import java.util.Date;
import java.util.List;

public class Equipment {
    String equipmentName;
    String equipmentType;
    String department;
    HospitalStaff staff;
    Date dateOfPurchase;
    Date dateOfLastService;
    String serviceRecord;
    String manufacturer;
    String serialNumber;
    Date warrantyExpirationDate;
    double maintenanceCost;
    String location;
    double operatingHours;
    String condition;
    Date calibrationDate;
    List<UsageLog> usageLogs;
    Insurance insuranceDetails;
    Date decommissionDate;

    // Default constructor
    public Equipment() {}

    // Parameterized constructor
    public Equipment(String equipmentName, String equipmentType, String department, HospitalStaff staff, Date dateOfPurchase, Date dateOfLastService, String serviceRecord) {
        this.equipmentName = equipmentName;
        this.equipmentType = equipmentType;
        this.department = department;
        this.staff = staff;
        this.dateOfPurchase = dateOfPurchase;
        this.dateOfLastService = dateOfLastService;
        this.serviceRecord = serviceRecord;
    }

    // Additional Getters and Setters
    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public Date getWarrantyExpirationDate() { return warrantyExpirationDate; }
    public void setWarrantyExpirationDate(Date warrantyExpirationDate) { this.warrantyExpirationDate = warrantyExpirationDate; }

    public double getMaintenanceCost() { return maintenanceCost; }
    public void setMaintenanceCost(double maintenanceCost) { this.maintenanceCost = maintenanceCost; }

    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }

    public double getOperatingHours() { return operatingHours; }
    public void setOperatingHours(double operatingHours) { this.operatingHours = operatingHours; }
}
