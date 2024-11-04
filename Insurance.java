public class Insurance {
    private String provider;
    private String policyNumber;
    private String startDate;
    private String endDate;

    public Insurance(String provider, String policyNumber, String startDate, String endDate) {
        this.provider = provider;
        this.policyNumber = policyNumber;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Insurance Provider: " + provider + ", Policy Number: " + policyNumber;
    }
}
