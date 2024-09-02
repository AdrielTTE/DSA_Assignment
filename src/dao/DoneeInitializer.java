package dao;

//Author name : Yeoh Qi yao
//Student ID : 23WMR07680
//Programme : RSD2S1G1
import adt.*;
import entity.Donee;

public class DoneeInitializer {

    // Method to return a collection of Donee entities with hard-coded values
    public SortedListInterface<Donee> initializeDonees() {
        SortedListInterface<Donee> doneeList = new DoublyLinkedList<>();
        doneeList.add(new Donee("Abigail", "Individual", "D1004", "0124247041", 3, "2024-07-15"));
        doneeList.add(new Donee("The Smith Family", "Family", "D1001", "0311185812", 2, "2024-08-20"));
        doneeList.add(new Donee("HopeGivers", "Organisation", "D1002", "0311208617", 1, "2024-07-11"));
        doneeList.add(new Donee("Bob", "Individual", "D1003", "0115736581", 4, "2024-07-15"));
        doneeList.add(new Donee("Global Giving", "Organisation", "D1005", "0195736581", 1, "2024-07-15"));

        doneeList.add(new Donee("Jackie Yeoh", "Individual", "D1007", "0113876152", 5, "2024-08-16"));
        doneeList.add(new Donee("Tan Family", "Family", "D1006", "0339172615", 3, "2024-07-12"));
        doneeList.add(new Donee("Jackie Chan", "Individual", "D1009", "0197718231", 10, "2024-06-29"));
        doneeList.add(new Donee("PlayFun Gaming", "Organisation", "D1008", "0331071012", 3, "2024-07-15"));
        doneeList.add(new Donee("Zhang Zhi Yi", "Individual", "D1011", "0122381961", 1, "2024-08-25"));

        doneeList.add(new Donee("Be Smart", "Organisation", "D1012", "0321817612", 11, "2024-08-25"));
        doneeList.add(new Donee("Ang Cheng Ping", "Individual", "D1010", "0124547241", 21, "2024-05-11"));
        doneeList.add(new Donee("Cheng Family", "Family", "D1013", "0311765124", 8, "2024-07-25"));
        doneeList.add(new Donee("ABC-Bank", "Organisation", "D1015", "0387162514", 13, "2024-06-10"));
        doneeList.add(new Donee("SSS-ProGaming", "Organisation", "D1014", "0311887261", 25, "2024-08-21"));
        return doneeList;
    }

}
