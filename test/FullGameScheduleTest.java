package hw6_project;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class FullGameScheduleTest {

	FullGameSchedule testSchedule; 
	
	@Before 
	public void setup(){
		testSchedule = new FullGameSchedule(); 
	}
	
//	@Test
	public void testGetTeamGames() {
		String team = "Bulls"; // input team name  
		ArrayList<String[]> teamSchedule = testSchedule.getSeasonGames(team); // grab schedule of all the team games 
		
		// print out all games for the season 
		for(String[] games : teamSchedule){
			System.out.println(games[6] + " @ " + games[10] + ": " + Arrays.toString(games));
		}
		
		assertNotNull("List of games cannot be empty", teamSchedule);
		
		
		
	}
	
	@Test
	public void testGetGamesOnDay() {
		String date = "2015-11-11"; // input date of the game  
		ArrayList<String[]> games = testSchedule.getGamesOnDay(date); // grab schedule of all the team games 
		
		// print out all games for the season 
		for(String[] game : games){
			System.out.println(game[6] + " @ " + game[10] + ": " + Arrays.toString(game));
		}
		
		assertNotNull("List of games cannot be empty", games);
		
		
		
	}

}
