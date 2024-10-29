import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Insurance {
    private String providerName;
    private String policyNumber;
    private LocalDate coverageStartDate;
    private LocalDate coverageEndDate;

    // Constructor
    public Insurance(String providerName, String policyNumber, String coverageStartDate, String coverageEndDate) {
        this.providerName = providerName;
        this.policyNumber = policyNumber;

        // Parse the coverage start and end dates
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            this.coverageStartDate = LocalDate.parse(coverageStartDate, formatter);
            this.coverageEndDate = LocalDate.parse(coverageEndDate, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
            this.coverageStartDate = null;
            this.coverageEndDate = null;
        }
    }

    @Override
    public String toString() {
        return "Provider: " + providerName +
               ", Policy Number: " + policyNumber +
               ", Coverage Start Date: " + (coverageStartDate != null ? coverageStartDate.toString() : "N/A") +
               ", Coverage End Date: " + (coverageEndDate != null ? coverageEndDate.toString() : "N/A");
    }

    // Getters and Setters for future access if needed
    public LocalDate getCoverageStartDate() {
        return coverageStartDate;
    }

    public void setCoverageStartDate(String coverageStartDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            this.coverageStartDate = LocalDate.parse(coverageStartDate, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
            this.coverageStartDate = null;
        }
    }

    public LocalDate getCoverageEndDate() {
        return coverageEndDate;
    }

    public void setCoverageEndDate(String coverageEndDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            this.coverageEndDate = LocalDate.parse(coverageEndDate, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use dd/MM/yyyy.");
            this.coverageEndDate = null;
        }
    }
}
