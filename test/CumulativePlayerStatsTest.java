
import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class CumulativePlayerStatsTest {

	CumulativePlayerStats stats; // initialize object

	@Before
	public void setUp(){
		stats = new CumulativePlayerStats();
	}

	//@Test
	// public void testMakeDataMap() {
	// 	HashMap<String, String[]> playerStats = stats.getPlayersStatsMap();
	//
	// 	for(String player : playerStats.keySet()){
	// 		System.out.println(player + ": " + Arrays.toString(playerStats.get(player)));
	// 	}
	// }

	@Test // having trouble writing this test
	public void getStatsTest(){		
		//stats.getStats();
	}
	
	@Test
	public void testGetStatCategory(){
		int num = stats.getStatCategory("points");
		assertEquals("The column for points is",47, num);
	}
	
	@Test // should i rewrite in order to get an actual test
	public void testGetStatTopTen(){
		stats.getTopTen(null);
	}

}
