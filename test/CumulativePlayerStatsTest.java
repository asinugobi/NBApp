
import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class CumulativePlayerStatsTest {

	CumulativePlayerStats stats; // initialize object

	@Before
	public void setUp() throws MalformedURLException, IOException{
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
		stats.getStats("points");
	}
	
	@Test
	public void testGetStatCategory(){
		int num = stats.getStatCategory("points");
		assertEquals("The column for points is",47, num);
	}
	
	@Test // should i rewrite in order to get an actual test
	public void testGetStatTopTen(){

		stats.getTopTen("points");

	}

//	@Test // should i rewrite in order to get an actual test
//	public void testGetStatTopTen(){
//		stats.getTopTen("points");
//		stats.getTopTen(null);
//	}
}
