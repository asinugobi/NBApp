import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * This class is responsible for tracking and returning information regarding a player's daily stats.
 * @author obinnaasinugo
 *
 */
public class DailyPlayerStats {
	private FileDownloader dl; // used to download file 
	private FileReaderv3 dailyPlayerStats; // parsed file of daily player stats 
	private HashMap<String, String[]> playersStatsMap; // map of players to their respective stats
	private String date; // used to store today's date 

	/**
	 * This is the constructor for creating an DailyPlayerStats object. It will initialize the appropriate objects
	 * and instance variables. 
	 * @param player
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public DailyPlayerStats() throws MalformedURLException, IOException{
		dl = new FileDownloader("resources/");
		date = getDate(); // get today's date 
		dl.dailyPlayer(date); // store today's date 
		dailyPlayerStats = new FileReaderv3("resources/daily_player_stats.csv");
		playersStatsMap = new HashMap<String, String[]>(); // initialize stats map 
		makePlayersDataMap(); 
	}
	
	/**
	 * Method will return today's date
	 * @return current date 
	 */
	public String getDate(){
		// store today's date 
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date dateobj = new Date();
		return df.format(dateobj); 
	}
	
	/**
	 * This method is responsible for returning the file containing players' stats for a given day 
	 * @return file containing players' stats 
	 */
	public FileReaderv3 getData(){
		return dailyPlayerStats; 
	}
	
	/**
	 * This method is responsible for making a map of players (key) to their respective stats (value)
	 */
	public void makePlayersDataMap(){
		String[] playerData; // stores player's data 
		String playerName; // stores player's name 
		
		// cycle through each data and store the player's name as key and stats as the value
		for(String playerInfo : dailyPlayerStats.getLines()){
			playerData = playerInfo.split(","); // split the string into array 
			playerName = playerData[5] + " " + playerData[4]; // store player's name (first last)
			
			// if player is not in the map, store their data 
			if(!playersStatsMap.containsKey(playerName)){
				playersStatsMap.put(playerName, playerData); 
			}
			else
				continue; 
		}
	}
	
	/**
	 * This method is responsible for returning the map of players to their stats. 
	 * @return map of players to their respective stats 
	 */
	public HashMap<String, String[]> getPlayersStatsMap(){
		return playersStatsMap; 
	}
	
	/**
	 * This method is responsible for returning a specific player's stats. 
	 * @param playerOfInterest
	 * @return a specific player's stats 
	 */
	public String[] getPlayerStats(String playerOfInterest){
		String[] playerStats = new String[5]; // store key stats: points (0), assists (1), rebounds (2), steals (3) and blocks (4)
		String[] tempStats = null; 
		
		if(playersStatsMap.containsKey(playerOfInterest)){
			tempStats = playersStatsMap.get(playerOfInterest);
			playerStats[0] = tempStats[39]; // store points 
			playerStats[1] = tempStats[37]; // store assists 
			playerStats[2] = tempStats[35]; // store rebounds 
			playerStats[3] = tempStats[43]; // store steals 
			playerStats[4] = tempStats[45]; // store blocks
			return playerStats; 
		}
		return null; 
	}
}
