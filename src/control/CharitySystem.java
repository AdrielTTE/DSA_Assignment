package control;

import boundary.CharitySystemUI;

import control.DonationManagement;
import control.DonorManagement;
import control.VolunteerSystem;
import control.DoneeManagement;

/**
 *
 * @author Adriel
 */
public class CharitySystem {

    private static CharitySystemUI charitySystemUI = new CharitySystemUI();

    public static void main(String[] args) {

        boolean cont = true;
        DonationManagement donationManagement = new DonationManagement();
        DonorManagement donorManagement = new DonorManagement();

        while (cont) {

            switch (charitySystemUI.mainMenu()) {
                case 1:
                    donorManagement.obtainDonationList(donationManagement.getDonationList());
                    donorManagement.runDonorManagement();
                    break;

                case 2:
                    DoneeManagement.startDoneeManagementSystem();
                    break;

                case 3:
                    donationManagement.obtainDonorList(donorManagement.getDonorList());
                    donationManagement.donationSelection();
                    break;

                case 4:
                    //Insert Donation Distribution Management here
                    break;

                case 5:
                    VolunteerSystem.startVolunteerSystem();
                    break;

                default:
                    cont = false;
                    break;

            }

        }

        System.out.println("\nHave a nice day!");
    }

}
