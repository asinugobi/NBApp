
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class DailyPlayerStatsTest {

	DailyPlayerStats stats; // initialize object 
	
	@Before 
	public void setUp(){
		stats = new DailyPlayerStats(); 
	}
	
	@Test
	public void testMakeDataMap() {
		HashMap<String, String[]> playerStats = stats.getPlayersStatsMap();
		
//		for(String player : playerStats.keySet()){
//			System.out.println(player + ": " + Arrays.toString(playerStats.get(player)));
//		}
		
		assertNotNull("Stats map should not be empty or null.", playerStats);
		
		
	}
	
	/**
	 * Test the getPlayerStats() to see if the return value if valid and contains 
	 * a respective player's stats. 
	 */
	@Test
	public void testGetPlayerStats(){
		String player = "Anthony Davis";
		String[] playerStats = stats.getPlayerStats(player); 
		
		System.out.println(Arrays.toString(playerStats)); 
		
		assertNotNull("Array of player's stats should not be empty.", playerStats);
		
	}

}
