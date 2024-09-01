package entity;

//Author name : Yeoh Qi yao
//Student ID : 23WMR07680
//Programme : RSD2S1G1
public class Donee implements Comparable<Donee> {

    private String doneeName;
    private String doneeType;
    private String doneeID;
    private String doneePhone;
    private int doneeReceived;
    private String doneeDateCreated;

    // Constructor 
    public Donee(String doneeName) {
        this.doneeName = doneeName;
    }

    public Donee(String doneeName, String doneeType, String doneeID, String doneePhone, int doneeReceived, String doneeDateCreated) {
        this.doneeName = doneeName;
        this.doneeType = doneeType;
        this.doneeID = doneeID;
        this.doneePhone = doneePhone;
        this.doneeReceived = doneeReceived;
        this.doneeDateCreated = doneeDateCreated;
    }

    public void addDonation(int amount) {
        if (amount > 0) {
            doneeReceived += amount;
        } else {
            System.out.println("Donation amount must be positive.");
        }
    }

    // Add this method to get the donations received times
    public int getDonationsReceivedTimes() {
        return doneeReceived;
    }

    // Getters and Setters
    public String getDoneeName() {
        return doneeName;
    }

    public void setDoneeName(String doneeName) {
        this.doneeName = doneeName;
    }

    public String getDoneeType() {
        return doneeType;
    }

    public void setDoneeType(String doneeType) {
        this.doneeType = doneeType;
    }

    public String getDoneeID() {
        return doneeID;
    }

    public void setDoneeID(String doneeIC) {
        this.doneeID = doneeIC;
    }

    public String getDoneePhone() {
        return doneePhone;
    }

    public void setDoneePhone(String doneePhone) {
        this.doneePhone = doneePhone;
    }

    public int getDoneeReceived() {
        return doneeReceived;
    }

    public void setDoneeReceived(int doneeReceived) {
        this.doneeReceived = doneeReceived;
    }

    public String getDoneeDateCreated() {
        return doneeDateCreated;
    }

    public void setDoneeDateCreated(String doneeDateDonated) {
        this.doneeDateCreated = doneeDateDonated;
    }

    @Override
    public int compareTo(Donee other) {
        return this.doneeName.compareTo(other.doneeName);
    }

    @Override
    public String toString() {
        return String.format("| %-22s | %-15s | %-15s | %-15s | %-22s | %-18s |",
                doneeName, doneeType, doneeID, doneePhone, doneeReceived, doneeDateCreated);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Donee donee = (Donee) obj;
        return doneeName.equals(donee.doneeName);
    }

//For comparing
    @Override
    public int hashCode() {
        return doneeName.hashCode();
    }
}
