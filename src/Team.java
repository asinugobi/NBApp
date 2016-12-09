import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;


/**
 * This class will store top5 players of a team and their statistics in 5 categories.
 * @author Eddie
 *
 */
public class Team {
	
	private TeamStats team;
	private ArrayList<String>top5Scorer;
	private ArrayList<String>top5Blocker;
	private ArrayList<String>top5Assistant;
	private ArrayList<String>top5Rebounder;
	private ArrayList<String>top5Stealer;
	
	private ArrayList<String>top5Score;
	private ArrayList<String>top5Block;
	private ArrayList<String>top5Assist;
	private ArrayList<String>top5Rebound;
	private ArrayList<String>top5Steal;
	
	public Team(String theTeam) throws MalformedURLException, IOException {
		team = new TeamStats(theTeam);
		top5Scorer = team.getTop5Scores();
		top5Blocker = team.getTop5Blockss();
		top5Assistant = team.getTop5Assists();
		top5Rebounder = team.getTop5Rebounds();
		top5Stealer = team.getTop5Steals();
		
		top5Score = new ArrayList<String>();
		top5Block = new ArrayList<String>();
		top5Assist = new ArrayList<String>();
		top5Rebound = new ArrayList<String>();
		top5Steal = new ArrayList<String>();
	}
	
	
	
	/**
	 * @return the top5Score
	 */
	public ArrayList<String> getTop5Score() {
		for(String name: top5Scorer) {
			top5Score.add(team.getScores().get(name).toString());
		}
		return top5Score;
	}



	/**
	 * @return the top5Block
	 */
	public ArrayList<String> getTop5Block() {
		for(String name: top5Blocker) {
			top5Block.add(team.getBlocks().get(name).toString());
		}
		return top5Block;
	}



	/**
	 * @return the top5Assist
	 */
	public ArrayList<String> getTop5Assist() {
		for(String name: top5Assistant) {
			top5Assist.add(team.getAssists().get(name).toString());
		}
		return top5Assist;
	}



	/**
	 * @return the top5Rebound
	 */
	public ArrayList<String> getTop5Rebound() {
		for(String name: top5Rebounder) {
			top5Rebound.add(team.getRebounds().get(name).toString());
		}
		return top5Rebound;
	}



	/**
	 * @return the top5Steal
	 */
	public ArrayList<String> getTop5Steal() {
		for(String name: top5Stealer) {
			top5Steal.add(team.getSteals().get(name).toString());
		}
		return top5Steal;
	}



	/**
	 * @return the top5Scorer
	 */
	public ArrayList<String> getTop5Scorer() {
		return top5Scorer;
	}

	/**
	 * @return the top5Blocker
	 */
	public ArrayList<String> getTop5Blocker() {
		return top5Blocker;
	}

	/**
	 * @return the top5Assistant
	 */
	public ArrayList<String> getTop5Assistant() {
		return top5Assistant;
	}

	/**
	 * @return the top5Rebounder
	 */
	public ArrayList<String> getTop5Rebounder() {
		return top5Rebounder;
	}

	/**
	 * @return the top5Stealer
	 */
	public ArrayList<String> getTop5Stealer() {
		return top5Stealer;
	}
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		Team team = new Team("Jazz");
		System.out.println(team.getTop5Scorer());
		System.out.println(team.getTop5Score());
	}
}
