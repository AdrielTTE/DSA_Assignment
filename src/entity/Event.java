package entity;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
//Author name : Jacquelin Ooi Jia Qi
//Student ID : 23WMR07647
//Programme : RSD2S1G1
*/
import adt.DoublyLinkedList;
import adt.SortedListInterface;
import entity.Donor;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Event implements Comparable<Event>{
    private final String name;
    private final LocalDate date;
    private final int maxVolunteers;
    private final SortedListInterface<Volunteer> assignedVolunteers;
    private Donor assignedDonor;

    // Constructor
    public Event(String name, LocalDate date, int maxVolunteers) {
        this.name = name;
        this.date = date;
        this.maxVolunteers = maxVolunteers;
        this.assignedVolunteers = new DoublyLinkedList<>();
        this.assignedDonor = null; 
    }

    // Getters
    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getMaxVolunteers() {
        return maxVolunteers;
    }

    public int getNumOfAssignedVolunteers() {
        return assignedVolunteers.getNumOfEntries();
    }
    public Donor getAssignedDonor() {
        return assignedDonor;
    }

    // Setter for assigned donor
    public void setAssignedDonor(Donor donor) {
        this.assignedDonor = donor;
    }
    
    

    // Methods for managing assigned volunteers
    public boolean addVolunteer(Volunteer volunteer) {
        if (volunteer != null && !isFull()) {
            return assignedVolunteers.add(volunteer);
        }
        return false;
    }
    public boolean addDonor(Donor donor) {
        if (donor != null && !isFull()) {
            return assignedDonor.add(donor);
        }
        return false;
    }

    public boolean removeVolunteer(Volunteer volunteer) {
        return assignedVolunteers.remove(volunteer);
    }

    public SortedListInterface<Volunteer> getAssignedVolunteers() {
        return assignedVolunteers;
    }

    // Other methods (if needed)
    public boolean isFull() {
        return assignedVolunteers.getNumOfEntries() >= maxVolunteers;
    }

    @Override
    public String toString() {
        return "Event{name='" + name + "', date=" + date + ", maxVolunteers=" + maxVolunteers + "}";
    }

    public Iterable<Volunteer> getAssignedVolunteersIterable() {
        return () -> new Iterator<Volunteer>() {
            private int currentIndex = 1;
            
            @Override
            public boolean hasNext() {
                return currentIndex <= assignedVolunteers.getNumOfEntries();
            }
            
            @Override
            public Volunteer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return assignedVolunteers.getEntry(currentIndex++);
            }
        };
    }
   
    
    @Override
    public int compareTo(Event other) {
        return this.date.compareTo(other.date);
    }

}
