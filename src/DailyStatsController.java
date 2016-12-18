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
	private String favoriteTeam; 
	
	@FXML private TableView<DailyPlayer> game;
	@FXML private TableColumn<DailyPlayer, String> points;
	@FXML private TableColumn<DailyPlayer, String> assists;
	@FXML private TableColumn<DailyPlayer, String> rebounds;
	@FXML private TableColumn<DailyPlayer, String> steals;
	@FXML private TableColumn<DailyPlayer, String> blocks;
	@FXML private Label activityLabel; 
	
	private DailyPlayerStats dailyStats; 
	private ArrayList<DailyPlayer> statsList; 
	private boolean didNotPlay;
	
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
		favoriteTeam = loginModel.getTeam(username); 
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
	
		public String getPoints() {
			return points.get();
		}

		public String getAssists() {
			return assists.get();
		}

		public String getRebounds() {
			return rebounds.get();
		}

		public String getSteals() {
			return steals.get();
		}
		
		public String getBlocks() {
			return blocks.get();
		}

	}
	
	public void active(){
		didNotPlay = false; 
		activityLabel.setText(favoritePlayer + ": ACTIVE");
	}
	
	public void notActive(){
		didNotPlay = true; 
		activityLabel.setText(favoritePlayer + ": INACTIVE");
	}
	
	public boolean activity(){
		return didNotPlay; 
	}
	
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
	
	
	public void back(ActionEvent event) throws IOException{
		Stage primaryStage =  (Stage) ((Node) event.getSource()).getScene().getWindow();  
		
		// set title of the stage 
		primaryStage.setTitle("Select Category");
		
		// load the category scene file 
		FXMLLoader loader = new FXMLLoader(getClass().getResource("SelectCategory.fxml"));	
		Parent root = loader.load(); 
		// pass username info 
//		CategoryController category = loader.<CategoryController>getController(); 
//		category.setUserName(username);	
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	@Override
	public void initialize(URL locationURL, ResourceBundle resources) {
		// TODO Auto-generated method stub

		game.setEditable(true);
		points.setCellValueFactory(new PropertyValueFactory<DailyPlayer, String>("points"));
		assists.setCellValueFactory(new PropertyValueFactory<DailyPlayer, String>("assists"));
		rebounds.setCellValueFactory(new PropertyValueFactory<DailyPlayer, String>("rebounds"));
		steals.setCellValueFactory(new PropertyValueFactory<DailyPlayer, String>("steals"));
		blocks.setCellValueFactory(new PropertyValueFactory<DailyPlayer, String>("blocks"));
		game.getItems().setAll(getStats());
		printUser(); 
		
	}

	public void setUserName(String username) {
		// TODO Auto-generated method stub
		this.username = username; 
		
	}
	
	public void printUser(){
		System.out.println("Username: " + username + "\nFavorite Player: " + favoritePlayer + "\nFavorite Team: " + favoriteTeam);
	}
	
}
