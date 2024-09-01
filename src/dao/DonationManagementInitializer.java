package dao;

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

        donationList.add(new Donation(new Donor("Adriel Tang Thien Ern", "Private", "030717121235", "0111112345", "Money: RM 1500.00", "12-07-2024"), "Cash", "Money", 1, 1500));
        donationList.add(new Donation(new Donor("Adriel Tang Thien Ern", "Private", "030717121235", "0111112345", "Money: RM 10000.00", "9-08-2024"), "Cash", "Money", 1, 10000));
        donationList.add(new Donation(new Donor("Amanda Lee Mun Yee", "Public", "03060133456", "0161227677", "Money: RM 1000.00", "28-07-2024"), "Cash", "Money", 1, 1000));
        donationList.add(new Donation(new Donor("Lee Cher Wei", "Government", "030507101261", "0164642610", "Toiletries", "01-08-2024"), "Toiletries", "Other", 200, 20));
        donationList.add(new Donation(new Donor("Yeoh Qi Yao", "Government", "030421122253", "0173231111", "Others: Toys", "09-08-2024"), "Toys", "Other", 200, 50));
        donationList.add(new Donation(new Donor("Chan Wai Leong", "Private", "030517142023", "0112673433", "Money: RM 15000.00", "12-08-2024"), "Cash", "Money", 1, 15000));
        donationList.add(new Donation(new Donor("Wong Soon Kit", "Private", "030111102311", "0121764321", "Money: RM 7500.00", "10-08-2024"), "Cash", "Money", 1, 7500));
        donationList.add(new Donation(new Donor("Chew Chun Sheng", "Private", "030726102567", "0164325674", "Money: RM 25000.00", "09-09-2024"), "Cash", "Money", 1, 25000));
        donationList.add(new Donation(new Donor("Tan Xing Ye", "Private", "030123144564", "0124526547", "Money: RM 150000.00", "05-07-2024"), "Cash", "Money", 1, 150000));
        donationList.add(new Donation(new Donor("Chong Zheng Yao", "Private", "000711142347", "01076035246", "Money: RM 200000.00", "24-06-2024"), "Cash", "Money", 1, 200000));
        donationList.add(new Donation(new Donor("Jayvian", "Private", "010203102001", "0162456763", "Clothes", "26-08-2024"), "Clothes", "Clothes", 1, 7000));
        donationList.add(new Donation(new Donor("Lai Kok Sheng", "Government", "030714102515", "0131234345", "Food", "27-08-2024"), "Food", "Food Items", 900, 15));
        donationList.add(new Donation(new Donor("Koh Zhen Pin", "Private", "031104105677", "0165656737", "Money: RM 3500.00", "28-08-2024"), "Cash", "Money", 1, 3500));
        donationList.add(new Donation(new Donor("Chuah Chia Yun", "Public", "020112102221", "0121667543", "Toiletries", "29-09-2024"), "Toiletries", "Other", 200, 11));
        donationList.add(new Donation(new Donor("Mow Li Heng", "Government", "001122143573", "01111121232", "Clothes", "01-08-2024"), "Clothes", "Clothes", 150, 6));
        donationList.add(new Donation(new Donor("Chin Hui Ling", "Private", "031214107264", "0167675465", "Money: RM 15000.00", "02-10-2024"), "Cash", "Money", 1, 15000));

        return donationList;
    }

}
