
import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class NBAFeedTest {

	private NBAFeed feed; 
	private DailyPlayerStats playerStats; 
	
	@Before 
	public void createObject() throws MalformedURLException, IOException{
		feed = new NBAFeed();
		playerStats = new DailyPlayerStats(); 
	}
	
	@Test
	public void testAskUserForFeed() {
		int category; 
		feed.askUserForFeed(); 
//		assertEquals("The category should range from 1-12", 3, category);
	}
	
//	@Test 
	public void testPlayerStatsMap(){
		HashMap<String, String[]> playerStatsMap = playerStats.getPlayersStatsMap(); // initialize map 
		String player = "Dwyane Wade"; // store player of interest 
		
		assertEquals("Should contain " + player, true, playerStatsMap.containsKey(player));  
		
	}

}
