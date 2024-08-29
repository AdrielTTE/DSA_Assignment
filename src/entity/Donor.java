package entity;

/**
 *
 * @author Amanda Lee
 */
public class Donor implements Comparable<Donor> {

    private String donorName;
    private String donorType;
    private String donorIC;
    private String donorPhone;
    private String donorDonated;
    private String donorDateDonated;

    // Constructor 
    public Donor() {

    }

    public Donor(String donorName) {
        this.donorName = donorName;
    }

    public Donor(String donorName, String donorType, String donorIC, String donorPhone, String donorDonated, String donorDateDonated) {
        this.donorName = donorName;
        this.donorType = donorType;
        this.donorIC = donorIC;
        this.donorPhone = donorPhone;
        this.donorDonated = donorDonated;
        this.donorDateDonated = donorDateDonated;
    }

    // Getters and Setters
    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getDonorType() {
        return donorType;
    }

    public void setDonorType(String donorType) {
        this.donorType = donorType;
    }

    public String getDonorIC() {
        return donorIC;
    }

    public void setDonorIC(String donorIC) {
        this.donorIC = donorIC;
    }

    public String getDonorPhone() {
        return donorPhone;
    }

    public void setDonorPhone(String donorPhone) {
        this.donorPhone = donorPhone;
    }

    public String getDonorDonated() {
        return donorDonated;
    }

    public void setDonorDonated(String donorDonated) {
        this.donorDonated = donorDonated;
    }

    public String getDonorDateDonated() {
        return donorDateDonated;
    }

    public void setDonorDateDonated(String donorDateDonated) {
        this.donorDateDonated = donorDateDonated;
    }

    @Override
    public int compareTo(Donor other) {
        return this.donorName.compareTo(other.donorName);
    }

    @Override
    public String toString() {
        return String.format("| %-22s | %-10s | %-15s | %-15s | %-10s | %-15s |",
                donorName, donorType, donorIC, donorPhone, donorDonated, donorDateDonated);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Donor donor = (Donor) obj;
        return donorName.equals(donor.donorName);
    }

    @Override
    public int hashCode() {
        return donorName.hashCode();
    }
}