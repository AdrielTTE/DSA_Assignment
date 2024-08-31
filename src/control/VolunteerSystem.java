package control;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
//Author name : Jacquelin Ooi Jia Qi
//Student ID : 23WMR07647
//Programme : RSD2S1G1
*/
import entity.Event;
import entity.Volunteer;
import entity.Donor;
import adt.DoublyLinkedList;
import adt.SortedListInterface;
import boundary.VolunteerUI;
import dao.VolunteerData;
import dao.DonorInitializer;
import java.time.LocalDate;
import java.util.Scanner;


public class VolunteerSystem {
	private static SortedListInterface<Volunteer> volunteerList;
        private static SortedListInterface<Event> eventList;
        private static SortedListInterface<Donor> donorList;
        private static Scanner scanner = new Scanner(System.in);
public static void startVolunteerSystem() {
		
		volunteerList = VolunteerData.initializeVolunteers();
                eventList = VolunteerData.initializeEvents();
                donorList = DonorInitializer.initializeDonors();
                addVolunteersToEvents();
                addDonorToEvents();

		while (true) {
			VolunteerUI.volunteerNEventMenu();

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1 : {
					System.out.print("\033[H\033[2J");
					handleVolunteer(scanner);
					break;
				}
			case 2 : {
					System.out.print("\033[H\033[2J");
					handleEvent(scanner);
					break;
				}
			case 3 : {
					System.out.print("\033[H\033[2J");
					handleReportGenerate(scanner);
					break;
				}
			case 4 : {
					System.out.print("\033[H\033[2J");
					System.out.println("Exiting...");
					return;
				}
                        default : 
                                        System.out.println("Invalid choice. Please try again.");
                                        break;
			}
		}

	}
	private static void addVolunteersToEvents() {
            VolunteerData.addVolunteersToEvent(eventList.getEntry(1), new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, volunteerList);
            VolunteerData.addVolunteersToEvent(eventList.getEntry(2), new int[]{1, 3, 6, 7, 8, 14, 15, 23, 27, 34, 79, 92}, volunteerList);
            VolunteerData.addVolunteersToEvent(eventList.getEntry(3), new int[]{1, 9, 15, 24, 28, 36, 42, 43, 48, 49, 56, 60, 61, 65, 73, 76, 83, 87, 94, 95}, volunteerList);
            VolunteerData.addVolunteersToEvent(eventList.getEntry(4), new int[]{4, 7, 11, 13, 21, 25, 31, 38, 44, 47, 50, 58, 64, 67, 74, 79, 82, 85, 91, 96}, volunteerList);
            VolunteerData.addVolunteersToEvent(eventList.getEntry(5), new int[]{3, 6, 10, 15, 21, 25, 31, 32, 40, 45, 49, 53, 63, 72, 78, 85}, volunteerList);
            VolunteerData.addVolunteersToEvent(eventList.getEntry(6), new int[]{2, 4, 8, 16, 18, 22, 27, 33, 35, 37, 39, 41, 46, 51, 52, 57, 62, 66, 70, 71, 75, 77, 80, 81, 84, 88, 90, 93}, volunteerList);
        }
        
        //To check Jacquelin's DonorInitializer
        private static void addDonorToEvents() {
            DonorInitializer.addDonorToEvents(eventList.getEntry(1), new int[]{1}, donorList);
            DonorInitializer.addDonorToEvents(eventList.getEntry(2), new int[]{2}, donorList);
            DonorInitializer.addDonorToEvents(eventList.getEntry(3), new int[]{3}, donorList);
            DonorInitializer.addDonorToEvents(eventList.getEntry(4), new int[]{9}, donorList);
            DonorInitializer.addDonorToEvents(eventList.getEntry(5), new int[]{13}, donorList);
            DonorInitializer.addDonorToEvents(eventList.getEntry(6), new int[]{17}, donorList);
        }

	

	private static void handleVolunteer(Scanner scanner) {
		while (true) {
			VolunteerUI.volunteerMenu();
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1 : {
					System.out.print("\033[H\033[2J");
					addVolunteer(scanner);
					break;
				}
			case 2 : {
					System.out.print("\033[H\033[2J");
					editVolunteer(scanner);
					break;
				}
			case 3 : {
					System.out.print("\033[H\033[2J");
					removeVolunteer(scanner);
					break;
				}
			case 4 : {
					System.out.print("\033[H\033[2J");
					searchVolunteer(scanner);
					break;
				}
			case 5 : {
					System.out.print("\033[H\033[2J");
					filterVolunteer(scanner);
					break;
				}
			case 6 : {
					System.out.print("\033[H\033[2J");
					viewVolunteerList();
                                        System.out.println("Press Enter to continue...");
                                        scanner.nextLine();

					break;
				}
			case 7 : {
					System.out.print("\033[H\033[2J");
					viewAssignedEvents(scanner);
                                        
					break;
				}
			case 8 : {
					System.out.print("\033[H\033[2J");
					return; // Return to the main menu
				}
				default : {
					System.out.print("\033[H\033[2J");
					System.out.println("Invalid choice. Please try again.");
					break;
				}
			}
		}
	}
	private static void printVolunteerList() {
            // Define column widths
            final int NO_WIDTH = 4;
            final int NAME_WIDTH = 30;
            final int AGE_WIDTH = 8;
            final int GENDER_WIDTH = 10;

            // Print table header
            System.out.printf("%-" + NO_WIDTH + "s %-"+ NAME_WIDTH + "s %-"+ AGE_WIDTH + "s %-"+ GENDER_WIDTH + "s%n",
                              "No.", "Name", "Age", "Gender");

            // Print separator line
            for (int i = 0; i < NO_WIDTH + NAME_WIDTH + AGE_WIDTH + GENDER_WIDTH + 3; i++) {
                System.out.print("-");
            }
            System.out.println();

            int position = 1;
            for (int i = 1; i <= volunteerList.getNumOfEntries(); i++) {
                Volunteer volunteer = volunteerList.getEntry(i);
                if (volunteer != null) {
                    System.out.printf("%-" + NO_WIDTH + "d %-"+ NAME_WIDTH + "s %-"+ AGE_WIDTH + "d %-"+ GENDER_WIDTH + "s%n",
                                      position, volunteer.getName(), volunteer.getAge(), volunteer.getGender());
                    position++;
                }
            }
        }

	private static void addVolunteer(Scanner scanner) {
		System.out.print("Enter volunteer name: ");
		String name = scanner.nextLine();

		System.out.print("Enter volunteer age: ");
		int age;
		try {
			age = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid age. Please enter a number.");
			return;
		}

		System.out.print("Enter volunteer gender (F/M): ");
		String gender = scanner.nextLine().toUpperCase();

		if (!gender.equals("F") && !gender.equals("M")) {
			System.out.println("Invalid gender. Please enter 'F' or 'M'.");
			return;
		}

		Volunteer newVolunteer = new Volunteer(name, age, gender);
		if (volunteerList.add(newVolunteer)) {
			System.out.println("Volunteer added successfully.");
			System.out.println("Press Enter to continue...");
			scanner.nextLine();
		} else {
			System.out.println("Failed to add volunteer. A volunteer with this name may already exist.");
			System.out.println("Press Enter to continue...");
			scanner.nextLine();
		}
	}

	private static void editVolunteer(Scanner scanner) {
		viewVolunteerList();

		System.out.print("Enter the number of the volunteer you want to edit: ");
		int position = scanner.nextInt();
		scanner.nextLine();

		Volunteer volunteerToEdit = volunteerList.getEntry(position);

		if (volunteerToEdit == null) {
			System.out.println("Invalid position. Volunteer not found.");
			return;
		}

		System.out.print("Enter new name (or press Enter to keep current): ");
		String newName = scanner.nextLine();
		if (!newName.trim().isEmpty()) {
			volunteerToEdit.setName(newName);
		}

		System.out.print("Enter new age (or press Enter to keep current): ");
		String ageInput = scanner.nextLine();
		if (!ageInput.trim().isEmpty()) {
			int newAge = Integer.parseInt(ageInput);
			volunteerToEdit.setAge(newAge);
		}

		System.out.print("Enter new gender (F/M, or press Enter to keep current): ");
		String genderInput = scanner.nextLine();
		if (!genderInput.trim().isEmpty()) {
			String newGender = genderInput.toUpperCase();
			if (newGender.equals("F") || newGender.equals("M")) {
				volunteerToEdit.setGender(newGender);
			} else {
				System.out.println("Invalid gender. Please enter 'F' or 'M'.");
				return;
			}
		}

		if (volunteerList.replace(volunteerToEdit, volunteerToEdit)) {
			System.out.println("Volunteer information updated successfully.");
			System.out.println("Press Enter to continue...");
			scanner.nextLine();
		} else {
			System.out.println("Failed to update volunteer information.");
			System.out.println("Press Enter to continue...");
			scanner.nextLine();
		}
	}

	private static void removeVolunteer(Scanner scanner) {
		viewVolunteerList();

		System.out.print("Enter the number of the volunteer you want to remove: ");
		int position = scanner.nextInt();
		scanner.nextLine();
		System.out.print("\033[H\033[2J");

		Volunteer volunteerToRemove = volunteerList.getEntry(position);

		if (volunteerToRemove != null && volunteerList.remove(volunteerToRemove)) {
			System.out.println("Volunteer removed successfully.");
			System.out.println("Press Enter to continue...");
			scanner.nextLine();
		} else {
			System.out.println("Failed to remove volunteer.");
			System.out.println("Press Enter to continue...");
			scanner.nextLine();
		}
	}

	private static void searchVolunteer(Scanner scanner) {
		System.out.print("\033[H\033[2J");
		System.out.print("Enter the name (or part of the name) to search: ");
		String searchString = scanner.nextLine().toLowerCase();

		SortedListInterface<Volunteer> foundVolunteers = new DoublyLinkedList<>();

		for (int i = 1; i <= volunteerList.getNumOfEntries(); i++) {
			Volunteer volunteer = volunteerList.getEntry(i);
			if (volunteer != null && volunteer.getName().toLowerCase().contains(searchString)) {
				foundVolunteers.add(volunteer);
			}
		}

		if (!foundVolunteers.isEmpty()) {
			System.out.print("\033[H\033[2J");
			System.out.println("Search Results:");
			printFilteredVolunteerList(foundVolunteers);
			System.out.println("Press Enter to continue...");
			scanner.nextLine();

                        
		} else {
			System.out.println("No volunteers found matching the search criteria.");
			System.out.println("Press Enter to continue...");
			scanner.nextLine();
		}
	}

	private static void filterVolunteer(Scanner scanner) {
		VolunteerUI.filterVolunteerMenu();

		int choice = scanner.nextInt();
		scanner.nextLine();

		switch (choice) {
		case 1 : filterByAge(scanner);
		break;
		case 2 : filterByGender(scanner);
		break;
		case 3 : {
				return; // Go back to previous menu
			}
			default : System.out.println("Invalid choice. Please try again.");
			break;
		}
	}

	private static void filterByAge(Scanner scanner) {
		System.out.print("Enter minimum age: ");
		int minAge = scanner.nextInt();
		System.out.print("Enter maximum age: ");
		int maxAge = scanner.nextInt();
		scanner.nextLine();

		SortedListInterface<Volunteer> filteredList = new DoublyLinkedList<>();
		for (int i = 1; i <= volunteerList.getNumOfEntries(); i++) {
			Volunteer volunteer = volunteerList.getEntry(i);
			if (volunteer != null && volunteer.getAge() >= minAge && volunteer.getAge() <= maxAge) {
				filteredList.add(volunteer);
			}
		}
		System.out.print("\033[H\033[2J");
		System.out.println("Filtered Volunteer List by Age:");
		printFilteredVolunteerList(filteredList);
		System.out.println("Press Enter to continue...");
		scanner.nextLine();
	}

	private static void filterByGender(Scanner scanner) {
		System.out.print("Enter gender to filter (F/M): ");
		String gender = scanner.nextLine().toUpperCase();

		if (!gender.equals("F") && !gender.equals("M")) {
			System.out.println("Invalid gender. Please enter 'F' or 'M'.");
			return;
		}

		SortedListInterface<Volunteer> filteredList = new DoublyLinkedList<>();
		for (int i = 1; i <= volunteerList.getNumOfEntries(); i++) {
			Volunteer volunteer = volunteerList.getEntry(i);
			if (volunteer != null && volunteer.getGender().equals(gender)) {
				filteredList.add(volunteer);
			}
		}
		System.out.print("\033[H\033[2J");
		System.out.println("Filtered Volunteer List by Gender:");
		printFilteredVolunteerList(filteredList);
		System.out.println("Press Enter to continue...");
		scanner.nextLine();
	}
        

	private static void printFilteredVolunteerList(SortedListInterface<Volunteer> list) {
		// Define column widths
		final int NO_WIDTH = 4;
		final int NAME_WIDTH = 30;
		final int AGE_WIDTH = 8;
		final int GENDER_WIDTH = 10;

		// Print table header
		System.out.printf("%-" + NO_WIDTH + "s %-"+ NAME_WIDTH + "s %-"+ AGE_WIDTH + "s %-"+ GENDER_WIDTH + "s%n",
                      "No.", "Name", "Age", "Gender");
    
                // Print separator line
                for (int i = 0; i < NO_WIDTH + NAME_WIDTH + AGE_WIDTH + GENDER_WIDTH + 3; i++) {
                    System.out.print("-");
                }
                System.out.println();

		int position = 1;
		for (int i = 1; i <= list.getNumOfEntries(); i++) {
			Volunteer volunteer = list.getEntry(i);
			if (volunteer != null) {
				System.out.printf("%-" + NO_WIDTH + "d %-"+ NAME_WIDTH + "s %-"+ AGE_WIDTH + "d %-"+ GENDER_WIDTH + "s%n",
				                  position, volunteer.getName(), volunteer.getAge(), volunteer.getGender());
				position++;
			}
		}
	}


	private static void viewVolunteerList() {
		System.out.println("Volunteer List:");
		printVolunteerList();

	}



	private static void viewAssignedEvents(Scanner scanner) {
            System.out.println("View Assigned Events selected.");
            printVolunteerList();

            System.out.print("Enter the number of the volunteer: ");
            int position = scanner.nextInt();
            scanner.nextLine();

            Volunteer volunteer = volunteerList.getEntry(position);

            if (volunteer == null) {
                System.out.println("Invalid position. Volunteer not found.");
                System.out.println("Press Enter to continue...");
                scanner.nextLine();
                return;
            }

            
            System.out.println("Assigned Events for " + volunteer.getName() + ":");

            // Define column widths
            final int NO_WIDTH = 4;
            final int NAME_WIDTH = 30;
            final int DATE_WIDTH = 12;

            // Print table header
            System.out.printf("%-" + NO_WIDTH + "s %-"+ NAME_WIDTH + "s %-"+ DATE_WIDTH + "s%n",
                              "No.", "Event Name", "Date");
            for (int i = 0; i < NO_WIDTH + NAME_WIDTH + DATE_WIDTH + 3; i++) {
                    System.out.print("-");
                }
                System.out.println();

            int eventNumber = 1;
            for (int i = 1; i <= eventList.getNumOfEntries(); i++) {
                Event event = eventList.getEntry(i);
                if (event.getAssignedVolunteers().filter(volunteer)) {
                    System.out.printf("%-" + NO_WIDTH + "d %-"+ NAME_WIDTH + "s %-"+ DATE_WIDTH + "s%n",
                                      eventNumber, event.getName(), event.getDate());
                    eventNumber++;
                }
            }
            System.out.println("Press Enter to continue...");
            scanner.nextLine();
        }
        

	private static void handleEvent(Scanner scanner) {
		while (true) {
			VolunteerUI.eventMenu();

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1 : {
					System.out.print("\033[H\033[2J");
					printEventList();
					System.out.println("Press Enter to continue...");
					scanner.nextLine();
					break;
				}
			case 2 : {
					System.out.print("\033[H\033[2J");
					handleEventAssignment(scanner);
					break;
				}
			case 3 : {
					System.out.print("\033[H\033[2J");
					removeAssignedVolunteer(scanner);
					break;
				}
			case 4 : viewinAssignedVolunteer(scanner);
			break;
			case 5 : {
					return; // Return to the main menu
				}
				default : System.out.println("Invalid choice. Please try again.");
				break;
			}
		}
	}
	 private static void printEventList() {
            // Define column widths
            final int NO_WIDTH = 4;
            final int NAME_WIDTH = 30;
            final int DATE_WIDTH = 12;
            final int MAX_VOL_WIDTH = 10;

            // Print table header
            System.out.printf("%-" + NO_WIDTH + "s %-"+ NAME_WIDTH + "s %-"+ DATE_WIDTH + "s %-"+ MAX_VOL_WIDTH + "s%n",
                              "No.", "Event Name", "Date", "Max Volunteer");
            for (int i = 0; i < NO_WIDTH + NAME_WIDTH + DATE_WIDTH + MAX_VOL_WIDTH + 3; i++) {
                System.out.print("-");
            }
            System.out.println();

            for (int i = 1; i <= eventList.getNumOfEntries(); i++) {
                Event event = eventList.getEntry(i);
                System.out.printf("%-" + NO_WIDTH + "d %-"+ NAME_WIDTH + "s %-"+ DATE_WIDTH + "s %-"+ MAX_VOL_WIDTH + "d%n",
                                  i, event.getName(), event.getDate(), event.getMaxVolunteers());
            }
        }
	private static void handleEventAssignment(Scanner scanner) {
		printEventList();
		System.out.print("Choose an event number to assign volunteers to (0 to cancel): ");
		int eventChoice = scanner.nextInt();
		scanner.nextLine();

		if (eventChoice == 0) {
			return;
		}

		if (eventChoice < 1 || eventChoice > eventList.getNumOfEntries()) {
			System.out.println("Invalid event number.");
			return;
		}

		Event selectedEvent = eventList.getEntry(eventChoice);

		while (true) {
			printVolunteerList();
			System.out.print("Enter volunteer number to assign (0 to finish): ");
			int volunteerChoice = scanner.nextInt();
			scanner.nextLine();

			if (volunteerChoice == 0) {
				return;
			}

			if (volunteerChoice < 1 || volunteerChoice > volunteerList.getNumOfEntries()) {
				System.out.println("Invalid volunteer number.");
				continue;
			}

			Volunteer selectedVolunteer = volunteerList.getEntry(volunteerChoice);

			if (selectedVolunteer == null) {
				System.out.println("Invalid volunteer number.");
				continue;
			}

			if (selectedEvent.isFull()) {
				System.out.println("Event is already full. Stop to assign!!!");
				break;
			}

			if (selectedEvent.getAssignedVolunteers().filter(selectedVolunteer)) {
				System.out.println("The Volunteer already been assigned. Please assign another Volunteer.");
				System.out.println("Press Enter to continue...");
				scanner.nextLine();
				continue;
			}

			if (selectedEvent.addVolunteer(selectedVolunteer)) {
				System.out.println("Volunteer assigned to event.");
				System.out.println("Press Enter to continue...");
				scanner.nextLine();
			} else {
				System.out.println("Failed to assign volunteer to event. The volunteer might already be assigned or the event might be full.");
				System.out.println("Press Enter to continue...");
				scanner.nextLine();
			}
		}
	}
	private static void printAssignedVolunteers(Event event) {
		System.out.println("Assigned Volunteers:");
		System.out.printf("%-4s %-30s %-4s %-6s%n", "No.", "Name", "Age", "Gender");
		System.out.println("-------------------------------------------------------------");
		int i = 1;
		for (Volunteer volunteer : event.getAssignedVolunteersIterable()) {
			System.out.printf("%-4d %s%n", i++, volunteer.toString());
		}
	}
	private static void removeAssignedVolunteer(Scanner scanner) {
		printEventList();
		System.out.print("Choose an event number to remove volunteers from (0 to cancel): ");
		int eventChoice = scanner.nextInt();
		scanner.nextLine();

		if (eventChoice == 0) {
			return;
		}

		if (eventChoice < 1 || eventChoice > eventList.getNumOfEntries()) {
			System.out.println("Invalid event number.");
			return;
		}

		Event selectedEvent = eventList.getEntry(eventChoice);


		if (selectedEvent.getNumOfAssignedVolunteers() == 0) { // Use getNumOfAssignedVolunteers
			System.out.println("Event has no assigned volunteers.");
			return;
		}

		printAssignedVolunteers(selectedEvent);
		System.out.print("Enter volunteer number to remove (0 to cancel): ");
		int volunteerChoice = scanner.nextInt();
		scanner.nextLine();

		if (volunteerChoice == 0) {
			return;
		}

		if (volunteerChoice < 1 || volunteerChoice > selectedEvent.getNumOfAssignedVolunteers()) {
			System.out.println("Invalid volunteer number.");
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
			return;
		}

		Volunteer volunteerToRemove = selectedEvent.getAssignedVolunteers().getEntry(volunteerChoice);
		if (volunteerToRemove != null && selectedEvent.removeVolunteer(volunteerToRemove)) {
			System.out.print("\033[H\033[2J");
			System.out.println("Volunteer removed from event successfully.");
			System.out.println("Press Enter to continue...");
			scanner.nextLine();
		} else {
			System.out.print("\033[H\033[2J");
			System.out.println("Failed to remove volunteer from event.");
			System.out.println("Press Enter to continue...");
			scanner.nextLine();
		}
	}
	private static void viewinAssignedVolunteer(Scanner scanner) {
		printEventList();
		System.out.print("Choose an event number to view volunteers from (0 to cancel): ");
		int eventChoice = scanner.nextInt();
		scanner.nextLine();

		if (eventChoice == 0) {
			return;
		}

		if (eventChoice < 1 || eventChoice > eventList.getNumOfEntries()) {
			System.out.println("Invalid event number.");
                        System.out.println("Press Enter to continue...");
                        scanner.nextLine();
			return;
		}

		Event selectedEvent = eventList.getEntry(eventChoice);

		if (selectedEvent.getNumOfAssignedVolunteers() == 0) { // Use getNumOfAssignedVolunteers
			System.out.println("Event has no assigned volunteers.");
			System.out.println("Press Enter to continue...");
			scanner.nextLine();
			return;
		}

		printAssignedVolunteers(selectedEvent);
		System.out.println("Press Enter to continue...");
		scanner.nextLine();
	}
	
	private static void handleReportGenerate(Scanner scanner) {
            System.out.print("\033[H\033[2J");
            System.out.println(); // Add a blank line between events
            System.out.println("**************************************************************************");
            System.out.println();
            System.out.println("Report Generate"     );
            System.out.println("Date : " + LocalDate.now());
            System.out.println();

            for (int i = 1; i <= eventList.getNumOfEntries(); i++) {
                Event event = eventList.getEntry(i);
                System.out.println("Event: " + event.getName() + "              Date: " + event.getDate());

                // Get the assigned donor and print their name
                Donor assignedDonor = event.getAssignedDonor();
                if (assignedDonor != null) {
                    System.out.println("Event Sponsored by: " + assignedDonor.getDonorName());
                } else {
                    System.out.println("Event Sponsor: Not assigned");
                }
                System.out.println("\nVolunteer List:");

                SortedListInterface<Volunteer> assignedVolunteers = event.getAssignedVolunteers();
                if (assignedVolunteers.isEmpty()) {
                    System.out.println("No volunteers assigned.");
                } else {
                    printFilteredVolunteerList(assignedVolunteers);
                }

                System.out.println(); // Add a blank line between events
                System.out.println("**************************************************************************");
                System.out.println();
            }
            System.out.println("Press Enter to continue...");
            scanner.nextLine();
            System.out.print("\033[H\033[2J");
        }
        
}
