import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

/**
 * This class will test if the Injured Player List is correctly created.
 * @author Eddie
 *
 */
public class PlayerInjuriesTest {
	
	private PlayerInjuries test ;
	
	@Before
	public void setup() {
		try {
			test = new PlayerInjuries("Chris Paul", "Heat") ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTeamInjuries() {
		HashMap<String, String> heat =  test.getTeamInjuries();
		for (String name: heat.keySet()) {
			System.out.println(name + " " + heat.get(name) );
		}	
	}
	
	@Test
	public void testAllInjuries() {
		HashMap<String, String> all =  test.getAllInjuries();
		HashMap<String, String> heat =  test.getTeamInjuries();
		int a = all.size() ;
		assertNotNull("The total injured players can't be null!", a) ;
	}
	
}
