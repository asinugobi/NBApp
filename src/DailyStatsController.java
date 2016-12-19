/**
 * This controller class represents the handling of the GUI interface for the Daily Player Stats Category 
 * @author obinnaasinugo
 */
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class DailyStatsController implements Initializable {

	// load user info into controller
	private LoginModel loginModel = new LoginModel(); 
	private String username; 
	private String favoritePlayer; 
	
	@FXML private TableView<DailyPlayer> game; // game table 
	@FXML private TableColumn<DailyPlayer, String> points; // points column
	@FXML private TableColumn<DailyPlayer, String> assists; // assist column 
	@FXML private TableColumn<DailyPlayer, String> rebounds; // rebounds column
	@FXML private TableColumn<DailyPlayer, String> steals; // steals column
	@FXML private TableColumn<DailyPlayer, String> blocks; // blocks column
	@FXML private Label activityLabel; // inactive - player is not playing that day or has not played yet; active - player is playing or has played 
	
	private DailyPlayerStats dailyStats; // track daily stats
	private ArrayList<DailyPlayer> statsList; 
	private boolean didNotPlay; // true if played has/is not playing; false otherwise 
	
	/**
	 * Initialize constructor with appropriate variables and load the user's info 
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws SQLException
	 */
	public DailyStatsController() throws MalformedURLException, IOException, SQLException {
		dailyStats = new DailyPlayerStats(); 
		statsList = new ArrayList<DailyPlayer>(); 
		username = loginModel.getUsername(); 
		favoritePlayer = loginModel.getPlayer(username); 
	}

	/**
	 * A class to get daily player's stats object with information pertaining to each game (points, rebounds, assists, blocks, steals) 
	 */
	public static class DailyPlayer {

		private final SimpleStringProperty points;
		private final SimpleStringProperty assists;
		private final SimpleStringProperty rebounds;
		private final SimpleStringProperty steals;
		private final SimpleStringProperty blocks; 
	
		private DailyPlayer(String points, String assists, String rebounds, String steals, String blocks) {
			this.points = new SimpleStringProperty(points);
			this.assists = new SimpleStringProperty(assists);
			this.rebounds = new SimpleStringProperty(rebounds);
			this.steals = new SimpleStringProperty(steals);
			this.blocks = new SimpleStringProperty(blocks);
		}
	
		/**
		 * gets points 
		 * @return
		 */
		public String getPoints() {
			return points.get();
		}

		/**
		 * gets assists 
		 * @return
		 */
		public String getAssists() {
			return assists.get();
		}

		/**
		 * gets rebounds
		 * @return
		 */
		public String getRebounds() {
			return rebounds.get();
		}

		/**
		 * gets steals 
		 * @return
		 */
		public String getSteals() {
			return steals.get();
		}
		
		/**
		 * gets blocks 
		 * @return
		 */
		public String getBlocks() {
			return blocks.get();
		}

	}
	
	/**
	 * determines is player is playing on given day and sets label appropriately 
	 */
	public void active(){
		didNotPlay = false; 
		activityLabel.setText(favoritePlayer + ": ACTIVE");
	}
	/**
	 * determines is player is playing on given day and sets label appropriately 
	 */
	public void notActive(){
		didNotPlay = true; 
		activityLabel.setText(favoritePlayer + ": INACTIVE");
	}
	/**
	 * returns whether player is playing or not  
	 */
	public boolean activity(){
		return didNotPlay; 
	}
	
	/**
	 * Creates list of player stats 
	 * @return
	 */
	private List<DailyPlayer> getStats(){
		String[] playerStats = dailyStats.getPlayerStats(favoritePlayer);
			 
		// if player stats is null, then player did not play that day; handle case appropriately 
		if(playerStats==null){
			statsList.add(new DailyPlayer("0","0","0","0","0")); // add DailyPlayer objects to list 
			notActive(); // player was inactive that day 
			return statsList; 
		}
		
		statsList.add(new DailyPlayer(playerStats[0],playerStats[1],
				playerStats[2],playerStats[3],playerStats[4])); // add DailyPlayer objects to list 
		active(); // player did play that day 
		return statsList; 
	}
	
	/**
	 * returns user back to category stage 
	 * @param event
	 * @throws IOException
	 */
	public void back(ActionEvent event) throws IOException{
		Stage primaryStage =  (Stage) ((Node) event.getSource()).getScene().getWindow();  
		primaryStage.setTitle("Select Category");	// set title of the stage 
		// load the category scene file 
		FXMLLoader loader = new FXMLLoader(getClass().getResource("SelectCategory.fxml"));	
		Parent root = loader.load(); 
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**
	 * Initialize the stage
	 */
	@Override
	public void initialize(URL locationURL, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//set up values in the table 
		game.setEditable(true);
		points.setCellValueFactory(new PropertyValueFactory<DailyPlayer, String>("points"));
		assists.setCellValueFactory(new PropertyValueFactory<DailyPlayer, String>("assists"));
		rebounds.setCellValueFactory(new PropertyValueFactory<DailyPlayer, String>("rebounds"));
		steals.setCellValueFactory(new PropertyValueFactory<DailyPlayer, String>("steals"));
		blocks.setCellValueFactory(new PropertyValueFactory<DailyPlayer, String>("blocks"));
		game.getItems().setAll(getStats()); 
		
	}
}
