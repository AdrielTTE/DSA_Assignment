package dao;

import control.DonationManagement;
import boundary.DonationManagementUI;
import adt.DoublyLinkedList;
import adt.SortedListInterface;
import entity.Donation;
import entity.Donor;

/**
 *
 * @author Adriel
 */
public class DonationManagementInitializer {

    public DonationManagementInitializer() {

    }

    public SortedListInterface<Donation> initiateDonations() {
        SortedListInterface<Donation> donationList = new DoublyLinkedList<>();
        
        donationList.add(new Donation(new Donor("Adriel", "Private", "030717140615", "0163231053", "Cash", "30/8/2024"), "Cash", "Money", 1, 9000));
        donationList.add(new Donation(new Donor("Amanda", "Public", "030897162361234", "0168673618", "Pens", "30/8/2024"), "Pens", "Stationary", 200, 2));
        donationList.add(new Donation(new Donor("Cher Wei", "Government", "03081793727", "0109279382", "Note Books", "30/8/2024"), "Note Books", "Books", 500, 5));
        donationList.add(new Donation(new Donor("Jacquelin", "Private", "0109293892", "018917198", "T-Shirts", "30/8/2024"), "T-Shirts", "Clothes", 200, 20));
        donationList.add(new Donation(new Donor("Qi Yao", "Public", "03019873815", "0163231053", "Cash", "30/8/2024"), "Cash", "Money", 1, 9000));
        donationList.add(new Donation(new Donor("Matthew", "Private", "03019873816", "0163231054", "Cheque", "29/8/2024"), "Cheque", "Money", 2, 5000));
        donationList.add(new Donation(new Donor("Gerard", "Government", "03019873817", "0163231055", "Beddings", "28/8/2024"), "Beddings", "Sleep Items", 3, 200));
        donationList.add(new Donation(new Donor("Amos", "Public", "03019873818", "0163231056", "Cash", "27/8/2024"), "Cash", "Money", 1, 12000));
        donationList.add(new Donation(new Donor("Andrew", "Private", "03019873819", "0163231057", "Canned Food", "26/8/2024"), "Canned Food", "Food Items", 2000, 10));
        donationList.add(new Donation(new Donor("Keith", "Government", "03019873820", "0163231058", "Laptop", "25/8/2024"), "Laptop", "Other", 4, 2500));
        donationList.add(new Donation(new Donor("Kavern", "Public", "03019873821", "0163231059", "Cash", "24/8/2024"), "Cash", "Money", 1, 7000));
        donationList.add(new Donation(new Donor("Timothy", "Private", "03019873822", "0163231060", "Cheque", "23/8/2024"), "Cheque", "Money", 2, 4000));
        donationList.add(new Donation(new Donor("Stephanie", "Government", "03019873823", "0163231061", "Mattress", "22/8/2024"), "Mattress", "Sleep Items", 10, 500));
        donationList.add(new Donation(new Donor("Nicole", "Public", "03019873824", "0163231062", "Cash", "21/8/2024"), "Cash", "Money", 1, 11000));
        donationList.add(new Donation(new Donor("Myan Seng", "Private", "03019873825", "0163231063", "Cheque", "20/8/2024"), "Cheque", "Money", 2, 6000));
        
        
        return donationList;
    }

}
