/**
 * This class is responsible for tracking and returning information
 * regarding a player's cumulative stats
 * @author chimezie
 *
 */

 // import statements
 import java.util.*;

 public class CumulativePlayerStats{
   // instance variables
   FileReaderv3 cumulativePlayerStats; // parsed file of daily player stats
 	 HashMap<String, String[]> playersStatsMap; // map of players to their respective stats


   	/**
   	 * This is the constructor for creating an CumulativePlayerStats object.
     * It will initialize the FileReaderv3 and String objects.
   	 */
   	public CumulativePlayerStats(){
   		cumulativePlayerStats = new FileReaderv3("resources/MYSPORTSFEEDS-CUMULATIVE_PLAYER_STATS-NBA-20152016REGULAR.csv");
   		playersStatsMap = new HashMap<String, String[]>(); // initialize stats map
   		makePlayersDataMap();
   	}

 	/**
 	 * This method is responsible for returning the file containing players'
   * cumulative statistics
 	 * @return file containing players' stats
 	 */
 	public FileReaderv3 getData(){
 		return cumulativePlayerStats;
 	}

 	/**
 	 * This method is responsible for making a map of players (key)
   * to their respective stats (value)
 	 */
 	public void makePlayersDataMap(){
 		String[] playerData; // stores player's data
 		String playerName; // stores player's name

 		// cycle through each data and store the player's name as key and stats as the value
 		for(String playerInfo : cumulativePlayerStats.getLines()){
 			playerData = playerInfo.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // split the string into array
 			playerName = playerData[3] + " " + playerData[2]; // store player's name (first last)

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

 		if(playersStatsMap.containsKey(playerOfInterest))
 			return playersStatsMap.get(playerOfInterest);

 		return null;
 	}


  /**
  * This method gets the top 10 scorers in the league
  * generalize this function for any statistical category
  */
  public Map<String, Double> getStats(){
    Map<String, Double> points = new TreeMap<String, Double>();
    String playerName; // player's name
    Double ppg; //  player's points per game
    int category = getStatCategory("points"); // use this to generalize the function to get any column
    String[] temp;

    // prompt user to enter category of interest


    // cycle through each data and store the player's name as key and stats as the value
    for(String player : playersStatsMap.keySet()){
      playerName = player; // get the
      temp = playersStatsMap.get(player); //  data array
       try{
         ppg = Double.parseDouble(temp[category]);
       } catch(Exception e){
           ppg = -1.0; // placeholder for people who didn't play
       }

      // if player is not in the map, store their data
      if(!points.containsKey(playerName)){
        points.put(playerName, ppg);
      }
      else
        continue;
    }

    return points;
  }

  /**
   * This method returns an integer which represents the column for a given statistic
   * @return integer representing column number for statistical category of interest
   */
  public int getStatCategory(String category){
	  if(category.equalsIgnoreCase("points")){
		  return 47;
	  }
	  else if(category.equalsIgnoreCase("rebounds")){
		  return 43;
	  }
	  else if(category.equalsIgnoreCase("assists")){
		  return 45;
	  }
	  else if(category.equalsIgnoreCase("blocks")){
		  return 53;
	  }
	  else if(category.equalsIgnoreCase("steals")){
		  return 51;
	  }
	  else{
		  System.out.println("Sorry, we currently don't support the category: "+category);
		  return -1;
	  }
  }

  /**
   * This method prints the top ten players in a given statistical category
   * @return null
   */
  public void getTopTen(){
    Map<String, Double> stats = getStats();
    Double[] points = new Double[stats.size()];
    String[] players = new String[stats.size()];
    int index = 0;
    String tempStr;
    Double tempInt;

    // populate the arrays
    for(String stat : stats.keySet()){
      players[index] = stat;
      points[index] = stats.get(stat);
      index++;
    }

    // sort the arrays
    for(int i = 0; i < points.length; i++){
      for(int j = 1; j < points.length - i; j++){
        if(points[j - 1] < points[j]){
          tempInt = points[j-1];
          points[j-1] = points[j];
          points[j] = tempInt;

          tempStr = players[j-1];
          players[j-1] = players[j];
          players[j] = tempStr;
        }
      }
    }

    // print the top ten
    for(int i =0; i < 10; i++){
      index = i+1;
      System.out.println(index + ".\t" + players[i] + "\t - \t" +points[i]);
    }
  }



 }
