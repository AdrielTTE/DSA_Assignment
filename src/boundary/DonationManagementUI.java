package boundary;

import adt.SortedListInterface;
import java.util.Scanner;
import control.DonationManagement;
import boundary.CharitySystemUI;
import utility.CheckNumberInput;
import control.CharitySystem;
import entity.Donation;
import entity.Donor;
import utility.MessageUI;

public class DonationManagementUI {
    private DonationManagement donationManagement;
    Scanner input = new Scanner(System.in);
    public DonationManagementUI(){
        
    }
    
    public DonationManagementUI(DonationManagement donationManagement) {
        this.donationManagement = donationManagement;
    }
    
    
    public int donManMenu(){
        System.out.println("\nDonation Management");
        System.out.println("==============================\n");
        System.out.println("1. Add New Donation");
        System.out.println("2. Remove Existing Donation");
        System.out.println("3. Search Donation Details");
        System.out.println("4. Amend Donation Details");
        System.out.println("5. View Donations");
        System.out.println("6. Generate Donations Report");
        System.out.println("0. Return");        
        
        return CheckNumberInput.numChk(0,6);

        
    
    }
        

    public void addNewDonationMenu(){
        //To add this into control class?
        String itemName;
        int quantity;
        double valuePerItem;
        String category;
        Donor donor = new Donor();
        
        //To create Donor
        System.out.print("Enter Donor Name: ");
        String name = input.nextLine();
        donor.setDonorName(name); 
                
        donor.setDonorType(chooseDonorType());

        System.out.print("Enter " + name + "'s IC: ");
        donor.setDonorIC(input.nextLine());
        
        System.out.print("Enter " + name + "'s Phone Number: ");
        donor.setDonorPhone(input.nextLine());
        
        //To loop, how many items to add?
        System.out.print("Enter Number of Item(s) Donated: ");
        int quantityOfItems = quantityChk();

        for (int i = 1; i <= quantityOfItems; i++){
            System.out.print("Enter Item Name " + i + ": ");
            itemName = input.nextLine();
            donor.setDonorDonated(itemName);
            category = chooseCategories();
            
            System.out.print("Enter Quantity of Item " + i + " : ");
            quantity = quantityChk();
            
            System.out.print("Enter Value Per Item: RM");
            valuePerItem = numFltInput();
                                                                                
            donationManagement.addNewDonation(donor, itemName, category, quantity, valuePerItem);
            donor.setDonorDateDonated("31/8/2024");
        }
        
       System.out.println("Donation successfully added!\n");
       System.out.println(donationManagement.getDonationList().toString());
    }
    
    private String chooseDonorType(){
        String result = "";
        System.out.println("Select Donor Type");
        System.out.println("1. Government");
        System.out.println("2. Private");
        System.out.println("3. Public");
        
        switch(CheckNumberInput.numChk(1, 3)){
            
            case 1:
                result = "Government";
                break;
            
            case 2:
                result = "Private";
                break;
                
            default:
                result = "Public";
                break;
        }
        
        return result;
    }

    public String chooseCategories(){
        String result = "";
        System.out.println("\nSelect Category");
        System.out.println("1. Money");
        System.out.println("2. Clothes");
        System.out.println("3. Sleep Items");
        System.out.println("4. Food Items");
        System.out.println("5. Books");
        System.out.println("6. Stationary");
        System.out.println("7. Other");
        
        switch(CheckNumberInput.numChk(1, 7)){
            case 1: 
                result = "Money";
                break;
                
            case 2:
                result = "Clothes";
                break;
                
            case 3:
                result = "Sleep Items";
                break;
                
            case 4: 
                result = "Food Items";
                break;
            
            case 5:
                result = "Books";
                break;
                
            case 6: 
                result = "Stationary";
                break;
                
            default:
                result = "Other";
                break;
        }
        
        return result;
    }


    //For removing Donation
    public int removeDonationMenu(){
        System.out.println("\nDonations");
        System.out.println("==============================\n");
        donationManagement.displayDonation();
        System.out.println("Select Donation to Remove (1-" + donationManagement.getDonationList().getNumOfEntries() + ")");
        return CheckNumberInput.numChk(1,donationManagement.getDonationList().getNumOfEntries());

    }

    public void removedDonation(boolean removedStatus){
        if (removedStatus)
            System.out.println("Donation has been removed!");
        
        else
            System.out.println("Error: Donation has not been removed!");
    }   


    public String searchDonationMenu(){
        System.out.println("Enter Donated Item Name: ");
        return input.nextLine();
        
    }
    
   
    
    public void displaySearchedDonations(SortedListInterface<Donation> searchedDonationList){
        System.out.println(searchedDonationList.toString());
    }
    
    public void displaySelectedDonation(Donation selected){
        System.out.println(selected.toString());
    }
    
