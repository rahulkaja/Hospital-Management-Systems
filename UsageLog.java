import java.util.Date;

public class UsageLog {
    private Date usageDate;
    private HospitalStaff user; // assuming HospitalStaff is already defined
    private String purpose;

    // Constructor
    public UsageLog(Date usageDate, HospitalStaff user, String purpose) {
        this.usageDate = usageDate;
        this.user = user;
        this.purpose = purpose;
    }

    // Getters and Setters
    public Date getUsageDate() { return usageDate; }
    public void setUsageDate(Date usageDate) { this.usageDate = usageDate; }

    public HospitalStaff getUser() { return user; }
    public void setUser(HospitalStaff user) { this.user = user; }

    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }
}
