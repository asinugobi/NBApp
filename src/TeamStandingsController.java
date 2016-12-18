import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
/**
 * This class will control the Cumualtive Stats Panel
 * @author chimezie
 *
 */
public class TeamStandingsController implements Initializable{

	private String username = null;

	@FXML private TableView<Team> top5;
	@FXML private TableColumn<Team, String> name;
	private ArrayList<Team> leagueStandings;
	private TeamStandings stats;

	public TeamStandingsController() throws MalformedURLException, IOException {
		stats = new TeamStandings();
	}

	public ArrayList<Team> getLeagueStandings(){
		String[] temp = stats.getTeamRankings();


		for(int i=0; i< temp.length; i++){
			leagueStandings.add(new Team(temp[i]));
		}
		return leagueStandings;
	}


	public void back(ActionEvent event) throws IOException{
		Stage primaryStage =  (Stage) ((Node) event.getSource()).getScene().getWindow();

		// set title of the stage
		primaryStage.setTitle("Select Category");
		FXMLLoader loaderStandings = new FXMLLoader(getClass().getResource("SelectCategory.fxml"));
		Parent root = loaderStandings.load();
		CategoryController category = loaderStandings.<CategoryController>getController();
		category.setUserName(username);
		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.show();
	}


	/**
	* populates the table view with the block information
	* @param event
	*/
	public void leaguestandings(ActionEvent event) throws IOException{

		// load the scene file
		Parent root = FXMLLoader.load(getClass().getResource("TeamStandings.fxml"));
		Scene scene = new Scene(root);

		top5.setEditable(true);
		name.setCellValueFactory(new PropertyValueFactory<Team, String>("name"));
		top5.getItems().setAll(getLeagueStandings());
	}

  /**
  * A class to make a team object with name and team stats
  */
	public static class Team {

		private final SimpleStringProperty name;

		private Team(String name) {
			this.name = new SimpleStringProperty(name);
		}

		public String getName() {
			return name.get();
		}
	}

	/**
	 * This method will handle passing through the username info so it can be used to query the database
	 * @param name
	 */
	public void setUserName(String name){
		username = name;
		System.out.println(username);
	}

  // initializes table_view
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		top5.setEditable(true);
		name.setCellValueFactory(new PropertyValueFactory<Team, String>("name"));
		top5.getItems().setAll(getLeagueStandings());
	}
}
