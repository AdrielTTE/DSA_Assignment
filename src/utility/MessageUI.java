package utility;

/**
 *
 * @author Paul
 */
public class MessageUI {

    public static void displayInvalidOptionMessage() {
        System.out.println("\n>> Invalid Option! <<");
    }

    public static void displaySelectValidMessage() {
        System.out.println("\n...Please select a valid option.");
    }

    public static void displayInvalidInputMessage() {
        System.out.println("\n>> Invalid Input! <<");
    }

    public static void displayEnterNonEmptyMessage() {
        System.out.println("\n...Please enter a non-empty value.");
    }

    public static void displayInvalidDateMessage() {
        System.out.println("\n>> Invalid date format <<");
    }

    public static void displayInputValidDateMessage() {
        System.out.println("\n...Please enter the date in DD-MM-YYYY format.");
    }

    public static void displayExitMessage() {
        System.out.println("\nExiting system...");
    }

    public static void displayDonorAddedMessage() {
        System.out.println("\n>> Donor added successfully! <<");
    }

    public static void displayDonorRemovedMessage() {
        System.out.println("\n>> Donor removed successfully! <<");
    }

    public static void displayDonorNotFoundMessage() {
        System.out.println("\n>> Donor not found! <<");
    }

    public static void displayRemovalCancelledMessage() {
        System.out.println("\n>> Removal operation cancelled <<");
    }

    public static void displayDonorDetailsUpdatedMessage() {
        System.out.println("\n>> Donor details updated successfully! <<");
    }

    public static void displayNoDonorsMessage() {
        System.out.println(">> No donors available <<");
    }

    public static void displayUpdateDonorOptions() {
        System.out.println("\nWhich detail would you like to update?");
        System.out.println("1. Donor Name");
        System.out.println("2. Donor Type");
        System.out.println("3. Donor IC");
        System.out.println("4. Donor Phone");
        System.out.println("5. Donor Donated");
        System.out.println("6. Donor Date Donated");
        System.out.println("7. Finish updating");
    }

    public static void displayListDonorMessage() {
        System.out.println("\n-->> List of all donors <<--\n");
    }

    public static void displayFilteredDonorMessage() {
        System.out.println("\n-->> Filtered Donors <<--\n");
    }

    public static void displayCategorizedDonorMessage() {
        System.out.println("\n-->> Categorized Donors <<--");
    }

    public static void displaySummaryReportMessage() {
        System.out.println("\n-->> Summary Report <<--");
    }

    public static void displayDonorListHeader() {
        System.out.println("+------------------------+------------+-----------------+-----------------+---------------------+-----------------+\n"
                + "| Donor Name             | Type       | IC              | Phone           | Donated             | Date Donated    |\n"
                + "+------------------------+------------+-----------------+-----------------+---------------------+-----------------+");
    }
    
    public static void displayDonationListHeader() {
        System.out.println("+------------------------+------------+-----------------+-----------------+-----------------+---------------------+-----------------+\n"
                         + "| Donor Name             | Type       | Item Name       | Category        | Quantity        | Value Per Item      | Total Value     |\n"
                         + "+------------------------+------------+-----------------+-----------------+-----------------+---------------------+-----------------+");
    }
    
    public static void displayDonationListFooter(){
        System.out.println("+------------------------+------------+-----------------+-----------------+-----------------+---------------------+-----------------+\n");
    }

    public static void displayDonorListFooter() {
        System.out.println("+------------------------+------------+-----------------+-----------------+---------------------+-----------------+");
    }

    public static void displayDonorTypeOptions() {
        System.out.println("\n>> Select Donor Type << ");
        System.out.println("1. Government");
        System.out.println("2. Private");
        System.out.println("3. Public");
    }

    public static void displayFilterDonorOptions() {
        System.out.println("\n>> Select Donor Type to filter << ");
        System.out.println("1. Government");
        System.out.println("2. Private");
        System.out.println("3. Public");
    }

    public static void displayDonationType() {
        System.out.println("\nChoose the type of donation:");
        System.out.println("1. Money");
        System.out.println("2. Food");
        System.out.println("3. Toiletries");
        System.out.println("4. Clothes");
        System.out.println("5. Others");
    }

    public static void displayEnterDigitsMessage() {
        System.out.println("\n...Please enter a valid number containing digits only.");
    }
}
