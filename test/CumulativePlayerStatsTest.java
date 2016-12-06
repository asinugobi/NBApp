
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

	@Test
	public void getStatsTest(){
		//SortedSet<Double> pointsSorted = stats.getStats();
		// Iterator it = pointsSorted.iterator();
		// while(it.hasNext()){
		// 	System.out.println(element.getIvar1());
		// }
<<<<<<< HEAD
		// stats.getStats();
=======
		//stats.getStats();
>>>>>>> ff4d2b87c8f18ff4c9c777be4cf475d15d10a686
	}
	
	@Test
	public void testGetStatCategory(){
		int num = stats.getStatCategory("points");
		assertEquals("The column for points is",47, num);
	}

}
