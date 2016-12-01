

import java.util.HashMap;

/**
 * This class is responsible for evaluating data pertaining to 
 * the overall standings, conference team standings, division 
 * team standing, and playoff team standing. 
 * @author obinnaasinugo
 *
 */
public class TeamStandings {
	
	private FileReaderv3 teamStandings; 
	private HashMap<Integer, String[]> teamStatsMap; 
	
	/**
	 * 
	 */
	public TeamStandings(){
		teamStandings = new FileReaderv3("MYSPORTSFEEDS-OVERALL_TEAM_STANDINGS-NBA-20152016REGULAR.csv");
		teamStatsMap = new HashMap<Integer, String[]>();
		makeTeamStandingsMap(); 
	}
	
	/**
	 * This method will return the file read in by the program 
	 * @return file read in by the program 
	 */
	public FileReaderv3 getFile(){
		return teamStandings;
	}
	
	/**
	 * This method will populate the team standings map. The key is the rank of the team; the 
	 * value is the team info (name, record, etc.)
	 */
	public void makeTeamStandingsMap(){
		String[] teamInfo = null; 
		
		for(String team : teamStandings.getLines()){
			teamInfo = team.split(","); 
			teamStatsMap.put(Integer.parseInt(teamInfo[5]), teamInfo);
		}
	}
	
	
	/**
	 * This method will take in the rank of a team and return the team's info (name, record, etc.)
	 * @param rank
	 * @return team's info as an array 
	 */
	public String[] getTeamInfo(int rank){
		return teamStatsMap.get(rank);
	}
	
	
	
	
	
		 
}
