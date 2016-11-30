package hw6_project;

import java.util.Scanner;

/**
 * This class is responsible for interacting with the user and returning relevant 
 * sports data to the user. 
 * @author obinnaasinugo
 *
 */
public class NBAFeed {

	private Scanner input; // user input 
	
	/**
	 * This constructor initializes the Scanner object
	 */
	public NBAFeed(){
		input = new Scanner(System.in); 
	}
	
//	public void welcomeUser(){
//		System.out.println("Welcome to ");
//	}
	
	public int askUserForFeed(){
		// ask user for category of interest 
		System.out.println("Please enter your category of interest (type the respective number): ");
		System.out.println("1. Cumulative Player Stats\n"
				+ "2. Full Game Schedule\n"
				+ "3. Daily Player Stats\n"
				+ "4. Scoreboard\n"
				+ "5. Game BoxScore\n"
				+ "6. Roster Players\n"
				+ "7. Active Players\n"
				+ "8. Overall Team Standings"
				+ "9. Conference Team Standings \n"
				+ "10. Division Team Standings \n"
				+ "11. Playoff Team Standings \n"
				+ "12. Player Injuries ");
		
		int category = 0; // category of interest 
		
		// check to see if entry is a number 
			while(!input.hasNextInt()){
				System.out.println("Your entry was invalid. Please enter an appropriate number.");
				input.nextLine(); 
			}

			category = input.nextInt(); // store the appropriate integer 
			input.nextLine(); // clear the line 

			// check to see if the category number is within the range
			while((category < 1 || category > 12)){ 
				System.out.println("Please enter an appropriate number between 1-12:");
				
				// check to see if entry is a number
				while(!input.hasNextInt()){
					System.out.println("Your entry was invalid. Please enter an appropriate number.");
					input.nextLine(); 
				}
				category = input.nextInt(); // store the appropriate integer 
				input.nextLine(); // clear the line 
			}

		return category;
		
	}
	
	
	
	
}
