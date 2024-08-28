
package control;

import boundary.CharitySystemUI;
import boundary.DonationManagementUI;
import control.DonationManagement;
import dao.DonationManagementInitializer;
import utility.CheckNumberInput;

/**
 *
 * @author Adriel
 */
public class CharitySystem {

    private CharitySystemUI charitySystemUI = new CharitySystemUI();

    public static void main(String[] args) {
        boolean cont = true;
        
        while (cont){
            
            switch(charitySystemUI.mainMenu()){
                case 1: 
                    //Insert Donor Management System here
                    break;

                case 2:
                    //Insert Donee Management System here
                    break;

                case 3:
                    DonationManagement donationManagement = new DonationManagement();
                    donationManagemnt.donationSelection();
                    break;

                case 4: 
                    //Insert Donation Distribution Management here
                    break;

                case 5: 
                    //Insert Volunteer Management System here
                    break;

                default:
                    cont = false;
                    break;
                
            }
            
        }
        
        System.out.println("\nHave a nice day!");
    }
    
}
