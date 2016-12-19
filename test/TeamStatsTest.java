import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * This class will test if it get the right list of top5 players
 * @author Eddie
 *
 */
public class TeamStatsTest {
	
	private TeamStats ts ;
	
	@Before
	public void setup() {
		try {
			ts = new TeamStats("Knicks") ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test 
	public void testTop5Score() {
		ArrayList<String> top5 = ts.getTop5Score() ;
		assertNotNull("The top5 stats of a team can't be null", top5) ; 
		assertEquals("The amount of top5 stats should be 5", top5.size(), 5) ;
	}
	
	@Test 
	public void testTop5Scorer() {
		ArrayList<String> top5 = ts.getTop5Scorer();
		assertNotNull("The top5 scorers of a team can't be null", top5) ; 
		assertEquals("The amount of top5 stats should be 5", top5.size(), 5) ;
	}
	
	@Test 
	public void testTop5Rebound() {
		ArrayList<String> top5 = ts.getTop5Rebound() ;
		assertNotNull("The top5 stats of a team can't be null", top5) ; 
		assertEquals("The amount of top5 stats should be 5", top5.size(), 5) ;
	}
	
	@Test 
	public void testTop5Rebounder() {
		ArrayList<String> top5 = ts.getTop5Rebounder();
		assertNotNull("The top5 rebounders of a team can't be null", top5) ; 
		assertEquals("The amount of top5 stats should be 5", top5.size(), 5) ;
	}
	
	@Test 
	public void testTop5Assist() {
		ArrayList<String> top5 = ts.getTop5Assist() ;
		assertNotNull("The top5 stats of a team can't be null", top5) ; 
		assertEquals("The amount of top5 stats should be 5", top5.size(), 5) ;
	}
	
	@Test 
	public void testTop5Assistant() {
		ArrayList<String> top5 = ts.getTop5Assistant();
		assertNotNull("The top5 assistants of a team can't be null", top5) ;
		assertEquals("The amount of top5 stats should be 5", top5.size(), 5) ;
	}
	
	@Test 
	public void testTop5Block() {
		ArrayList<String> top5 = ts.getTop5Block() ;
		assertNotNull("The top5 stats of a team can't be null", top5) ; 
		assertEquals("The amount of top5 stats should be 5", top5.size(), 5) ;
	}
	
	@Test 
	public void testTop5Blocker() {
		ArrayList<String> top5 = ts.getTop5Blocker();
		assertNotNull("The top5 blockers of a team can't be null", top5) ; 
		assertEquals("The amount of top5 stats should be 5", top5.size(), 5) ;
	}
	
	@Test 
	public void testTop5Steal() {
		ArrayList<String> top5 = ts.getTop5Steal() ;
		assertNotNull("The top5 stats of a team can't be null", top5) ; 
		assertEquals("The amount of top5 stats should be 5", top5.size(), 5) ;
	}
	
	@Test 
	public void testTop5Stealer() {
		ArrayList<String> top5 = ts.getTop5Stealer();
		assertNotNull("The top5 stealers of a team can't be null", top5) ; 
		assertEquals("The amount of top5 stats should be 5", top5.size(), 5) ;
	}
}
