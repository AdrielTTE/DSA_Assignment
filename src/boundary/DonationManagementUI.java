package boundary;

import java.util.Scanner;
import control.DonationManagement;
import boundary.CharitySystemUI;
import utility.CheckNumberInput;
import control.CharitySystem;
import entity.Donation;

public class DonationManagementUI {

    Scanner input = new Scanner(System.in);
    public DonationManagementUI(){
        
    }

    public int donManMenu(){
        System.out.println("Donation Management");
        System.out.println("==============================");
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
        
        //To create Donor
        System.out.print("Enter Donor Name: ");
        String name = input.nextLine();
        
        //To loop, how many items to add?
        System.out.print("Enter Number of Item(s) Donated: ");
        int quantityOfItems = quantityChk();

        for (int i = 1; i <= quantityOfItems; i++){
            System.out.print("Enter Item Name " + i + " : ");
            itemName = input.nextLine();
            
            category = chooseCategories();
            
            System.out.print("Enter Quantity of Item:  " + i + " : ");
            quantity = quantityChk();
            
            System.out.print("Enter Value Per Item: RM");
            valuePerItem = numFltInput();
                                                                                //To get Donor class
            donationManagement.addNewDonation(donor, itemName, category, quantity, valuePerItem);
        }
        
       System.out.println("Donation successfully added!\n");
       donationManagement.getDonationList().toString();
    }

    private String chooseCategories(){
        String result = "null";
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
    
    public void viewDonationTitle(){
        System.out.println("Donations");
        System.out.println("==============================\n");

    }


    //For removing Donation
    public int removeDonationMenu(){
        
        System.out.println("Select Donation to Remove (1-" + donationManagement.getDonation().getNumOfEnties() + ")");
        return CheckNumberInput.numChk(1,donationManagement.getDonationList().getNumOfEntries());

    }

    public void removedDonation(boolean removedStatus){
        if (removedStatus)
            System.out.println("Donation has been removed!");
        
        else
            System.out.println("Error: Donation has not been removed!");
    }   


    public void searchDonationMenu(){
        System.out.println("Enter Donated Item Name: ");
        String searchItem = input.nextLine();
        donationManagement.getDonationList().searchDonation(donationName);
        
    }

    public int amendDonationMenu(){
        System.out.println("Amend Donation");
        System.out.println("========================");
        donationManagement.viewDonation();
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

    public void viewDonationMenu(){
        dao.DonationManagementInitializer.donationManagement.displayDonation();
    }

    public int generateReportMenu(){
        System.out.println("Generate Report");
        System.out.println("==================================================\n");
        System.out.println("1. Total Valuation of Donations Report");
        System.out.println("2. Categorical Breakdown of Donated Items Report");
        System.out.println("3. Donated Items: Sorted by Donor");
        System.out.println("0. Back");
    
        
        return CheckNumberInput.numChk(0, 3);
    }

    
    //Utility to limit the amount that a donor can sponsor (Cannot be infinity)
    private int quantityChk(){
        int quantity;
        int choice = -1;
        boolean cont = false;
        int minimum = 1;
        int maximum = 10000;
        while(!cont){

        try{
            quantity = input.nextInt();

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
    return choice;

    }

    private double numFltInput() {
        double number = 1.0;
        boolean cont = false;

        do{
            number = 1.0;
            try {
                number = input.nextDouble();

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