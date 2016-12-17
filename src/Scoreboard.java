
/**
 * This class is responsible for tracking  the score of particular
 * game being played.
 * @author chimezie
 *
 */

import java.util.*;

public class Scoreboard {
	private FileReaderv3 scoreBoardFile; // parsed file
	private String team; // team of interest
	private HashMap<String, String[]> scoreBoardMap; // map of players to their respective stats


	public Scoreboard(String team){
		this.team = team;
		scoreBoardFile = new FileReaderv3("resources/MYSPORTSFEEDS-SCOREBOARD-NBA-20152016REGULAR-20151028.csv");
		scoreBoardMap = new HashMap<String, String[]>(); // initialize stats map
		makeScoreBoardMap();
	}

 /**
	* This method is responsible for returning the file containing players'
	* cumulative statistics
	* @return file containing players' stats
	*/
 public FileReaderv3 getData(){
	 return scoreBoardFile;
 }

 /**
	* This method is responsible for making a map of players (key)
	* to their respective stats (value)
	*/
 public void makeScoreBoardMap(){
	 String[] gameData; // stores player's data
	 String game; // stores player's name

	 // cycle through each data and store the player's name as key and stats as the value
	 for(String score : scoreBoardFile.getLines()){
		 gameData = score.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // split the string into array
		 game = gameData[11] + " @ " + gameData[15]; // store player's name (first last)

		 // if player is not in the map, store their data
		 if(!scoreBoardMap.containsKey(game)){
			 scoreBoardMap.put(game, gameData);
		 }
		 else
			 continue;

	 }
 }


 /**
	* This method is responsible for returning the map of players to their stats.
	* @return map of players to their respective stats
	*/
 public HashMap<String, String[]> getGameMap(){
	 return scoreBoardMap;
 }
 
 public String[] getGameInfo(String team){
	 String temp = team.toUpperCase();;
	 for(String s : scoreBoardMap.keySet()){
		 if(s.contains(temp)){
			 team = s;
			 break;
		 }
	 }
	 String[] game = scoreBoardMap.get(team);
	 return game;
 }
 
 /**
  * 
  * @return score for the home team
  */
 public int getHomeTeamScore(){
	 String team = "WAS";
	 team = team.toUpperCase();
	 String[] game = getGameInfo(team);
	 int score = Integer.parseInt(game[14]);
	 
	 return score;
 }
 
 
 /**
  * 
  * @return score for the away team
  */
 public int getAwayTeamScore(){
	 String team = "ORL";
	 team = team.toUpperCase();
	 String[] game = getGameInfo(team);
	 int score = Integer.parseInt(game[10]);
	 
	 return score;
 }
 
 /**
  * 
  * @return score for the away team
  */
 public String getMatchUP(){
	 String team = "ORL";
	 team = team.toUpperCase();
	 String[] game = getGameInfo(team);
	 String matchup = game[12] + " " + game[13] + " v " + game[16] + " " + game[17];
	 
	 return matchup;
 }


}
