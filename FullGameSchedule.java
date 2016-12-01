package hw6_project;

import java.util.ArrayList;

/**
 * This class is responsible for tracking information pertaining to the full schedule 
 * of a particular team. 
 * @author obinnaasinugo
 *
 */
public class FullGameSchedule {
	
	private FileReaderv3  fullGameSchedule; 
	
	
	public FullGameSchedule(){
		fullGameSchedule = new FileReaderv3("MYSPORTSFEEDS-FULL_GAME_SCHEDULE-NBA-20152016REGULAR.csv");
	}
	
	/**
	 * Method will return the file read in for the full game schedule. 
	 * @return file read in for the full game schedule 
	 */
	public FileReaderv3 getFile(){
		return fullGameSchedule; 
	}
	
	/**
	 * Method will create a list of all the games for a particular team of interest during a season. 
	 * @param team
	 * @return full schedule of games for the season 
	 */
	public ArrayList<String[]> getSeasonGames(String team){
		
		ArrayList<String[]> teamSchedule = new ArrayList<String[]>(); // create a list of games
		String[] gameInfoArray; // store game info as an array 
		
		// store all games of the 'team' into a list 
		for(String gameInfo : fullGameSchedule.getLines()){
			gameInfoArray = gameInfo.split(","); 
			
			if(gameInfoArray[6].equalsIgnoreCase(team) || 
					gameInfoArray[10].equalsIgnoreCase(team))
				teamSchedule.add(gameInfoArray);
		}
		
		
		return teamSchedule; 
	}
	
	/**
	 * Method will create and return a list of all the games being played on a specific date 
	 * @param date
	 * @return list of all games on specific date 
	 */
	public ArrayList<String[]> getGamesOnDay(String date){
		ArrayList<String[]> games = new ArrayList<String[]>();
		String[] gameInfoArray; // store game info as an array 
		
		// store all games of the 'team' into a list 
		for(String gameInfo : fullGameSchedule.getLines()){
			gameInfoArray = gameInfo.split(","); 
			
			if(gameInfoArray[1].equalsIgnoreCase(date))
				games.add(gameInfoArray);
		}
		
		return games; 
	}

	
	
	
}
