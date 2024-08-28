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

    //To remove static?
    public static DonationManagementUI donationManagementUI = new DonationManagementUI();
    public static DonationManagement donationManagement = new DonationManagement();

    public DonationManagementInitializer() {

    }

    public SortedListInterface<Donation> initiateDonations() {
        SortedListInterface<Donation> donationList = new DoublyLinkedList<>();

        //To create Donor here
        donationList.add(donor, "Cash", "Money", 1, 9000);
        
        return donationList;
    }

}
