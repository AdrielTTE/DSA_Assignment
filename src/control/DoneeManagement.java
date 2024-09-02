package control;

//Author name : Yeoh Qi yao
//Student ID : 23WMR07680
//Programme : RSD2S1G1
import adt.*;
import boundary.DoneeManagementUI;
import dao.DoneeInitializer;
import entity.*;
import java.time.LocalDate;
import java.util.Scanner;

public class DoneeManagement {

    private SortedListInterface<Donee> doneeList = new DoublyLinkedList<>();
    
    private final DoneeManagementUI doneeUI = new DoneeManagementUI();
    private final DoneeInitializer doneeInitializer = new DoneeInitializer();
    private final Scanner scanner = new Scanner(System.in);
   

    public DoneeManagement() {
        doneeList = doneeInitializer.initializeDonees();
    }

    public static void startDoneeManagementSystem() {
        DoneeManagement doneeManagement = new DoneeManagement();
        doneeManagement.runDoneeManagement();
    }

    public void runDoneeManagement() {
        int choice = 0;
        do {
            choice = DoneeManagementUI.doneeMenu();
            switch (choice) {
                case 0:
                    System.out.println("Exiting...");
                    break;
                case 1:
                    addNewDonee();
                    break;
                case 2:
                    removeDonee();
                    break;
                case 3:
                    updateDonee();
                    break;
                case 4:
                    searchDonee();
                    break;
                case 5:
                    listAllDonees();
                    break;
                case 6:
                    filterDonee();
                    break;
                case 7:
                    generateDoneeReport();
                    break;
                case 8:
                    addDonation();
                    break;
                default:

            }
        } while (choice != 0);
    }

    private void initializeDoneeList() {
        DoneeInitializer initializer = new DoneeInitializer();
        doneeList = initializer.initializeDonees();  // Initialize doneeList using the initializer
    }

