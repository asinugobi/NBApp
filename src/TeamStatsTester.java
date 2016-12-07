import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

public class TeamStatsTester {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		PlayerInjuries injury = new PlayerInjuries("Al Horford", "Knicks");
		System.out.println(injury.getPlayer());
		System.out.println(injury.getTeam());
		
		TeamStats team = new TeamStats("spurs");
		System.out.println(team.getTop5Scores());
		System.out.println(team.getTop5Rebounds());
		System.out.println(team.getTop5Assists());
		System.out.println(team.getTop5Blockss());
		System.out.println(team.getTop5Steals());
	}	
}
