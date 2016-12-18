

import java.util.HashMap;
import java.util.Formatter;

/**
 * This class is responsible for evaluating data pertaining to
 * the overall standings, conference team standings, division
 * team standings, and playoff team standings.
 * @author obinnaasinugo
 *
 */
public class TeamStandings {

	private FileReaderv3 teamStandings;
	private HashMap<String, String[]> teamStatsMap;

	/**
	 *
	 */
	public TeamStandings(){
		teamStandings = new FileReaderv3("resources/MYSPORTSFEEDS-OVERALL_TEAM_STANDINGS-NBA-20152016REGULAR.csv");
		teamStatsMap = new HashMap<String, String[]>();
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
		String teamName;

		for(String team : teamStandings.getLines()){
			teamInfo = team.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
			teamName = teamInfo[3] + " " + teamInfo[4];
			teamStatsMap.put(teamName, teamInfo);
		}
	}

	public HashMap<String, String[]> getteamStatsMap(){
		return teamStatsMap;
	}

	public String[] getTeamRankings(){
		int numberOfTeams = teamStatsMap.size();
		String[] rankings = new String[numberOfTeams];
		int i = 0;
		String[] temp;
		String winLoss;
		String rank;
		String store;

		for(String team : teamStatsMap.keySet()){
			temp = teamStatsMap.get(team);
			winLoss = temp[55] +"-"+ temp[56];
			rank = temp[5];
			rankings[i] = String.format("%1$-2s %2$-24s %3$-5s", rank, team, winLoss);
			i++;
		}

		return rankings;
	}
<<<<<<< HEAD
	
=======


>>>>>>> 88819995dd3d50af8a7f9f202ed96ed45b0962a5
	/**
	 * This method will take in the rank of a team and return the team's info (name, record, etc.)
	 * @param rank
	 * @return team's info as an array
	 */
	public String[] getTeamInfo(int rank){
		return teamStatsMap.get(rank);
	}
<<<<<<< HEAD
	
		 
=======






>>>>>>> 88819995dd3d50af8a7f9f202ed96ed45b0962a5
}
