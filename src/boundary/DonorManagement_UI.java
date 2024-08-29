package boundary;

/**
 *
 * @author Amanda Lee
 */
import java.util.Scanner;
import java.util.Comparator;
import adt.DoublyLinkedList;
import adt.SortedListInterface;
import entity.Donor;
import utility.MessageUI;

public class DonorManagement_UI {

    private static DoublyLinkedList<Donor> donors = new DoublyLinkedList<>();
    private Scanner input = new Scanner(System.in);

    public int getMenuChoice() {
        int choice = -1; // Initialize choice to an invalid number
        boolean valid = false;

        while (!valid) {
            System.out.print("\n+---------------------------------------------------------------------+");
            System.out.print("\n|                       Donor Management System                       |");
            System.out.print("\n+---------------------------------------------------------------------+");
            System.out.print("\n|     1. Add Donor                                                    |");
            System.out.print("\n|     2. Remove Donor                                                 |");
            System.out.print("\n|     3. Update Donor Details                                         |");
            System.out.print("\n|     4. Search Donor Details                                         |");
            System.out.print("\n|     5. List Donors                                                  |");
            System.out.print("\n|     6. Filter Donors                                                |");
            System.out.print("\n|     7. Categorize Donors                                            |");
            System.out.print("\n|     8. View Summary Report                                          |");
            System.out.print("\n|     9. Exit                                                         |");
            System.out.print("\n+---------------------------------------------------------------------+");
            System.out.print("\nEnter your choice (1-9): ");

            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine(); // Consume newline

                if (choice >= 1 && choice <= 9) {
                    valid = true; // Valid input, exit loop
                } else {
                    MessageUI.displayInvalidOptionMessage();
                    System.out.println("\nPlease enter a number between 1 and 9.");
                }
            } else {
                MessageUI.displayInvalidOptionMessage();
                MessageUI.displaySelectValidMessage();
                input.nextLine(); // Consume invalid input
            }
        }

