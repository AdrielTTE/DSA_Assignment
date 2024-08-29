/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/*
//Author name : Jacquelin Ooi Jia Qi
//Student ID : 23WMR07647
//Programme : RSD2S1G1
*/
import adt.DoublyLinkedList;
import adt.SortedListInterface;
import entity.Event;
import entity.Volunteer;
import java.time.LocalDate;

public class VolunteerData {
    
    public static SortedListInterface<Volunteer> initializeVolunteers() {
        SortedListInterface<Volunteer> volunteerList = new DoublyLinkedList<>();
        
        volunteerList.add(new Volunteer("Adam", 30, "M"));
		volunteerList.add(new Volunteer("Aiden", 18, "M"));
		volunteerList.add(new Volunteer("Alice", 32, "F"));
		volunteerList.add(new Volunteer("Amelia", 19, "F"));
		volunteerList.add(new Volunteer("Babala", 17, "F"));

		volunteerList.add(new Volunteer("Beatrice", 34, "F"));
		volunteerList.add(new Volunteer("Bella", 25, "F"));
		volunteerList.add(new Volunteer("Ben", 35, "M"));
		volunteerList.add(new Volunteer("Bob", 16, "M"));
		volunteerList.add(new Volunteer("Bradley", 25, "M"));//10

		volunteerList.add(new Volunteer("Carmen", 24, "F"));
		volunteerList.add(new Volunteer("Catherine", 31, "F"));
		volunteerList.add(new Volunteer("Charlotte", 35, "F"));
		volunteerList.add(new Volunteer("Chloe", 22, "F"));
		volunteerList.add(new Volunteer("Colin", 22, "M"));

		volunteerList.add(new Volunteer("Daniel", 31, "M"));
		volunteerList.add(new Volunteer("David", 40, "M"));
		volunteerList.add(new Volunteer("Diana", 28, "F"));
		volunteerList.add(new Volunteer("Dora", 30, "F"));
		volunteerList.add(new Volunteer("Emily", 21, "F"));//20

		volunteerList.add(new Volunteer("Emma", 28, "F"));
		volunteerList.add(new Volunteer("Eva", 21, "F"));
		volunteerList.add(new Volunteer("Felicia", 32, "F"));
		volunteerList.add(new Volunteer("Felix", 22, "M"));
		volunteerList.add(new Volunteer("Fiona", 27, "F"));

		volunteerList.add(new Volunteer("Frank", 29, "M"));
		volunteerList.add(new Volunteer("Finn", 20, "M"));
		volunteerList.add(new Volunteer("George", 29, "M"));
		volunteerList.add(new Volunteer("Gina", 32, "F"));
		volunteerList.add(new Volunteer("Grace", 25, "F"));//30

		volunteerList.add(new Volunteer("Gwen", 22, "F"));
		volunteerList.add(new Volunteer("Hanna", 27, "F"));
		volunteerList.add(new Volunteer("Hannah", 26, "F"));
		volunteerList.add(new Volunteer("Henry", 38, "M"));
		volunteerList.add(new Volunteer("Holly", 30, "F"));

		volunteerList.add(new Volunteer("Hugo", 19, "M"));
		volunteerList.add(new Volunteer("Ian", 40, "M"));
		volunteerList.add(new Volunteer("Iris", 27, "F"));
		volunteerList.add(new Volunteer("Isabella", 17, "F"));
		volunteerList.add(new Volunteer("Ivy", 30, "F"));//40

		volunteerList.add(new Volunteer("Jake", 30, "M"));
		volunteerList.add(new Volunteer("James", 19, "M"));
		volunteerList.add(new Volunteer("Jack", 26, "M"));
		volunteerList.add(new Volunteer("Jacquelin", 23, "F"));
		volunteerList.add(new Volunteer("Jasmine", 31, "F"));

		volunteerList.add(new Volunteer("Kara", 27, "F"));
		volunteerList.add(new Volunteer("Katherine", 24, "F"));
		volunteerList.add(new Volunteer("Kevin", 31, "M"));
		volunteerList.add(new Volunteer("Kyle", 24, "M"));
		volunteerList.add(new Volunteer("Laura", 34, "F"));//50

		volunteerList.add(new Volunteer("Liam", 16, "M"));
		volunteerList.add(new Volunteer("Lily", 18, "F"));
		volunteerList.add(new Volunteer("Lucas", 25, "M"));
		volunteerList.add(new Volunteer("Mark", 29, "M"));
		volunteerList.add(new Volunteer("Marcus", 22, "M"));

		volunteerList.add(new Volunteer("Mason", 21, "M"));
		volunteerList.add(new Volunteer("Maya", 22, "F"));
		volunteerList.add(new Volunteer("Mia", 16, "F"));
		volunteerList.add(new Volunteer("Natalie", 28, "F"));
		volunteerList.add(new Volunteer("Nathan", 34, "M"));//60

		volunteerList.add(new Volunteer("Noah", 19, "M"));
		volunteerList.add(new Volunteer("Olivia", 28, "F"));
		volunteerList.add(new Volunteer("Oscar", 26, "M"));
		volunteerList.add(new Volunteer("Paige", 23, "F"));
		volunteerList.add(new Volunteer("Peter", 26, "M"));

		volunteerList.add(new Volunteer("Penny", 30, "F"));
		volunteerList.add(new Volunteer("Quincy", 20, "F"));
		volunteerList.add(new Volunteer("Quinton", 33, "M"));
		volunteerList.add(new Volunteer("Rebecca", 29, "F"));
		volunteerList.add(new Volunteer("Ray", 33, "M"));//70

		volunteerList.add(new Volunteer("Riley", 24, "F"));
		volunteerList.add(new Volunteer("Rosa", 27, "F"));
		volunteerList.add(new Volunteer("Ryan", 24, "M"));
		volunteerList.add(new Volunteer("Samantha", 35, "F"));
		volunteerList.add(new Volunteer("Sean", 30, "M"));

		volunteerList.add(new Volunteer("Steve", 28, "M"));
		volunteerList.add(new Volunteer("Tara", 35, "F"));
		volunteerList.add(new Volunteer("Trent", 22, "M"));
		volunteerList.add(new Volunteer("Tina", 31, "F"));
		volunteerList.add(new Volunteer("Tyler", 40, "M"));//80

		volunteerList.add(new Volunteer("Ulysses", 20, "M"));
		volunteerList.add(new Volunteer("Ursula", 33, "F"));
		volunteerList.add(new Volunteer("Victor", 28, "M"));
		volunteerList.add(new Volunteer("Vera", 27, "F"));
		volunteerList.add(new Volunteer("Violet", 27, "F"));

		volunteerList.add(new Volunteer("Wendy", 37, "F"));
		volunteerList.add(new Volunteer("Will", 30, "M"));
		volunteerList.add(new Volunteer("Wyatt", 24, "M"));
		volunteerList.add(new Volunteer("Xander", 30, "M"));
		volunteerList.add(new Volunteer("Xena", 22, "F"));//90

		volunteerList.add(new Volunteer("Yara", 26, "F"));
		volunteerList.add(new Volunteer("Yosef", 28, "M"));
		volunteerList.add(new Volunteer("Yves", 22, "M"));
		volunteerList.add(new Volunteer("Zach", 29, "M"));
		volunteerList.add(new Volunteer("Zane", 23, "M"));

		volunteerList.add(new Volunteer("Zara", 31, "F"));//96
        
        return volunteerList;
    }
    public static SortedListInterface<Event> initializeEvents() {
        SortedListInterface<Event> eventList = new DoublyLinkedList<>();
        
        eventList.add(new Event("Forest Contribution", LocalDate.of(2024, 11, 24), 30));
        eventList.add(new Event("Dedicated Love", LocalDate.of(2024, 12, 25), 15));
        eventList.add(new Event("Pamper Pets", LocalDate.of(2025, 1, 13), 25));
        eventList.add(new Event("Nature Regeneration", LocalDate.of(2025, 1, 27), 25));
        eventList.add(new Event("Blood Circulation", LocalDate.of(2025, 3, 9), 20));
        eventList.add(new Event("Charity Sale Donations", LocalDate.of(2025, 3, 15), 35));
        
        return eventList;
    }
    
    public static void addVolunteersToEvent(Event event, int[] volunteerIds, SortedListInterface<Volunteer> volunteerList) {
        for (int id : volunteerIds) {
            Volunteer volunteer = volunteerList.getEntry(id);
            if (volunteer != null) {
                event.addVolunteer(volunteer);
            } else {
                System.out.println("Error: Volunteer with ID " + id + " is null or does not exist.");
            }
        }
    }
}
