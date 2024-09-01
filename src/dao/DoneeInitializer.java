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
        doneeList.add(new Donee("The Smith Family", "Family", "D1001", "0123816275", 2, "2024-08-20"));
        doneeList.add(new Donee("HopeGivers", "Organisation", "D1002", "0195736581", 1, "2024-07-15"));
        doneeList.add(new Donee("Bob", "Individual", "D1003", "0115736581", 4, "2024-07-15"));
        doneeList.add(new Donee("Global Giving", "Organisation", "D1005", "0195736581", 1, "2024-07-15"));
        return doneeList;
    }

}
