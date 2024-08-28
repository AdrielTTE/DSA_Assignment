package entity;

/**
 *
 * @author Amanda Lee
 */

public class Donor implements Comparable<Donor> {
    private String donorName;
    private String donorType;
    private int donorIC;
    private int donorPhone;
    private double donorDonated;
    private String donorDateDonated;  

    // Constructor 
    public Donor(String donorName) {
        this.donorName = donorName;
    }

    public Donor(String donorName, String donorType, int donorIC, int donorPhone, double donorDonated, String donorDateDonated) {
        this.donorName = donorName;
        this.donorType = donorType;
        this.donorIC = donorIC;
        this.donorPhone = donorPhone;
        this.donorDonated = donorDonated;
        this.donorDateDonated = donorDateDonated;
    }

    public Donor(){
        
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

    public int getDonorIC() {
        return donorIC;
    }

    public void setDonorIC(int donorIC) {
        this.donorIC = donorIC;
    }

    public int getDonorPhone() {
        return donorPhone;
    }

    public void setDonorPhone(int donorPhone) {
        this.donorPhone = donorPhone;
    }

    public double getDonorDonated() {
        return donorDonated;
    }

    public void setDonorDonated(double donorDonated) {
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
        return  "[---------------Donor---------------]" + 
                "\nName = " + donorName + 
                "\nType = " + donorType + 
                "\nIC = " + donorIC +
                "\nPhone = " + donorPhone + 
                "\nAmount Donated = RM " + donorDonated + 
                "\nDate Donated = " + donorDateDonated;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Donor donor = (Donor) obj;
        return donorName.equals(donor.donorName);
    }

//For comparing
    @Override
    public int hashCode() {
        return donorName.hashCode();
    }
}