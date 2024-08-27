
package control;

import entity.Donation;
import adt.DoublyLinkedList;
import adt.SortedListInterface;

import java.util.Iterator;
/**
 *
 * @author Adriel
 */

//Testing
public class DonationManagement {
    private SortedListInterface<Donation> donationList = new DoublyLinkedList<>();
    
    
    public boolean addNewDonation(Donor donor, String itemDonated, int quantity, double valuePerQuantity){
        
        donationList.add(new Donation(donor, itemDonated, quantity, valuePerQuantity));
        
        return true;
    }
    
    public boolean removeDonation(Donation donation){
        boolean result = false;
        if(donationList.remove(donation)){
            
            result = true;
        }
        
        return result;
    }
    
    public Donation searchDonation(Donation donationName){
        
        return donationList.search(donationName);
        
    }
    
    public boolean amendDonation(Donation donationName){
        
        //To find a way to access attributes in Donation
        boolean result = false;
        
        
        return result;
        
    }
    
    public void viewDonation(){
        donationList.toString();
    }
    
    public void generateReport(){
        System.out.println("Generate Report");
        System.out.println("==================================================");
        System.out.println("1. Total Valuation of Donations Report");
        System.out.println("2. Statistical Breakdown of Donated Items Report");
        System.out.println("3. Donated Items: Sorted by Donor");
        System.out.println("Please Enter Choice: ");
        //ToString method, written in report format
    }
    
}
