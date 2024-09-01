package boundary;

//Author name : Yeoh Qi yao
//Student ID : 23WMR07680
//Programme : RSD2S1G1
import utility.CheckNumberInput;

public class DoneeManagementUI {

    public static int doneeMenu() {
        System.out.println("\n---Donee Management System---");
        System.out.println("1. Add Donee");
        System.out.println("2. Remove Donee");
        System.out.println("3. Update Donee");
        System.out.println("4. Search Donee");
        System.out.println("5. List All Donees");
        System.out.println("6. Filter Donees");
        System.out.println("7. Generate donee summary reports ");
        System.out.println("8. Add Donee Received Times");
        System.out.println("0. Back to Main Menu");

        return CheckNumberInput.numChk(0, 8);  // Validate user input and return the choice
    }

    public static int filterDoneeMenu() {
        System.out.println("\n---Choose Donee type to filter:---");
        System.out.println("1. Individual");
        System.out.println("2. Family");
        System.out.println("3. Organisation");
        System.out.print("Enter your choice (1, 2, or 3): ");

        return CheckNumberInput.numChk(1, 3);  // Validate user input and return the choice
    }

    public static int updateDoneeSelectionMenu() {
        System.out.println("\n--- Update Donee Menu ---");
        System.out.println("1. Update Donee Name");
        System.out.println("2. Update Donee ID");
        System.out.println("3. Update Phone Number");
        System.out.println("4. Update Donee Type");
        System.out.println("0. Exit");
        System.out.print("Select an option (0-4): ");

        return CheckNumberInput.numChk(0, 4);  // Validate user input and return the choice
    }

    public static int SearchMenu() {
        System.out.println("Search Donee by:");
        System.out.println("1. Name");
        System.out.println("2. Donee ID");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");

        return CheckNumberInput.numChk(0, 2);  // Validate user input and return the choice
    }

    public static int DoneeTypeCategories() {
        System.out.println("1. Individual");
        System.out.println("2. Family");
        System.out.println("3. Organisation");
        System.out.print("Select donee type (1, 2, or 3): ");

        return CheckNumberInput.numChk(1, 3);  // Validate user input and return the choice
    }

    public static void displayDoneeList() {
        System.out.printf("\nDonee Summary Reports :\n| %-22s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",
                "Donee Name", "Donee Type", "Donee ID", "Phone Number", "Receive Donation Times", "Donee Created Date");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void DisplaynFilteredDoneeList() {
        System.out.printf("\nFiltered of Donees:\n| %-22s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",
                "Donee Name", "Donee Type", "Donee ID", "Phone Number", "Receive Donation Times", "Donee Created Date");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void DisplaynSearchedDoneeList() {
        System.out.printf("\nSelected Donee Details:\n| %-22s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",
                "Donee Name", "Donee Type", "Donee ID", "Phone Number", "Receive Donation Times", "Donee Created Date");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
    }
}
