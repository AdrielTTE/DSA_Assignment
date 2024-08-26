import java.io.IOException;
import java.util.Scanner;

public class DonationManagementUI {

    Scanner input = new Scanner(System.in);

    private int donManMenu(){
        int choice=-1;
        System.out.println("Donation Management");
        System.out.println("1. Add New Donation");
        System.out.println("2. Remove Existing Donation");
        System.out.println("3. Search Donation Details");
        System.out.println("4. Amend Donation Details");
        System.out.println("5. View Donations");
        System.out.println("6. Generate Donations Report");
        System.out.println("0. Return");

        while (choice < 0 && choice > 7){
             try{
            System.out.print("/nPlease Enter Choice: ");
            choice = input.nextInt();
        } catch (Exception e){
            System.out.println("Invalid Input! Please enter an integer within the valid range of choices");
        }
        }
       
        
        
        return choice;
    }

    private boolean numChk(T item){
        boolean result;
        
        if ()
            
            
    }

    private boolean addNewDonationMenu(){

    }


}