import java.util.Scanner;
import control.DonationManagement;

public class DonationManagementUI {

    Scanner input = new Scanner(System.in);

    System.out.println("Donation Management");


    public void donManMenu(){
        

        System.out.println("1. Add New Donation");
        System.out.println("2. Remove Existing Donation");
        System.out.println("3. Search Donation Details");
        System.out.println("4. Amend Donation Details");
        System.out.println("5. View Donations");
        System.out.println("6. Generate Donations Report");
        System.out.println("0. Return");        


        switch(numChk(0,6)){
                case 1: 
                    addDonationMenu();
                    break;

                case 2: 
                    removeDonationMenu();
                    break;

                case 3: 
                    searchDonationMenu();
                    break;

                case 4:
                    amendDonationMenu();
                    break;

                case 5:
                    viewDonationMenu();
                    break;

                case 6: 
                    generateReportMenu();
                    break;

                default:
                    CharitySystemUI.MainMenu();
                    break;


        }
    
    }
        
    //To move into control class?
    private int numChk(int firstNum, int lastNum){
        int choice;
        boolean cont = false;
 
        while(!cont){

        try{
            System.out.print("/nPlease Enter Choice: ");
            choice = input.nextLine();

            if (choice >= firstNum && choice <= lastNum){
                cont = true;
            }

            else {
                System.out.println("Invalid number! Please enter integer between " + firstNum + " and " + lastNum);
            }
            

        } catch (IOException e){
            System.out.println("Invalid Input! Please enter an integer within the valid range of choices");
            
        }
        
    }
    return choice;

    }

    private int numChk(){
        int quantity;
        boolean cont = false;
        int minimum = 1;
        int maximum = 10000
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
            

        } catch (IOException e){
            System.out.println("Invalid Input! Please enter a number");
            
        }
        
    }
    return choice;

    }

    private void addDonationMenu(){
        System.out.print("Enter Donor Name: ");
        String name = input.nextLine();

        //To implement loop logic, how many items to add?
        System.out.print("Enter Number of Item(s) Donated: ");
        int quantityOfItems = numChk();

        

        System.out.print("Enter Quantity: ");
        int quantity
    }

    private void removeDonationMenu(){

    }

    private void searchDonationMenu(){

    }

    private void amendDonationMenu(){

    }

    private void viewDonationMenu(){

    }

    private void generateReportMenu(){

    }

    private void 

}