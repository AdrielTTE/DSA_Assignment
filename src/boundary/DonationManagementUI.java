package boundary;

import java.util.Scanner;
import control.DonationManagement;
import boundary.CharitySystemUI;
import utility.CheckNumberInput;
import control.CharitySystem;

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
        

    private void addDonationMenu(){
        //To add this into control class?
        String itemName;
        int quantity;
        System.out.print("Enter Donor Name: ");
        String name = input.nextLine();

        //To implement loop logic, how many items to add?
        System.out.print("Enter Number of Item(s) Donated: ");
        int quantityOfItems = quantityChk();

        for (int i = 1; i <= quantityOfItems; i++){
            System.out.print("Enter Item " + i + " : ");
            itemName = input.nextLine();
            System.out.print("Enter Quantity of Item " + i + " : ");
            quantity = quantityChk();

        // To add more logic
        }

       
    }

    private void removeDonationMenu(){
        //To change the wording
     
        System.out.print("Enter donation to remove: ");
        String itemToRemove = input.nextLine();
        CharitySystem.donationManagement.removeDonation(Donation(itemToRemove));
        
    }

    private static void searchDonationMenu(){

    }

    private static void amendDonationMenu(){

    }

    private static void viewDonationMenu(){

    }

    private static void generateReportMenu(){

    }

    
    //Utility to limit the amount that a donor can sponsor (Cannot be infinity)
    private static int quantityChk(){
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

//Latest iteration
}