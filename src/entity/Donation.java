package entity;

/**
 *
 * @author Adriel
 */

public class Donation implements Comparable<Donation>{
    
    private Donor donor;
    private String itemDonated;
    private int quantity;
    private double valuePerQuantity;
    private double totalValue;

    //Constructor
    
    public Donation(){
        
    }
    
    public Donation(Donor donor, String itemDonated, int quantity, double valuePerQuantity) {
        this.donor = donor;
        this.itemDonated = itemDonated;
        this.quantity = quantity;
        this.valuePerQuantity = valuePerQuantity;
        this.totalValue  = calcTotalValue();
    }

    //Getter
    public Donor getDonor() {
        return donor;
    }

    public String getItemDonated() {
        return itemDonated;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getValuePerQuantity() {
        return valuePerQuantity;
    }

    public double getTotalValue() {
        return totalValue;
    }

    //Setter
    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public void setItemDonated(String itemDonated) {
        this.itemDonated = itemDonated;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setValuePerQuantity(double valuePerQuantity) {
        this.valuePerQuantity = valuePerQuantity;
        
        
    }
    
    private double calcTotalValue(){
        return totalValue = quantity * valuePerQuantity;
    }

    @Override
    public int compareTo(Donation o) {
       
        return o.compareTo(this);
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
   

   
    @Override
    public String toString(){
        return "Name: " + donor + "\nItem Donated: " + itemDonated + "\nQuantity: " + quantity + "\nValue Per Quantity: " + valuePerQuantity + "\nTotal Value: " + totalValue;
    }
}
