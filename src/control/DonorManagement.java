package control;

import adt.SortedListInterface;
import boundary.DonorManagement_UI;
import entity.Donor;
import utility.MessageUI;
import dao.DonorInitializer;
import entity.Donation;

/**
 *
 * @author Amanda Lee
 */
public class DonorManagement {

    private DonorManagement_UI donorUI = new DonorManagement_UI();
    private DonorInitializer donorInitializer = new DonorInitializer();
    private SortedListInterface<Donor> donorList = donorInitializer.initializeDonors();
    private SortedListInterface<Donation> donationList;

    public void runDonorManagement() {
        int choice;

        do {
            choice = donorUI.getMenuChoice();
            switch (choice) {
                case 1:
                    addNewDonor();
                    break;
                case 2:
                    removeDonor();
                    break;
                case 3:
                    searchAndUpdateDonor();
                    break;
                case 4:
                    searchDonor();
                    break;
                case 5:
                    listDonors();
                    break;
                case 6:
                    filterDonors();
                    break;
                case 7:
                    categorizeDonors();
                    break;
                case 8:
                    generateSummaryReport();
                    break;
                case 9:
                    MessageUI.displayExitMessage();
                    break;
                default:
                    MessageUI.displayInvalidOptionMessage();
                    MessageUI.displaySelectValidMessage();
            }
        } while (choice != 9);
    }

    public SortedListInterface<Donation> getDonationList() {
        return donationList;
    }

    public SortedListInterface<Donor> getDonorList() {
        return donorList;
    }

    public void obtainDonorList(SortedListInterface<Donor> donorList) {
        this.donorList = donorList;
    }

    public void obtainDonationList(SortedListInterface<Donation> donationList) {
        this.donationList = donationList;
    }

    public void addNewDonor() {
        Donor newDonor = donorUI.inputDonorDetails();
        donorList.add(newDonor);
        donationList.add(new Donation(newDonor, newDonor.getDonorDonated(), "", 0, 0));

        MessageUI.displayDonorAddedMessage();
    }

    public void removeDonor() {
        boolean donorRemoved = false;

        while (!donorRemoved) {
            String donorName = donorUI.inputRemoveDonor();
            Donor donorToRemove = new Donor(donorName);

            if (donorList.remove(donorToRemove)) {

                MessageUI.displayDonorRemovedMessage();
                donorRemoved = true; // Exit loop when donor is successfully removed
            } else {
                MessageUI.displayDonorNotFoundMessage();
                String choice = donorUI.inputValidString("Do you want to try again? (Y/N): ").toUpperCase();
                if (choice.equals("N")) {
                    donorRemoved = true; // Exit loop if user chooses not to try again
                    MessageUI.displayRemovalCancelledMessage();
                }
            }
        }
    }

    public void searchAndUpdateDonor() {
        Donor foundDonor = searchDonor();
        Donation foundDonation = searchDonation(foundDonor);
        if (foundDonor != null) {
            donorUI.updateDonor(foundDonor, foundDonation);
            MessageUI.displayDonorDetailsUpdatedMessage();
        } else {
            MessageUI.displayDonorNotFoundMessage();
        }
    }

    public Donor searchDonor() {
        Donor foundDonor = null;
        boolean exitSearch = false;

        while (!exitSearch) {
            String donorName = donorUI.inputDonorName();
            foundDonor = donorList.search(new Donor(donorName));

            if (foundDonor != null) {
                donorUI.displayMessage("\nDonor Found: " + foundDonor);
                exitSearch = true; // Exit loop when donor is found
            } else {
                MessageUI.displayDonorNotFoundMessage();
                String choice = donorUI.inputValidString("Do you want to try again? (Y/N): ").toUpperCase();
                if (choice.equals("N")) {
                    exitSearch = true; // Exit loop if user chooses not to try again
                }
            }
        }

        return foundDonor;
    }

    public Donation searchDonation(Donor foundDonor) {
        Donation foundDonation = new Donation();
        foundDonation.setDonor(foundDonor);

        for (int i = 1; i <= donationList.getNumOfEntries(); i++) {
            if (foundDonation.getDonor().equals(donationList.getEntry(i).getDonor())) {
                foundDonation = donationList.getEntry(i);
            }
        }

        return foundDonation;
    }

    public void listDonors() {
        if (donorList.getNumOfEntries() == 0) {
            MessageUI.displayNoDonorsMessage();
            return;
        }

        MessageUI.displayListDonorMessage();
        MessageUI.displayDonorListHeader();

        // Print each donor in the list
        for (int i = 1; i <= donorList.getNumOfEntries(); i++) {
            donorUI.displayMessage(donorList.getEntry(i).toString());
        }

        MessageUI.displayDonorListFooter();
    }

    public void filterDonors() {
        // Get the donor type from the user
        String type = donorUI.inputFilterDonors();

        // Display filtered donors
        boolean found = false;
        MessageUI.displayFilteredDonorMessage();

        // Iterate through the donor list
        for (int i = 1; i <= donorList.getNumOfEntries(); i++) {
            Donor donor = donorList.getEntry(i);

            // Check if donor type matches the user input
            if (donor.getDonorType().equalsIgnoreCase(type)) {
                donorUI.displayMessage(donor.toString());
                found = true;
            }
        }

        if (!found) {
            donorUI.displayMessage("\nNo donors found with the type: " + type);
        }
    }

    public void categorizeDonors() {
        MessageUI.displayCategorizedDonorMessage();
        donorUI.displayMessage("\n>> Government <<");
        filterByType("government");
        donorUI.displayMessage("\n>> Private <<");
        filterByType("private");
        donorUI.displayMessage("\n>> Public <<");
        filterByType("public");
    }

    public void filterByType(String type) {
        for (int i = 1; i <= donorList.getNumOfEntries(); i++) {
            Donor donor = donorList.getEntry(i);
            if (donor.getDonorType().equalsIgnoreCase(type)) {
                donorUI.displayMessage(donor.toString());
            }
        }
    }

    public void generateSummaryReport() {
        MessageUI.displaySummaryReportMessage();
        donorUI.displayMessage("\nTotal Donors: " + donorList.getNumOfEntries());
        categorizeDonors();
    }
}