    //Amending Donations
    public int attributeToChange(Donation selected){
        displaySelectedDonation(selected);
        
        System.out.println("\nSelect Attribute to Change");
        System.out.println("==================================\n");
        System.out.println("1. Donor Name: " + selected.getDonor());
        System.out.println("2. Item Donated: " + selected.getItemDonated());
        System.out.println("3. Category: " + selected.getCategory());
        System.out.println("4. Quantity: " + selected.getQuantity());
        System.out.println("5. Value Per Quantity: " + selected.getValuePerQuantity());
        System.out.println("6. Total Value: " + selected.getTotalValue());
        return CheckNumberInput.numChk(1, 6);
        
    }
    
    public Donor changeDonor(){
        Donor donor = new Donor();
        String itemName;
        int quantity;
        double valuePerItem;
        String category;
        
        //To create Donor
        System.out.print("Enter Donor Name: ");
        String name = input.nextLine();
        donor.setDonorName(name); 
                
        donor.setDonorType(chooseDonorType());

        System.out.print("Enter " + name + "'s IC: ");
        donor.setDonorIC(input.nextLine());
        
        System.out.print("Enter " + name + "'s Phone Number: ");
        donor.setDonorPhone(input.nextLine());
        
        return donor;
    }
    
    public String changeDonatedItem(){
        System.out.print("Enter Donated Item: ");
        return input.nextLine();
        
    }
    
    public int changeQuantity(){
        System.out.print("Enter Quantity of Donated Item: ");
        return input.nextInt();
    }
    
    public double changeValuePerItem(){
        System.out.print("Enter Value Per Donated Item: ");
        return input.nextDouble();
    }
    
    
    public int amendDonationMenu(){
        System.out.println("\nAmend Donation");
        System.out.println("========================");
        donationManagement.displayDonation();
        System.out.println("Select Donation to Amend");
        
        //To change constraints
        return CheckNumberInput.numChk(1, donationManagement.getDonationList().getNumOfEntries());
        
    }
    
    public int itemToAmend(){
        System.out.println("1. Donor");
        System.out.println("2. Donated Item Name");
        System.out.println("3. Category");
        System.out.println("4. Quantity of Item");
        System.out.println("5. Value Per Item");
        
        return CheckNumberInput.numChk(0, 5);
    }
    
    public void displayChangedDonation(Donation amendDonation){
        System.out.println(amendDonation.toString());
    }

    public void viewDonationMenu(){
        donationManagement.displayDonation();
    }
    
    public int displayListMenu(SortedListInterface<Donation> donationList){
        MessageUI.displayDonationListHeader();
        System.out.println(donationList.toString());
        MessageUI.displayDonationListFooter();
        System.out.println("\n1. Filter");
        System.out.println("0. Back");
        return CheckNumberInput.numChk(0, 1);
        
    }
    
    public int filterBy(){
        
        System.out.println("\nFilter");
        System.out.println("=========================\n");
        System.out.println("1. Donor");
        System.out.println("2. Donated Item Name");
        System.out.println("3. Category");
        
        return CheckNumberInput.numChk(1, 3);
    }

    public int getDonorAttribute(){
        System.out.println("\nDonor Attributes");
        System.out.println("=========================\n");
        System.out.println("1. Name");
        System.out.println("2. Donor Type");
    
        return CheckNumberInput.numChk(1, 2);
    }
    
    public String getDonorName(){
        System.out.print("Enter Donor Name: ");
        return input.nextLine();
    }
    
    public String getDonorType(){
        System.out.print("Enter Donor Type: ");
        return input.nextLine();
    }
    
    public int generateReportMenu(){
        System.out.println("\nGenerate Report");
        System.out.println("==================================================\n");
        System.out.println("1. Total Valuation of Donations Report");
        System.out.println("2. Categorical Breakdown of Donated Items Report");
        System.out.println("3. Donated Items: Sorted by Donor");
        System.out.println("0. Back");
    
        
        return CheckNumberInput.numChk(0, 3);
    }

    
    //Utility to limit the amount that a donor can sponsor (Cannot be infinity)
    private int quantityChk(){
        int quantity=0;
        boolean cont = false;
        int minimum = 1;
        int maximum = 10000;
        while(!cont){

        try{
            quantity = input.nextInt();
            input.nextLine();

            if (quantity >= minimum && quantity <= maximum){
                cont = true;
            }

            else if (quantity < minimum){
                System.out.println("Invalid number! You need to donate at least " + minimum + " item");
            }

            else {
                System.out.println("Invalid number! You can only donate a maximum of " + maximum + "items");
            }
            

        } catch (Exception e){
            System.out.println("Invalid Input! Please enter a number");
            
        }
        
    }
    return quantity;

    }

    private double numFltInput() {
        double number = 1.0;
        boolean cont = false;

        do{
            number = 1.0;
            try {
                number = input.nextDouble();
                input.nextLine();
                if (number > 0) {
                    cont = true;
                } else {
                    System.out.println("Invalid number! Number must be more than 0");
                }

            } catch (Exception e) {
                System.out.println("Invalid Input! Please enter a number");
                input.nextLine(); // Clear the buffer
            }
        }while (!cont); 
        return number;
    }
//Latest iteration
}