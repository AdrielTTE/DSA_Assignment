
package utility;

import java.util.Scanner;
/**
 *
 * @author Adriel
 */
public class CheckNumberInput {

    static Scanner input = new Scanner(System.in);

    public static int numChk(int firstNum, int lastNum) {
        
        int choice = -1;
        boolean cont = false;

        do{
            choice = -1;
            try {
                System.out.print("\nPlease Enter Choice: ");
                choice = input.nextInt();
                input.nextLine();

                if (choice >= firstNum && choice <= lastNum) {
                    cont = true;
                } else {
                    System.out.println("Invalid number! Please enter an integer between " + firstNum + " and " + lastNum);
                }

            } catch (Exception e) {
                System.out.println("Invalid Input! Please enter an integer within the valid range of choices");
                input.nextLine(); // Clear the buffer
            }
        }while (!cont); 
        return choice;
    }
    
    public static boolean isInteger(String str) {
       
    try {
        Integer.parseInt(str);
        return true;  // If parsing is successful, return true
    } catch (NumberFormatException e) {
        return false; // If parsing fails, return false
    }
}
   
   public static boolean isFloat(String str) {
    try {
        Float.parseFloat(str);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}
    
    
}
