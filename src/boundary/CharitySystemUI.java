package boundary;

import java.util.Scanner;
/**
 *
 * @author Adriel
 */

public class CharitySystemUI {
    
    static Scanner input = new Scanner(System.in);
    
    public static void MainMenu(){
        System.out.println("Charity Management System");
        System.out.println("===========================\n");
        System.out.println("1. Manage Donors");
        System.out.println("2. Manage Donees");
        System.out.println("3. Manage Donations");
        System.out.println("4. Donation Distribution");
        System.out.println("5. Manage Volunteers");
        System.out.println("0. Exit");
        
        switch(numChk(0,5)){
            case 1: 
                //Insert Donor Management System here
                break;
                
            case 2:
                //Insert Donee Management System here
                break;
                
            case 3: 
                //Insert Donations Management here
                break;
                
            case 4: 
                //Insert Donation Distribution Management here
                break;
                
            case 5: 
                //Insert Volunteer Management System here
                break;
                
            case 6:
                break;
            
        }
        
        
        
        
    }
    
    private static int numChk(int firstNum, int lastNum){
        int choice=-1;
        boolean cont = false;
 
        while(!cont){

        try{
            System.out.print("/nPlease Enter Choice: ");
            choice = input.nextInt();

            if (choice >= firstNum && choice <= lastNum){
                cont = true;
            }

            else {
                System.out.println("Invalid number! Please enter integer between " + firstNum + " and " + lastNum);
            }
            

        } catch (Exception e){
            System.out.println("Invalid Input! Please enter an integer within the valid range of choices");
            
        }
        
    }
    return choice;

    }
}