        return choice;
    }

    // Adding New Donor
    public String inputDonorName() {
        return inputValidString("Enter Donor Name: ");
    }

    public String inputDonorType() {
        MessageUI.displayDonorTypeOptions();

        int choice = inputValidInt("Enter your choice (1-3): ", 1, 3);
        switch (choice) {
            case 1:
                return "Government";
            case 2:
                return "Private";
            case 3:
                return "Public";
            default:
                throw new IllegalArgumentException("\n>> Invalid choice << " + "\n\n...Please select a valid option.");
        }
    }

    public String inputDonorIC() {
        return inputValidateIC_Phone("Enter Donor IC: ");
    }

    public String inputDonorPhone() {
        return inputValidateIC_Phone("Enter Donor's Phone Number: ");
    }

    public String inputDonorDonated() {
        MessageUI.displayDonationType();

        int choice = inputValidChoice("Enter your choice (1-5): ", 1, 5);
        switch (choice) {
            case 1:
                String amount = inputValidAmount("Enter the donation amount in RM");
                return "Money: RM " + amount;
            case 2:
                return "Food";
            case 3:
                return "Toiletries";
            case 4:
                return "Clothes";
            case 5:
                String otherItems = inputValidString("Enter the specific items donated");
                return "Others: " + otherItems;
            default:
                throw new IllegalArgumentException("Invalid choice. Please select a valid option.");
        }
    }

    public String inputDonorDateDonated() {
        return inputValidDate(input, "Enter Donor Date Donated (DD-MM-YYYY): ");
    }

    public Donor inputDonorDetails() {
        String donorName = inputDonorName();
        String donorType = inputDonorType();
        String donorIC = inputDonorIC();
        String donorPhone = inputDonorPhone();
        String donorDonated = inputDonorDonated();
        String donorDateDonated = inputDonorDateDonated();
        System.out.println();
        return new Donor(donorName, donorType, donorIC, donorPhone, donorDonated, donorDateDonated);
    }

    // Removing Donor
    public String inputRemoveDonor() {
        return inputValidString("Enter Donor Name to remove: ");
    }

    // Update Donor
    public void updateDonor(Donor foundDonor) {
        boolean done = false;

        while (!done) {
            MessageUI.displayUpdateDonorOptions();
            int choice = inputValidChoice("Enter your choice (1-7): ", 1, 7);

            switch (choice) {
                case 1:
                    String newName = inputValidString("Enter new Donor Name: ");
                    foundDonor.setDonorName(newName);
                    break;
                case 2:
                    String newType = inputValidString("Enter new Donor Type (Government/Private/Public): ");
                    foundDonor.setDonorType(newType);
                    break;
                case 3:
                    String newIC = inputValidateIC_Phone("Enter new Donor IC: ");
                    foundDonor.setDonorIC(newIC);
                    break;
                case 4:
                    String newPhone = inputValidateIC_Phone("Enter new Donor Phone Number: ");
                    foundDonor.setDonorPhone(newPhone);
                    break;
                case 5:
                    MessageUI.displayDonationType();

                    int donationChoice = inputValidChoice("Enter your choice (1-5): ", 1, 5);
                    String newDonated;
                    switch (donationChoice) {
                        case 1:
                            String amount = inputValidAmount("Enter the donation amount in RM: ");
                            newDonated = "Money: RM " + amount;
                            break;
                        case 2:
                            newDonated = "Food";
                            break;
                        case 3:
                            newDonated = "Toiletries";
                            break;
                        case 4:
                            newDonated = "Clothes";
                            break;
                        case 5:
                            String otherItems = inputValidString("Enter the specific items donated: ");
                            newDonated = "Others: " + otherItems;
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid choice. Please select a valid option.");
                    }
                    foundDonor.setDonorDonated(newDonated);
                    break;
                case 6:
                    String newDateDonated = inputValidString("Enter new Donor Date Donated (DD-MM-YYYY): ");
                    foundDonor.setDonorDateDonated(newDateDonated);
                    break;
                case 7:
                    done = true;
                    break;
                default:
                    MessageUI.displayInvalidOptionMessage();
                    MessageUI.displaySelectValidMessage();
            }

            if (choice != 7) {
                MessageUI.displayDonorDetailsUpdatedMessage();
            }
        }
    }

    // Search Donor
    public String inputDonor() {
        return inputValidString("Enter Donor Name to search: ");
    }

    // Filter Donor
    public String inputFilterDonors() {
        MessageUI.displayFilterDonorOptions();

        int choice = inputValidInt("Enter your choice (1-3): ", 1, 3);
        switch (choice) {
            case 1:
                return "Government";
            case 2:
                return "Private";
            case 3:
                return "Public";
            default:
                throw new IllegalArgumentException("\n>> Invalid choice << " + "\n\n...Please select a valid option.");
        }
    }

    // Input validation methods
    public String inputValidString(String prompt) {
        String value;
        do {
            System.out.print(prompt);
            value = input.nextLine().trim();
            if (value.isEmpty()) {
                MessageUI.displayInvalidInputMessage();
                MessageUI.displayEnterNonEmptyMessage();
            } else {
                break; // Valid input
            }
        } while (true);
        return value;
    }

    public String inputValidDonorType(String prompt) {
        String value;
        do {
            System.out.print(prompt);
            value = input.nextLine().trim().toLowerCase();

            if (value.isEmpty()) {
                MessageUI.displayInvalidInputMessage();
                MessageUI.displayEnterNonEmptyMessage();
            } else if (!value.equals("government") && !value.equals("private") && !value.equals("public")) {
                MessageUI.displayInvalidInputMessage();
                System.out.println("\nPlease enter 'Government', 'Private', or 'Public'.");
            } else {
                break; // Valid input, exit the loop
            }
        } while (true);
        return value;
    }

    private String inputValidDate(Scanner input, String prompt) {
        String value;
        String datePattern = "\\d{2}-\\d{2}-\\d{4}"; // Regular expression for DD-MM-YYYY
        do {
            System.out.print(prompt);
            value = input.nextLine().trim();

            if (value.isEmpty()) {
                MessageUI.displayInvalidInputMessage();
                MessageUI.displayEnterNonEmptyMessage();
            } else if (!value.matches(datePattern)) {
                MessageUI.displayInvalidDateMessage();
                MessageUI.displayInputValidDateMessage();
            } else {
                break; // Valid input, exit the loop
            }
        } while (true);
        return value;
    }

    public int inputValidInt(String prompt, int min, int max) {
        int choice;
        while (true) {
            System.out.print(prompt);
            try {
                choice = Integer.parseInt(input.nextLine());
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    MessageUI.displayInvalidInputMessage();
                    System.out.println("\nPlease enter a number between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                MessageUI.displayInvalidOptionMessage();
                MessageUI.displaySelectValidMessage();
            }
        }
    }

    public int inputValidChoice(String prompt, int min, int max) {
        int choice = -1;
        boolean valid = false;

        while (!valid) {
            System.out.print(prompt);

            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine(); // Consume newline

                if (choice >= min && choice <= max) {
                    valid = true;
                } else {
                    MessageUI.displayInvalidInputMessage();
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } else {
                MessageUI.displayInvalidInputMessage();
                MessageUI.displaySelectValidMessage();
                input.nextLine(); // Consume invalid input
            }
        }

        return choice;
    }

    // Methhod to validate amount entered
    public String inputValidAmount(String prompt) {
        String value;
        while (true) {
            System.out.print(prompt);
            value = input.nextLine().trim();
            if (value.matches("\\d+(\\.\\d{1,2})?")) {
                break; // Valid amount format
            } else {
                MessageUI.displayInvalidInputMessage();
                System.out.println("Please enter a valid amount (e.g., 100 or 100.50).");
            }
        }
        return value;
    }

    // Method to validate ic and phone number input
    private String inputValidateIC_Phone(String prompt) {
        String value;
        do {
            System.out.print(prompt);
            value = input.nextLine().trim();
            if (!value.matches("\\d+")) {
                MessageUI.displayInvalidInputMessage();
                MessageUI.displayEnterDigitsMessage();
            } else {
                break; // Valid input
            }
        } while (true);
        return value;
    }

    // Method to display a message to the user
    public void displayMessage(String message) {
        System.out.println(message);
    }
}
