package control;

/**
 *
 * @author Adriel
 */
import java.util.Comparator;
import entity.Donation;
import entity.Donor;

import adt.DoublyLinkedList;
import adt.SortedListInterface;

import boundary.DonationManagementUI;

import dao.DonationManagementInitializer;

import utility.CheckNumberInput;
import utility.MessageUI;

// Pass object as parameter to access from different classes
public class DonationManagement {

    //Creating relevant objects
    private DonationManagementUI donationManagementUI;
    private DonationManagementInitializer donationInitializer = new DonationManagementInitializer();
    private SortedListInterface<Donation> donationList = donationInitializer.initiateDonations();
    private SortedListInterface<Donor> donorList;
//private DonorManagement donorManagement;

    //Constructor
    public DonationManagement() {
        this.donationManagementUI = new DonationManagementUI(this);
        sortList();

    }

    public DonationManagement getDonationManagement(DonationManagement donationManagement) {
        return donationManagement;
    }

    public void donationSelection() {
        boolean cont = true;
        while (cont) {

            switch (donationManagementUI.donManMenu()) {
                case 1:
                    addDonation();
                    break;

                case 2:
                    removeDonation();
                    break;

                case 3:
                    searchDonation();
                    break;

                case 4:
                    amendDonation();
                    break;

                case 5:
                    displayDonation();
                    break;

                case 6:
                    generateReport();
                    break;

                default:
                    cont = false;
                    break;

            }
        }
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

    //For adding a new Donation
    public void addDonation() {
        donationManagementUI.addNewDonationMenu();

    }

    public boolean addNewDonation(Donor donor, String itemDonated, String category, int quantity, double valuePerQuantity) {

        donationList.add(new Donation(donor, itemDonated, category, quantity, valuePerQuantity));
        donorList.add(donor);
        return true;
    }

    //For removing a Donation
    public boolean removeDonation() {
        boolean result = false;

        if (donationList.remove(donationList.getEntry(donationManagementUI.removeDonationMenu()))) {

            result = true;
            donationManagementUI.removedDonation(result);
        }

        return result;
    }

    public SortedListInterface<Donation> searchDonation() {
        SortedListInterface<Donation> searchedDonationList = new DoublyLinkedList<>();
        Donation searchItem = new Donation();
        Donor searchDonor = new Donor(); // Initialize the Donor object

        String search = donationManagementUI.searchDonationMenu();

        // Set all fields of the donor and donation with the search string
        searchDonor.setDonorName(search);
        searchDonor.setDonorType(search);
        searchDonor.setDonorIC(search);
        searchDonor.setDonorPhone(search);
        searchDonor.setDonorDonated(search);
        searchDonor.setDonorDateDonated(search);

        searchItem.setDonor(searchDonor);
        searchItem.setItemDonated(search);
        searchItem.setCategory(search);

        int count = 1;
        int searchCount = 0;
        while (count <= donationList.getNumOfEntries()) {
            Donation currentDonation = donationList.getEntry(count);

            // Check if the current donation matches the search criteria
            if (currentDonation.getDonor().getDonorName().equalsIgnoreCase(searchDonor.getDonorName())
                    || currentDonation.getDonor().getDonorType().equalsIgnoreCase(searchDonor.getDonorType())
                    || currentDonation.getDonor().getDonorIC().equalsIgnoreCase(searchDonor.getDonorIC())
                    || currentDonation.getDonor().getDonorPhone().equalsIgnoreCase(searchDonor.getDonorPhone())
                    || currentDonation.getItemDonated().equalsIgnoreCase(searchItem.getItemDonated())
                    || currentDonation.getCategory().equalsIgnoreCase(searchItem.getCategory())) {

                // Add the matching donation to the searchedDonationList
                searchedDonationList.add(currentDonation);
                searchCount++;
            }
            count++;
        }

        // Display the matched donations
        donationManagementUI.displaySearchedDonations(searchedDonationList, searchCount);
        return searchedDonationList;
    }

    public void amendDonation() {

        int choice;
        boolean result = false;
        Donation amendDonation = new Donation();
        choice = donationManagementUI.amendDonationMenu();
        if (choice != 0) {
            switch (donationManagementUI.attributeToChange(amendDonation)) {
                case 1:
                    amendDonation.setDonor(donationManagementUI.changeDonor());
                    break;

                case 2:
                    amendDonation.setItemDonated(donationManagementUI.changeDonatedItem());
                    break;

                case 3:
                    amendDonation.setCategory(donationManagementUI.chooseCategories());
                    break;

                case 4:
                    amendDonation.setQuantity(donationManagementUI.changeQuantity());
                    amendDonation.updateTotalValue();
                    break;

                case 5:
                    amendDonation.setValuePerQuantity(donationManagementUI.changeValuePerItem());
                    amendDonation.updateTotalValue();
                    break;

                default:
                    break;

            }

            donationManagementUI.displayChangedDonation(amendDonation);
        }

    }

    public Donation getDonation(int position) {
        return donationList.getEntry(position);
    }

    public void displayDonation() {

        switch (donationManagementUI.displayListMenu(donationList)) {
            case 1:
                filter();
                break;

            default:
                //To add logic
                break;

        }

    }

    public void filter() {
        switch (donationManagementUI.filterBy()) {
            case 1:
                filterDonor();
                break;

            case 2:
                searchDonation();
                break;

            case 3:
                filterByCategory();
                break;
        }
    }

    public SortedListInterface<Donation> filterByCategory() {
        SortedListInterface<Donation> searchedDonationList = new DoublyLinkedList<>();
        Donation searchItem = new Donation();

        searchItem.setCategory(donationManagementUI.chooseCategories());

        int count = 1;
        while (count <= donationList.getNumOfEntries()) {

            if (donationList.getEntry(count).getCategory().equalsIgnoreCase(searchItem.getCategory())) {
                searchedDonationList.add(donationList.getEntry(count));

            }

            count++;
        }

        donationManagementUI.displayFilteredBy(searchedDonationList);
        return searchedDonationList;
    }

    public void filterDonor() {
        switch (donationManagementUI.getDonorAttribute()) {
            case 1:
                filterByDonorName();
                break;

            default:
                filterByDonorType();
                break;

        }
    }

    public SortedListInterface<Donation> filterByDonorName() {
        SortedListInterface<Donation> searchedDonationList = new DoublyLinkedList<>();
        Donation searchItem = new Donation();
        Donor searchItemDonor = new Donor();
        searchItemDonor.setDonorName(donationManagementUI.getDonorName());
        searchItem.setDonor(searchItemDonor);

        int count = 1;
        while (count <= donationList.getNumOfEntries()) {

            if (donationList.getEntry(count).getDonor().getDonorName().equalsIgnoreCase(searchItemDonor.getDonorName())) {
                searchedDonationList.add(donationList.getEntry(count));

            }

            count++;
        }

        donationManagementUI.displayFilteredBy(searchedDonationList);
        return searchedDonationList;
    }

    public SortedListInterface<Donation> filterByDonorType() {
        SortedListInterface<Donation> searchedDonationList = new DoublyLinkedList<>();
        Donation searchItem = new Donation();
        searchItem.getDonor().setDonorType(donationManagementUI.getDonorType());

        int count = 1;
        while (count <= donationList.getNumOfEntries()) {
            searchedDonationList.add(donationList.search(searchItem));
            count++;
        }

        return searchedDonationList;
    }

    public void generateReport() {
        switch (donationManagementUI.generateReportMenu()) {
            case 1:
                totalValuationReport();
                break;

            case 2:
                catecorigalBreakDownReport();
                break;

            case 3:
                sortByDonorReport();
                break;

            default:
                break;
        }
        //ToString method, written in report format
    }

    public void totalValuationReport() {
        SortedListInterface<Donation> valuationReport = new DoublyLinkedList<>();
        double totalValuation = 0;
        for (int i = 1; i <= donationList.getNumOfEntries(); i++) {
            totalValuation += donationList.getEntry(i).getTotalValue();
        }

        donationManagementUI.displayTotalValuationReport(donationList, totalValuation);

    }

    public void catecorigalBreakDownReport() {
        SortedListInterface<Donation> moneyDonationsList = new DoublyLinkedList<>();
        SortedListInterface<Donation> clothesDonationsList = new DoublyLinkedList<>();
        SortedListInterface<Donation> sleepItemsDonationsList = new DoublyLinkedList<>();
        SortedListInterface<Donation> foodItemsDonationsList = new DoublyLinkedList<>();
        SortedListInterface<Donation> booksDonationsList = new DoublyLinkedList<>();
        SortedListInterface<Donation> stationaryDonationsList = new DoublyLinkedList<>();
        SortedListInterface<Donation> othersDonationsList = new DoublyLinkedList<>();

        for (int i = 1; i <= donationList.getNumOfEntries(); i++) {
            switch (donationList.getEntry(i).getCategory()) {
                case "Money":
                    moneyDonationsList.add(donationList.getEntry(i));
                    break;

                case "Clothes":
                    clothesDonationsList.add(donationList.getEntry(i));
                    break;

                case "Sleep Items":
                    sleepItemsDonationsList.add(donationList.getEntry(i));
                    break;

                case "Food Items":
                    foodItemsDonationsList.add(donationList.getEntry(i));
                    break;

                case "Books":
                    booksDonationsList.add(donationList.getEntry(i));
                    break;

                case "Stationary":
                    stationaryDonationsList.add(donationList.getEntry(i));
                    break;

                default:
                    othersDonationsList.add(donationList.getEntry(i));
                    break;
            }
        }
        donationManagementUI.categoricalReport();
        donationManagementUI.displayCategoricalReport(moneyDonationsList, "Money");
        donationManagementUI.displayCategoricalReport(clothesDonationsList, "Clothes");
        donationManagementUI.displayCategoricalReport(sleepItemsDonationsList, "Sleep Items");
        donationManagementUI.displayCategoricalReport(foodItemsDonationsList, "Food Items");
        donationManagementUI.displayCategoricalReport(booksDonationsList, "Books");
        donationManagementUI.displayCategoricalReport(stationaryDonationsList, "Stationary");
        donationManagementUI.displayCategoricalReport(othersDonationsList, "Others");
        donationManagementUI.endOfCategoricalReport();
    }

    //priva
    public void sortList() {
        Comparator<Donation> donorComparator = new Comparator<Donation>() {
            @Override
            public int compare(Donation d1, Donation d2) {
                return d1.getDonor().getDonorName().compareToIgnoreCase(d2.getDonor().getDonorName());
            }
        };

        // Sort the donationList using the comparator
        donationList.sort(donorComparator);
    }

    public void sortByDonorReport() {
        // Create a new DoublyLinkedList to hold the sorted donations
        SortedListInterface<Donation> sortedByDonorList = new DoublyLinkedList<>();

        // Create a comparator to sort donations by donor name
        Comparator<Donation> donorComparator = new Comparator<Donation>() {
            @Override
            public int compare(Donation d1, Donation d2) {
                return d1.getDonor().getDonorName().compareToIgnoreCase(d2.getDonor().getDonorName());
            }
        };

        // Sort the donationList using the comparator
        donationList.sort(donorComparator);

        // Variables to keep track of current donor and their donations
        String currentDonorName = null;
        SortedListInterface<Donation> currentDonationList = new DoublyLinkedList<>();
        donationManagementUI.displaySortedByDonorListHeader();
        // Iterate over the sorted donationList
        for (int i = 1; i <= donationList.getNumOfEntries(); i++) {
            Donation donation = donationList.getEntry(i);
            String donorName = donation.getDonor().getDonorName();

            // Check if we have moved to a new donor
            if (currentDonorName != null && !donorName.equalsIgnoreCase(currentDonorName)) {
                // Print donations for the current donor

                donationManagementUI.displaySortedByDonorList(currentDonationList, currentDonorName);

                // Add the current donor's donations to the sortedByDonorList
                for (int j = 1; j <= currentDonationList.getNumOfEntries(); j++) {
                    sortedByDonorList.add(currentDonationList.getEntry(j));
                }

                // Start a new list for the new donor
                currentDonationList = new DoublyLinkedList<>();
            }

            // Add the current donation to the current donor's list
            currentDonationList.add(donation);
            currentDonorName = donorName;
        }

        // Handle the last donor's donations
        if (currentDonorName != null) {
            donationManagementUI.displayLastSortedByDonorList(currentDonationList, currentDonorName);

            // Add the last donor's donations to the sortedByDonorList
            for (int j = 1; j <= currentDonationList.getNumOfEntries(); j++) {
                sortedByDonorList.add(currentDonationList.getEntry(j));
            }
        }

    }

}