    private String generateNextId() {
        int maxId = 0 ;

        for (int i = 1; i <= doneeList.getNumOfEntries(); i++) {
            Donee donee = doneeList.getEntry(i);
            String id = donee.getDoneeID();
            if (id != null && id.startsWith("D")) {
                try {
                    // Extract numeric part of ID and update maxId
                    int numericPart = Integer.parseInt(id.substring(1));
                    if (numericPart > maxId) {
                        maxId = numericPart;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing ID: " + id);
                }
            }
        }

        // Format the next ID with leading zeros
        return String.format("D%d", maxId + 1);
    }

    private void addNewDonee() {
        String doneeName;
        while (true) {
            System.out.print("Enter donee name: ");
            doneeName = scanner.nextLine();
            if (doneeName.matches("[a-zA-Z\\s]+")) {
                break;
            } else {
                System.out.println("Invalid name. Please enter a name with only letters and spaces.");
            }
        }

        // Check if a Donee with the same name already exists
        for (int i = 1; i <= doneeList.getNumOfEntries(); i++) {
            if (doneeList.getEntry(i).getDoneeName().equalsIgnoreCase(doneeName)) {
                System.out.println("A Donee with this name already exists. Please try again.\n");
                return; // Exit the method if a duplicate is found
            }
        }

        String doneeType = "";

        while (true) {
            int choice = 0;
            choice = DoneeManagementUI.DoneeTypeCategories();

            switch (choice) {
                case 1:
                    doneeType = "Individual";
                    break;
                case 2:
                    doneeType = "Family";
                    break;
                case 3:
                    doneeType = "Organisation";
                    break;
            }
            break; // Exit the loop after a valid input
        }

        String doneeID = generateNextId();

        String doneePhone;
        while (true) {
            System.out.print("Enter donee phone number: ");
            doneePhone = scanner.nextLine();
            if (doneePhone.matches("\\d{10,11}")) {  // Assuming phone number is 10-11 digits
                break;
            } else {
                System.out.println("Invalid phone number. Please enter a 10 or 11-digit number.");
            }
        }

        int doneeReceived;
        doneeReceived = 0;

        System.out.println("Receive Donation Times: " + doneeReceived);

        String doneeDateCreated = LocalDate.now().toString();
        System.out.println("Donee Created Date: " + doneeDateCreated);

        Donee newDonee = new Donee(doneeName, doneeType, doneeID, doneePhone, doneeReceived, doneeDateCreated);

        // Debugging Output
        System.out.println("New Donee Add: " + doneeName);

        if (doneeList.add(newDonee)) {  // Add donee to the list
            System.out.println("Donee added successfully.");
        } else {
            System.out.println("Failed to add donee. A donee with this name may already exist.");
        }

        System.out.println("Press Enter to continue...");
        scanner.nextLine();
    }

    private void removeDonee() {

        if (doneeList.getNumOfEntries() == 0) {
            System.out.println("Donee list is empty. Nothing to remove.");
            System.out.println("Press Enter to return to the main menu...");
            scanner.nextLine();
            return; // Exit the method to return to the main menu
        }
        while (true) {
            // List all donees and include an option to go back
            for (int i = 1; i <= doneeList.getNumOfEntries(); i++) {
                Donee currentDonee = doneeList.getEntry(i);
                System.out.println(i + ". " + currentDonee.getDoneeName() + " (ID: "
                        + currentDonee.getDoneeID() + ") (Phone Number: "
                        + currentDonee.getDoneePhone() + ") (Donee Type: "
                        + currentDonee.getDoneeType() + ")");
            }
            System.out.println("0. Go back");

            Donee doneeToRemove = null;
            while (doneeToRemove == null) {
                try {
                    // Ask the user to select a Donee to remove or go back
                    System.out.print("\nSelect the number of the Donee you want to remove: ");
                    int doneeIndex = Integer.parseInt(scanner.nextLine());

                    if (doneeIndex == 0) {
                        System.out.println("Returning to the previous menu.");
                        return; // Exit the method to go back
                    }

                    doneeToRemove = doneeList.getEntry(doneeIndex);

                    if (doneeToRemove == null) {
                        System.out.println("Invalid selection. Please try again.");
                        doneeToRemove = null; // Reset the variable for retry
                    } else {
                        boolean isRemoved = doneeList.remove(doneeToRemove);
                        if (isRemoved) {
                            System.out.println("Donee removed successfully.");
                        } else {
                            System.out.println("Failed to remove Donee.");
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }

            System.out.println("Press Enter to continue...");
            scanner.nextLine();
            break; // Exit the loop after completing the removal process
        }
    }

    private void updateDonee() {

        System.out.printf("%-2s %-25s %-10s %-15s %-20s%n", "No.|", "Donee Name ", "| ID ", "| Phone Number ", " | Donee Type    |");
        System.out.println("----------------------------------------------------------------------------");

        for (int i = 1; i <= doneeList.getNumOfEntries(); i++) {
            Donee currentDonee = doneeList.getEntry(i);
            System.out.printf("%-2d | %-25s | %-8s | %-14s | %-13s |%n",
                    i, currentDonee.getDoneeName(),
                    currentDonee.getDoneeID(),
                    currentDonee.getDoneePhone(),
                    currentDonee.getDoneeType());
        }
        System.out.println("0. Go back");

        Donee doneeToUpdate = null;
        while (doneeToUpdate == null) {
            try {
                // Ask the user to select a Donee to update
                System.out.print("\nSelect the number of the Donee you want to update: ");
                int doneeIndex = Integer.parseInt(scanner.nextLine());

                if (doneeIndex == 0) {
                    System.out.println("Returning to the main menu.");
                    return; // Exit the method to go back to the main menu
                }
                doneeToUpdate = doneeList.getEntry(doneeIndex);

                if (doneeToUpdate == null) {
                    System.out.println("Invalid selection. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        while (true) {
            int choice = 0;
            choice = DoneeManagementUI.updateDoneeSelectionMenu();

            switch (choice) {
                case 1:
                    // Display current Donee details
                    System.out.println("Current Donee Name: " + doneeToUpdate.getDoneeName());

// Prompt for new Donee Name
                    System.out.print("Enter new Donee Name: ");
                    String newName = scanner.nextLine();

// Check if the new name contains numbers
                    if (!newName.matches(".*\\d.*")) {
                        // Check if the new name is unique
                        if (isUniqueDoneeName(newName)) {
                            // Create a new Donee with the updated name and retain the old Donee data
                            Donee updatedDonee = new Donee(
                                    newName,
                                    doneeToUpdate.getDoneeType(), // Assuming you have a method to get doneeType
                                    doneeToUpdate.getDoneeID(),
                                    doneeToUpdate.getDoneePhone(),
                                    doneeToUpdate.getDoneeReceived(), // Assuming you have a method to get doneeReceived
                                    doneeToUpdate.getDoneeDateCreated() // Assuming you have a method to get doneeDateCreated
                            );

                            // Remove the old Donee from the list
                            doneeList.remove(doneeToUpdate);

                            // Add the updated Donee to the list
                            doneeList.add(updatedDonee);

                            System.out.println("Donee Name updated successfully.");
                        } else {
                            System.out.println("Error: The Donee Name is already in use.");
                        }
                    } else {
                        System.out.println("Error: Donee Name cannot include numbers.");
                    }
                    break;

                case 2:
                    System.out.println("Current Donee ID: " + doneeToUpdate.getDoneeID());
                    System.out.print("Enter new Donee ID (format: D1001, D1002, etc.): ");
                    String newID = scanner.nextLine();
                    if (newID.matches("D1[0-9]{3}") || newID.matches("D[2-9][0-9]{3}")) {
                        if (isUniqueDoneeID(newID)) {
                            doneeToUpdate.setDoneeID(newID);
                            System.out.println("Donee ID updated successfully.");
                        } else {
                            System.out.println("Error: The Donee ID is already in use.");
                        }
                    } else {
                        System.out.println("Error: Donee ID must be in the format D1001, D1002, etc.");
                    }
                    break;

                case 3:
                    System.out.println("Current Phone Number: " + doneeToUpdate.getDoneePhone());
                    System.out.print("Enter new Phone Number: ");
                    String newPhone = scanner.nextLine();
                    if (newPhone.matches("\\d{10,11}")) {
                        doneeToUpdate.setDoneePhone(newPhone);
                        System.out.println("Phone Number updated successfully.");
                    } else {
                        System.out.println("Invalid phone number. Please enter a 10 or 11-digit number.");
                    }
                    break;

                case 4:
                    System.out.println("Current Donee Type: " + doneeToUpdate.getDoneeType());
                    String doneeType = "";
                    while (true) {
                        int Dchoice;
                        Dchoice = DoneeManagementUI.DoneeTypeCategories();

                        switch (Dchoice) {
                            case 1:
                                doneeType = "Individual";
                                break;
                            case 2:
                                doneeType = "Family";
                                break;
                            case 3:
                                doneeType = "Organisation";
                                break;
                        }
                        doneeToUpdate.setDoneeType(doneeType);
                        System.out.println("Donee Type updated successfully.");
                        break;

                    }
                    break;

                case 0:
                    System.out.println("Exiting update menu.");
                    return;

                default:
                    System.out.println("Invalid selection. Please choose a valid option.");
            }
        }
    }

    private boolean isUniqueDoneeName(String name) {
        for (int i = 1; i <= doneeList.getNumOfEntries(); i++) {
            if (doneeList.getEntry(i).getDoneeName().equalsIgnoreCase(name)) {
                return false;
            }
        }
        return true;
    }

    private boolean isUniqueDoneeID(String id) {
        for (int i = 1; i <= doneeList.getNumOfEntries(); i++) {
            if (doneeList.getEntry(i).getDoneeID().equalsIgnoreCase(id)) {
                return false;
            }
        }
        return true;
    }

    private void searchDonee() {
        int choice;
        choice = DoneeManagementUI.SearchMenu();

        switch (choice) {
            case 1:
                // Search by Name
                searchByName();
                break;
            case 2:
                // Search by Donee ID
                searchByDoneeID();
                break;
            default:
                return;
        }

        System.out.println("Press Enter to continue...");
        scanner.nextLine();
    }

    private void searchByName() {
        System.out.print("Enter the Donee Name to search: ");
        String doneeName = scanner.nextLine();

        boolean found = false;

        for (int i = 1; i <= doneeList.getNumOfEntries(); i++) {
            Donee donee = doneeList.getEntry(i);
            if (donee.getDoneeName().equalsIgnoreCase(doneeName)) {
                DoneeManagementUI.DisplaynSearchedDoneeList();
                System.out.printf("| %-22s | %-15s | %-15s | %-15s | %-22s | %-18s |\n",
                        donee.getDoneeName(),
                        donee.getDoneeType(),
                        donee.getDoneeID(),
                        donee.getDoneePhone(),
                        donee.getDoneeReceived(),
                        donee.getDoneeDateCreated());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Donees found with the name: " + doneeName);
        }
    }

    private void searchByDoneeID() {
        System.out.print("Enter the Donee ID to search: ");
        String doneeID = scanner.nextLine();

        boolean found = false;

        for (int i = 1; i <= doneeList.getNumOfEntries(); i++) {
            Donee donee = doneeList.getEntry(i);
            if (donee.getDoneeID().equalsIgnoreCase(doneeID)) {
                DoneeManagementUI.DisplaynSearchedDoneeList();
                System.out.printf("| %-22s | %-15s | %-15s | %-15s | %-22s | %-18s |\n",
                        donee.getDoneeName(),
                        donee.getDoneeType(),
                        donee.getDoneeID(),
                        donee.getDoneePhone(),
                        donee.getDoneeReceived(),
                        donee.getDoneeDateCreated());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Donee found with the ID: " + doneeID);
        }
    }

    private String getAllDonees() {
        StringBuilder outputStr = new StringBuilder();
        for (int i = 1; i <= doneeList.getNumOfEntries(); i++) {
            outputStr.append(doneeList.getEntry(i)).append("\n");
        }
        return outputStr.toString();

    }

    private void listAllDonees() {
        // Print header
        System.out.printf("%-5s| %-25s| %-8s%n", "No.", "Donee Name", "ID");
        System.out.println("----------------------------------------------------");

        for (int i = 1; i <= doneeList.getNumOfEntries(); i++) {
            Donee donee = doneeList.getEntry(i);

            // Print each donee's details
            System.out.printf("%-5d| %-25s| %-8s%n",
                    i,
                    donee.getDoneeName(),
                    donee.getDoneeID());
        }

        System.out.println("Press Enter to continue...");
        scanner.nextLine();
    }

    private void filterDonee() {
        String filterType = "";

        // Display menu and prompt user for a choice
        while (true) {
            int choice = 0;
            choice = DoneeManagementUI.filterDoneeMenu();

            switch (choice) {
                case 1:
                    filterType = "Individual";
                    break;
                case 2:
                    filterType = "Family";
                    break;
                case 3:
                    filterType = "Organisation";
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                    continue;  // Repeat the loop if the input is invalid
            }
            break;  // Exit loop once a valid choice is made
        }

        boolean found = false;
        DoneeManagementUI.DisplaynFilteredDoneeList();
        for (int i = 1; i <= doneeList.getNumOfEntries(); i++) {
            Donee donee = doneeList.getEntry(i);
            if (donee.getDoneeType().equalsIgnoreCase(filterType)) {
                System.out.println(donee);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Donees found for the specified type.");
        }

        System.out.println("Press Enter to continue...");
        scanner.nextLine();
    }

    private void generateDoneeReport() {
        DoneeManagementUI.displayDoneeList();
        System.out.println(getAllDonees());
    }

    private void addDonation() {
        System.out.print("Enter the Donee Name to add a donation: ");
        String doneeName = scanner.nextLine();

        // Find the Donee by name
        Donee doneeToDonate = null;
        for (int i = 1; i <= doneeList.getNumOfEntries(); i++) {
            Donee currentDonee = doneeList.getEntry(i);
            if (currentDonee.getDoneeName().equalsIgnoreCase(doneeName)) {
                doneeToDonate = currentDonee;
                break;
            }
        }

        if (doneeToDonate == null) {
            System.out.println("Donee not found. Please make sure you entered the correct name.");
            return;
        }

        // Prompt for the donation amount
        int donationAmount = 0;
        while (true) {
            try {
                System.out.print("Enter the donation amount: ");
                donationAmount = Integer.parseInt(scanner.nextLine());
                if (donationAmount > 0) {
                    break; // Valid amount
                } else {
                    System.out.println("Donation amount must be positive.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        // Add the specified donation amount
        doneeToDonate.addDonation(donationAmount);
        System.out.println("Donation added. " + doneeToDonate.getDoneeName() + " now has received a total of " + doneeToDonate.getDoneeReceived() + " donations.");
    }

}
