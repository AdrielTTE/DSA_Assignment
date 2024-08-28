package boundary;

import java.util.Scanner;
import utility.CheckNumberInput;

/**
 *
 * @author Adriel
 */

public class CharitySystemUI {
   public CharitySystemUI(){

   }

    public int MainMenu(){
        System.out.println("Charity Management System");
        System.out.println("===========================\n");
        System.out.println("1. Manage Donors");
        System.out.println("2. Manage Donees");
        System.out.println("3. Manage Donations");
        System.out.println("4. Donation Distribution");
        System.out.println("5. Manage Volunteers");
        System.out.println("0. Exit");
        
        return CheckNumberInput.numChk(0,5);
        
    }
    
    
}
