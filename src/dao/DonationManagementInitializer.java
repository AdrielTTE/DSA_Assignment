package dao;

import control.DonationManagement;
import boundary.DonationManagementUI;
import adt.DoublyLinkedList;
import adt.SortedListInterface;
import entity.Donation;

/**
 *
 * @author Adriel
 */
public class DonationManagementInitializer {

    public DonationManagementInitializer() {

    }

    public SortedListInterface<Donation> initiateDonations() {
        SortedListInterface<Donation> donationList = new DoublyLinkedList<>();

        //To create Donor here (At least 15)
        donationList.add(donor, "Cash", "Money", 1, 9000);
        
        return donationList;
    }

}
