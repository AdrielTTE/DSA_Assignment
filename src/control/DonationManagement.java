
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
    
    //This is the latest change
   
    
    
}
