import java.io.IOException;
import java.net.MalformedURLException;

/**
 * This class will present the performance of franchise players for a specified team.
 * @author Eddie
 *
 */

public class TeamStats {
	private FileDownloader dl;
	private FileReaderv3 cumu;
/**
 * Constructor will read in cumulative_player_stats.csv. 
 * @throws IOException 
 * @throws MalformedURLException 
 */
	public TeamStats () throws MalformedURLException, IOException {
		dl = new FileDownloader("/Users/Eddie/Documents/cit-591-projects-fall-2016-sports_feeds/resources/");
		dl.cumulativePlayers();
	}
}
