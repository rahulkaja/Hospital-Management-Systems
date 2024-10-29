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

    // Additional attributes
    String manufacturer;
    String serialNumber;
    Date warrantyExpirationDate;
    double maintenanceCost;
    String location;
    double operatingHours;
    String condition;
    Date calibrationDate;
    List <UsageLog> usageLogs; // Log of each usage
    Insurance insuranceDetails; // Custom class for insurance
    Date decommissionDate;
    public String getManufacturer() { 
        return manufacturer; 
    }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public Date getWarrantyExpirationDate() { return warrantyExpirationDate; }
    public void setWarrantyExpirationDate(Date warrantyExpirationDate) { this.warrantyExpirationDate = warrantyExpirationDate; }

    public double getMaintenanceCost() { return maintenanceCost; }
    public void setMaintenanceCost(double maintenanceCost) { this.maintenanceCost = maintenanceCost; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public double getOperatingHours() { return operatingHours; }
    public void setOperatingHours(double operatingHours) { this.operatingHours = operatingHours; }

    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }

    public Date getCalibrationDate() { return calibrationDate; }
    public void setCalibrationDate(Date calibrationDate) { this.calibrationDate = calibrationDate; }

    public List<UsageLog> getUsageLogs() { return usageLogs; }
    public void setUsageLogs(List<UsageLog> usageLogs) { this.usageLogs = usageLogs; }

    public Insurance getInsuranceDetails() { return insuranceDetails; }
    public void setInsuranceDetails(Insurance insuranceDetails) { this.insuranceDetails = insuranceDetails; }

    public Date getDecommissionDate() { return decommissionDate; }
    public void setDecommissionDate(Date decommissionDate) { this.decommissionDate = decommissionDate; }
}
