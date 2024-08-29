
package control;

/**
 *
 * @author Adriel
 */

import entity.Donation;
import entity.Donor;

import adt.DoublyLinkedList;
import adt.SortedListInterface;

import boundary.DonationManagementUI;

import dao.DonationManagementInitializer;


// Pass object as parameter to access from different classes
public class DonationManagement {

    //Creating relevant objects
    private DonationManagementUI donationManagementUI;
    private DonationManagementInitializer donationInitializer = new DonationManagementInitializer();
    private SortedListInterface<Donation> donationList = donationInitializer.initiateDonations();
    //private DonorManagement donorManagement;
    
    //Constructor
    public DonationManagement(){
        this.donationManagementUI = new DonationManagementUI(this);
    }
 
    
    public DonationManagement getDonationManagement(DonationManagement donationManagement){
        return donationManagement;
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
                    amendDonation();
                    break;

                case 5:
                    displayDonation();
                    break;

                case 6: 
                    generateReport();
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
     
        if(donationList.remove(donationList.getEntry(donationManagementUI.removeDonationMenu()))){
            
            result = true;
            donationManagementUI.removedDonation(result);
        }
        
        return result;
    }
   
    public SortedListInterface<Donation> searchDonation(){
        SortedListInterface<Donation> searchedDonationList = new DoublyLinkedList<>();
        Donation searchItem = new Donation();
        searchItem.setItemDonated(donationManagementUI.searchDonationMenu());
        int count=1;
        while(count <= donationList.getNumOfEntries()){
            searchedDonationList.add(donationList.search(searchItem));
            count++;
        }
       
        return searchedDonationList;
    }
        
    
    public void amendDonation(){
        
        //Use search
        boolean result = false;
        Donation amendDonation = new Donation();
        amendDonation = getDonation(donationManagementUI.amendDonationMenu());
        
        switch(donationManagementUI.attributeToChange(amendDonation)){
            case 1: 
                amendDonation.setDonor(donationManagementUI.changeDonor());
                break;
                
            case 2:
                amendDonation.setItemDonated(donationManagementUI.changeDonatedItem());
                break;
               
            case 3:
                amendDonation.setCategory(donationManagementUI.chooseCategories());
                
            case 4:
                amendDonation.setQuantity(donationManagementUI.changeQuantity());
                break;
                
            default: 
                amendDonation.setValuePerQuantity(donationManagementUI.changeValuePerItem());
                break;
            
        }
        
        donationManagementUI.displayChangedDonation(amendDonation);
        
    }
    
    public Donation getDonation(int position){
        return donationList.getEntry(position);
    }
    
    public void displayDonation(){
        
        switch(donationManagementUI.displayListMenu(donationList)){
            case 1:
                filter();
                break;
            
            default:
                //To add logic
                break;
                
            
        }
        
        
    }
   
   
    
    public void filter(){
        switch(donationManagementUI.filterBy()){
            case 1:
                filterDonor();
                break;
                
            case 2:
                searchDonation();
                break;
                
            case 3:
                filterByCategory();
                break;
        }
    }
    
    
    public SortedListInterface<Donation> filterByCategory(){
        SortedListInterface<Donation> searchedDonationList = new DoublyLinkedList<>();
        Donation searchItem = new Donation();
        searchItem.setCategory(donationManagementUI.chooseCategories());
        
        int count=1;
        while(count <= donationList.getNumOfEntries()){
            searchedDonationList.add(donationList.search(searchItem));
            count++;
        }
       
        return searchedDonationList;
    }
    
    public void filterDonor(){
        switch(donationManagementUI.getDonorAttribute()){
            case 1: 
                filterByDonorName();
                break;
                
            default:
                filterByDonorType();
                break;
                
        }
    }
    
    
    public SortedListInterface<Donation> filterByDonorName(){
        SortedListInterface<Donation> searchedDonationList = new DoublyLinkedList<>();
        Donation searchItem = new Donation();
        Donor searchItemDonor = new Donor("","","","","","");
        searchItemDonor.setDonorName(donationManagementUI.getDonorName());
        searchItem.setDonor(searchItemDonor);
        
        int count=1;
        while(count <= donationList.getNumOfEntries()){
            searchedDonationList.add(donationList.search(searchItem));
            count++;
        }
       
        return searchedDonationList;
    }
    
    public SortedListInterface<Donation> filterByDonorType(){
        SortedListInterface<Donation> searchedDonationList = new DoublyLinkedList<>();
        Donation searchItem = new Donation();
        searchItem.getDonor().setDonorType(donationManagementUI.getDonorType());
        
        int count=1;
        while(count <= donationList.getNumOfEntries()){
            searchedDonationList.add(donationList.search(searchItem));
            count++;
        }
       
        return searchedDonationList;
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
    
    
// Top 5 donated Items (To implement into implementation class)
 //To add toString + numerated   
}

