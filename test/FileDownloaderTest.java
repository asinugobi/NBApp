import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

import org.junit.Before;
import org.junit.Test;

/**
 * This class will test if FileDownloader successfully download the specified file to target directory. 
 * @author Eddie
 *
 */
public class FileDownloaderTest {
	private FileDownloader fd ;
	
	@Before
	public void setup() {
		fd = new FileDownloader("resources/");
	}
	
	@Test
	public void testCumulativePlayers() {
		try {
			fd.cumulativePlayers();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String fileName = fd.getStatsName() ;
		String source = fd.getTargetDirectory() ;
		File testFile = new File (source + fileName + ".csv") ;
		assertNotNull("testFile should get cumuplative players instead of null", testFile) ;
	}
	
	@Test
	public void testFullSchedule() {
		try {
			fd.fullSchedule();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String fileName = fd.getStatsName() ;
		String source = fd.getTargetDirectory() ;
		File testFile = new File (source + fileName + ".csv") ;
		assertNotNull("testFile should get full schedule insteadof null", testFile) ;
	}
	
	@Test
	public void testDailyPlayer() {
		try {
			fd.dailyPlayer("20161028");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String fileName = fd.getStatsName() ;
		String source = fd.getTargetDirectory() ;
		File testFile = new File (source + fileName + ".csv") ;
		assertNotNull("testFile should get daily player insteadof null", testFile) ;
	}
	
	@Test
	public void testAllStandings() {
		try {
			fd.allStandings();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String fileName = fd.getStatsName() ;
		String source = fd.getTargetDirectory() ;
		File testFile = new File (source + fileName + ".csv") ;
		assertNotNull("testFile should get all standings insteadof null", testFile) ;
	}
	
	@Test
	public void testPlayerInjuries() {
		try {
			fd.playerInjuries();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String fileName = fd.getStatsName() ;
		String source = fd.getTargetDirectory() ;
		File testFile = new File (source + fileName + ".csv") ;
		assertNotNull("testFile should get player injuries insteadof null", testFile) ;
	}
	
	@Test
	public void testDownload() {
		Path test;
		try {
			test = FileDownloader.download("https://www.mysportsfeeds.com/api/feed/pull/nba/2016-2017-regular/cumulative_player_stats.csv?", "resources/", "test123.txt");
			assertNotNull("There should be a path for the downloading file", test.toString()) ;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
