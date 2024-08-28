
package control;

import entity.Donation;
import adt.DoublyLinkedList;
import adt.SortedListInterface;
import boundary.CharitySystemUI;
import boundary.DonationManagementUI;


import java.util.Iterator;
/**
 *
 * @author Adriel
 */

public class DonationManagement {

    //Creating relevant objects
    private DonationManagementUI donationManagementUI = new DonationManagementUI();
    private DonationManagementInitializer donationInitializer = new DonationManagementInitializer();
    private SortedListInterface<Donation> donationList = donationInitializer.initiateDonations();
    
    //Constructor
    public DonationManagement(){
        
    }
    
    
    public void donationSelection(){
        boolean cont = true;
        while(cont){
            
        
        switch(donationManagementUI.donManMenu()){
                case 1: 
                    addDonation();
                    break;

                case 2: 
                    removeDonation();
                    break;

                case 3: 
                    searchDonation();
                    break;

                case 4:
                    amendDonationMenu();
                    break;

                case 5:
                    viewDonation();
                    break;

                case 6: 
                    generateReportMenu();
                    break;

                default:
                    cont = false;
                    break;

            }
        }
    }
        

    public SortedListInterface<Donation> getDonationList() {
        return donationList;
    }
    
    
    //For adding a new Donation
    public void addDonation(){
        donationManagementUI.addNewDonationMenu();
        
    }
    
    public boolean addNewDonation(Donor donor, String itemDonated, String category, int quantity, double valuePerQuantity){
        
        donationList.add(new Donation(donor, itemDonated, category, quantity, valuePerQuantity));
        
        return true;
    }
    
    
    //For removing a Donation
    public boolean removeDonation(){
        boolean result = false;
        
        viewDonation();
        donationManagement.searchDonation(input.nextLine());
        
        //To continue
        if(donationList.remove(donation)){
            
            result = true;
        }
        
        return result;
    }
    
    //To implement using iterator?
    public Donation searchDonation(String item){
        for (Donation donation : donationList) {
    if (donation.getItemDonated().equalsIgnoreCase("SpecificItem")) {
        Donor donor = donation.getDonor();
        System.out.println("Donor Name: " + donor.getName());
        break; // If you only want the first match
    }
}
        return donationList.search(donationList.getEntry(Integer.MIN_VALUE));
        
    }
    
    public boolean amendDonation(Donation donationName){
        
        //Use search
        boolean result = false;
        
        Donation entry = getDonation(donationManagementUI.amendDonationMenu());
        entry.toString();
        
        
        return result;
        
    }
    
    public Donation getDonation(int position){
        
        return donationList.getEntry(position);
    }
    
    public void viewDonation(){
        donationManagementUI.viewDonationMenu();
    }
    
    public void displayDonation(){
        donationList.toString();
    }
    
    public void generateReport(){
        switch(donationManagementUI.generateReportMenu()){
            case 1:
                //To sort and then to display
                break;
                
            case 2:
                //Number of items per category
                break;
                
            case 3:
                //Donated items sorted by Donor
                break;
                
            default:
                break;
        }
        //ToString method, written in report format
    }
    
}
