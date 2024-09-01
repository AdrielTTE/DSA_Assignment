package dao;

import adt.DoublyLinkedList;
import adt.SortedListInterface;
import entity.Donor;
import entity.Event;

/**
 *
 * @author Amanda Lee
 */
public class DonorInitializer {

    public static SortedListInterface<Donor> initializeDonors() {
        SortedListInterface<Donor> donorList = new DoublyLinkedList<>();

        donorList.add(new Donor("Adriel Tang Thien Ern", "Private", "030717121235", "0111112345", "Money: RM 1500.00", "12-07-2024"));
        donorList.add(new Donor("Adriel Tang Thien Ern", "Private", "030717121235", "0111112345", "Money: RM 10000.00", "9-08-2024"));
        donorList.add(new Donor("Amanda Lee Mun Yee", "Public", "03060133456", "0161227677", "Money: RM 1000.00", "28-07-2024"));
        donorList.add(new Donor("Jacquelin Ooi Jia Qi", "Private", "010101147270", "0173122222", "Money: RM 2500.00", "09-08-2024"));
        donorList.add(new Donor("Lee Cher Wei", "Government", "030507101261", "0164642610", "Toiletries", "01-08-2024"));
        donorList.add(new Donor("Yeoh Qi Yao", "Government", "030421122253", "0173231111", "Others: Toys", "09-08-2024"));
        donorList.add(new Donor("Chan Wai Leong", "Private", "030517142023", "0112673433", "Money: RM 15000.00", "12-08-2024"));
        donorList.add(new Donor("Wong Soon Kit", "Private", "030111102311", "0121764321", "Money: RM 7500.00", "10-08-2024"));
        donorList.add(new Donor("Chew Chun Sheng", "Private", "030726102567", "0164325674", "Money: RM 25000.00", "09-09-2024"));
        donorList.add(new Donor("Tan Xin Yi", "Private", "030123144564", "0124526547", "Money: RM 150000.00", "05-07-2024"));
        donorList.add(new Donor("Chong Zheng Yao", "Private", "000711142347", "01076035246", "Money: RM 200000.00", "24-06-2024"));
        donorList.add(new Donor("Jayvian", "Private", "010203102001", "0162456763", "Clothes", "26-08-2024"));
        donorList.add(new Donor("Lai Kok Sheng", "Government", "030714102515", "0131234345", "Food", "27-08-2024"));
        donorList.add(new Donor("Koh Zhen Pin", "Private", "031104105677", "0165656737", "Money: RM 3500.00", "28-08-2024"));
        donorList.add(new Donor("Chuah Chia Yun", "Public", "020112102221", "0121667543", "Toiletries", "29-09-2024"));
        donorList.add(new Donor("Mow Li Heng", "Government", "001122143573", "01111121232", "Clothes", "01-08-2024"));
        donorList.add(new Donor("Chin Hui Ling", "Private", "031214107264", "0167675465", "Money: RM 15000.00", "02-10-2024"));

        return donorList;
    }

    public static void addDonorToEvents(Event event, int[] donorIds, SortedListInterface<Donor> donorList) {
        for (int donorId : donorIds) {
            Donor donor = donorList.getEntry(donorId);
            if (donor != null) {
                event.setAssignedDonor(donor);
            } else {
                System.out.println("Debug: Donor with ID " + donorId + " not found");
            }
        }
    }
}
