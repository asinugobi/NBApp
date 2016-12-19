import static org.junit.Assert.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;

/**
 * This class is responsible for testing the DailyPlayerStats class. 
 * @author obinnaasinugo
 */
public class DailyPlayerStatsTest {

	DailyPlayerStats stats; // initialize object 
	/**
	 * Initialize DailPlayerStats object
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	@Before 
	public void setUp() throws MalformedURLException, IOException{
		stats = new DailyPlayerStats(); 
	}
	
	/**
	 * Test to see if data map is not null
	 */
	@Test
	public void testMakeDataMap() {
		HashMap<String, String[]> playerStats = stats.getPlayersStatsMap();	
		assertNotNull("Stats map should not be empty or null.", playerStats);
	}
	
	/**
	 * Test the getPlayerStats() to see if the return value if valid and contains 
	 * a respective player's stats if they played today. 
	 */
	@Test
	public void testGetPlayerStats(){
		String player = "Chris Paul";
		String[] playerStats = stats.getPlayerStats(player); 
	 	
		// if player played today, stats should not be empty
		// otherwise, stats should be empty 
		if(!playerStats.equals(null))
			assertNotNull("Array of player's stats should not be empty.", playerStats);
		else 
			assertNull("Array of player's stats should be empty or null if they did not play that day...", playerStats);
	}
	
	/**
	 * Test to see if the date constructed in the class is today's date
	 */
	@Test 
	public void testDate(){
		// store today's date 
		String testDate; 
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date dateobj = new Date();
		testDate = df.format(dateobj); 
	
		String date = stats.getDate();// date returned from function
		assertEquals(testDate, date); // check to see if returned date is today's date 
	}
}
