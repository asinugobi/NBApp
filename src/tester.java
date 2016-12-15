import java.io.IOException;
import java.net.MalformedURLException;

public class tester {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		TeamStats test = new TeamStats("Jazz");
		System.out.println ( test.getTop5Scorer().get(0) );
		System.out.println ( test.getTop5Score().get(0) );
		PlayerInjuries test1 = new PlayerInjuries("Boris Diaw", "Heat") ;
		System.out.println(test1.getTeamInjuries().get("Will Barton"));
	}	

}
