
import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class DailyPlayerStatsTest2 {

	DailyPlayerStats stats; // initialize object 
	
	@Before 
	public void setUp() throws MalformedURLException, IOException{
		stats = new DailyPlayerStats(); 
	}
	
	@Test
	public void testMakeDataMap() {
		HashMap<String, String[]> playerStats = stats.getPlayersStatsMap();
		
		for(String player : playerStats.keySet()){
			System.out.println(player + ": " + Arrays.toString(playerStats.get(player)));
		}
		
		
	}

}
