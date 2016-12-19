
import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class TeamStandingsTest {

	TeamStandings stats; // initialize object

	@Before
	public void setUp() throws MalformedURLException, IOException{
		stats = new TeamStandings();
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
		String[] temp = stats.getTeamRankings();
	    for(int i=0; i<temp.length; i++){
	        System.out.println(temp[i]);
	    }
	}
}
