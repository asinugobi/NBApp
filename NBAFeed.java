package hw6_project;

import java.util.Arrays;
import java.util.Scanner;

/**
 * This class is responsible for interacting with the user and returning relevant 
 * sports data to the user. 
 * @author obinnaasinugo
 *
 */
public class NBAFeed {

	private Scanner input; // user input
	private DailyPlayerStats playerStats; 
	
	/**
	 * This constructor initializes the Scanner object
	 */
	public NBAFeed(){
		input = new Scanner(System.in); 
		playerStats = new DailyPlayerStats(); 
	}
	
//	public void welcomeUser(){
//		System.out.println("Welcome to ");
//	}
	
	public void askUserForFeed(){
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

		jumpToFeed(category);
	}
	
	
	public void jumpToFeed(int category){
		switch(category){
			case 1: break; 
			case 2: break; 
			case 3: askDailyPlayerStats(); 
					break; 
		}
	}
	
	/**
	 * This method is responsible for asking the user what they would like to observe 
	 * from the daily player stats. Based on the user's interest, the method will appropriately 
	 * handle the response. 
	 */
	public void askDailyPlayerStats(){
		
		String response; // user response to first question 
		
		// ask user if they would like to analyze their favorite player
		while(true){
			System.out.println("Would you like to see your favorite player's stats? Press: 'y' for yes "
					+ "or 'n' for no ");
			response = input.nextLine(); 
			
			if(response.equalsIgnoreCase("y")){
				//grab player stats
				String favoritePlayer = "Dwyane Wade";
				printPlayerStats(favoritePlayer);
				break; 
			}	
			else if(response.equalsIgnoreCase("n")){
				// jump to second question 
				break;
			}
			else
				// user should enter a valid input
				System.out.println("Please enter a valid input\n");
		}
		
		String playerName = null; // player of interest 
		
		// second question: find which player the user would like to analyze 
		if(response.equalsIgnoreCase("n")){
			
			
			// ask user for which player they would like to analyze 
			while(true){
				System.out.println("Which player would you like to analyze? Please enter name:"
						+ " (first) (last)");
				
				playerName = input.nextLine(); // store name 
				
				boolean didPlayerPlay = playerStats.getPlayersStatsMap().containsKey(playerName); 
				
				// check to see if player played on that particular day  
				if(didPlayerPlay)
					break; 
				else 
					System.out.println("The player you entered did not play that day "
							+ "or does not play in the NBA.\n");
					
				
				
			}
			
			// print player's stats 
			printPlayerStats(playerName);
		}
		
		
		
		
	}
	
	/**
	 * This method is responsible for printing out a player's daily stats
	 * @param player
	 */
	public void printPlayerStats(String player){ 
		// store stats of the player 
		String[] stats = playerStats.getPlayersStatsMap().get(player); 
		
		//print out stats 
		System.out.println(player + ": " + Arrays.toString(stats));
	}
	
	
	
	
}
