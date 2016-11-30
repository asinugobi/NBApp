package hw6_project;

import java.util.HashMap;

/**
 * This class is responsible for tracking and returning information regarding a player's daily stats 
 * @author obinnaasinugo
 *
 */
public class DailyPlayerStats {

	FileReaderv3 dailyPlayerStats; // parsed file of daily player stats 
	HashMap<String, String[]> playersStatsMap; // map of players to their respective stats
	
	
	/**
	 * This is the constructor for creating an DailyPlayerStats object. It will initialize the
	 * FileReaderv3 and String objects. 
	 * @param player
	 */
	public DailyPlayerStats(){
		dailyPlayerStats = new FileReaderv3("MYSPORTSFEEDS-CUMULATIVE_PLAYER_STATS-NBA-20152016REGULAR-1.csv");
		playersStatsMap = new HashMap<String, String[]>(); // initialize stats map 
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
	
	
	
//	/**
//	 * This method is responsible for returning an array containing the player's data 
//	 * @param playerOfInterest, player of user's interest
//	 * @return array of player's data 
//	 */
//	public String[] getPlayerStats(String playerOfInterest){
//		String[] playerData; // stores player's data 
//		String playerName; // stores player's name 
//		
//		// find the player by cycling through each string of data 
//		for(String playerInfo : dailyPlayerStats.getLines()){
//			playerData = playerInfo.split(",");
//			playerName = playerData[5] + " " + playerData[4];
//			
//			if(playerOfInterest.equalsIgnoreCase(playerName))
//				return playerData; 
//		}
//		
//		return null; 
//	}
	
	
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
		
		if(playersStatsMap.containsKey(playerOfInterest))
			return playersStatsMap.get(playerOfInterest);
		
		return null; 
	}
	

}
