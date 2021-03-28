import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class HotelDriver {

	public static void main(String[] args) {
		//Integer[] rooms = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		//HashSet<Integer> set = new HashSet<Integer>(Arrays.asList(rooms)); //create Hashset out of array
		Scanner input = new Scanner(System.in);

		HotelData data = new HotelData();  //instantiate model
		int option = 0;

		// Customer Interface
		System.out.println("Welcome to the Hotel California");
		do {	
			System.out.println("Choose an option:"
					+ "\n\t1) See all rooms"
					+ "\n\t2) See booked rooms"
					+ "\n\t3) Book a room"
					+ "\n\t4) Checkout of room"
					+ "\n\t5) Exit\n");
			option = input.nextInt();

			if(option == 1) {
				System.out.println(data.seeAllRooms());
			}
			else if(option == 2){
				System.out.println(data.seeBookedRooms());
			}
			// Book a room			
			else if (option ==3) {			

				boolean avail;
				int room;
				do {
					System.out.println("What room would you like?");		
					room = input.nextInt();
					avail = (data.roomExist(room) && data.roomAvail(room));
					System.out.println("Room number " + room + " is " + ((avail) ? "Available" : "Not Available"));
				} while (!avail);

				System.out.println("Would you like to book the room(Y/N)?");
				input.nextLine();  //flush buffer from nextInt;
				String prompt = input.nextLine();
				if(prompt.equalsIgnoreCase("Y")) {
					Guest guest = new Guest();
					boolean success = data.bookRoom(room, guest);
					if(success) {
						System.out.println("Your  room is booked");
					}
					else {
						System.out.println("There was a problem booking your room");
					}
				}				
			}

			if(option == 4) {
				boolean checkOut = false;
				while(!checkOut) {
					System.out.println("What room are you checking out of?");
					int room = input.nextInt();
					if(data.checkOut(room)) {
						System.out.println("You have checked out");
						checkOut = true;
					}
					else {
						System.out.println("Problem checking out, try entering a different room number");
						checkOut = false;
					}
					input.nextLine();

				}

			}
		} while (option != 5);

		System.out.println("Thank you for visiting the Hotel California, its a lovely place!!!!!!");

	}

}
