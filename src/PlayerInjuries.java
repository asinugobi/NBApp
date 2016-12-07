import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class represents information regarding player(s) injuries. 
 * @author Eddie
 *
 */
public class PlayerInjuries {
	private FileDownloader dl;
	private FileReaderv3 injury;
	private String player; // player of interest 
	private String teamName;
	private ArrayList<String>lines;
	private HashMap<String, String> teamInjuries;
	private HashMap<String, String> allInjuries;
	
	public PlayerInjuries(String player, String team) throws MalformedURLException, IOException{
		this.player = player; 
		this.teamName = team;
		dl = new FileDownloader("/Users/Eddie/Documents/cit-591-projects-fall-2016-sports_feeds/resources/");
		dl.playerInjuries();
		injury = new FileReaderv3("resources/player_injuries.csv");
		lines = injury.getLines();
		teamInjuries = new HashMap<String, String>();
		allInjuries = new HashMap<String, String>();
		teamInjuries();
		allInjuries();
	}
	
	/**
	 * This method will generate a HashMap for all Injured players in a specified team.
	 */
	private void teamInjuries() {
		for(String line: lines) {
			String[] str = line.split(",");
			if ( str[16].equalsIgnoreCase(teamName) ) {
				teamInjuries.put(str[3] + " " + str[2], str[17]);
			} else if ( str[17].equalsIgnoreCase(teamName) ) {
				teamInjuries.put(str[3] + " " + str[2], str[18]);
			}
		}
	}
	/**
	 * This method will generate a HashMap for all Injured players.
	 */
	private void allInjuries() {
		for(String line: lines) {
			String[] str = line.split(",");
			if ( str.length == 18 ) {
				allInjuries.put(str[3] + " " + str[2], str[17]);
			} else if ( str.length == 19 ) {
				allInjuries.put(str[3] + " " + str[2], str[18]);
			}
		}
	}

	/**
	 * @return the teamInjuries
	 */
	public HashMap<String, String> getTeamInjuries() {
		return teamInjuries;
	}

	/**
	 * @return the allInjuries
	 */
	public HashMap<String, String> getAllInjuries() {
		return allInjuries;
	}
	
	/**
	 * This method will return a player's status if he is injured.
	 * @return
	 */
	public String getPlayer() {
		if (allInjuries.containsKey(player)) {
			return player + ", " + allInjuries.get(player);
		}
		else {
			return null;
		}
	}
	
	/**
	 * This method will return a team's all injured players in an ArrayList
	 * @return
	 */
	public ArrayList<String> getTeam() {
		ArrayList<String> team = new ArrayList();
		for (String name: teamInjuries.keySet()) {
			team.add( name + " " + teamInjuries.get(name) );
		}
		return team;
	}
	
}
