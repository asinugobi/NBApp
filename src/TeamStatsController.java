import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Application;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * This class will control the TeamStats Panel and show top5 players 
 * @author Eddie
 *
 */
public class TeamStatsController implements Initializable{

	private LoginModel loginModel = new LoginModel(); 
	private String username = loginModel.getUsername(); 
	private String favoritePlayer = loginModel.getPlayer(username); 
	private String favoriteTeam = loginModel.getTeam(username);
	
	private TeamStats theTeam;
	@FXML private TableView<Player> top5;
	@FXML private TableColumn<Player, String> name;
	@FXML private TableColumn<Player, String> avg;
	@FXML private ImageView ivBack; 
	private ArrayList<Player> top5Rebounds;
	private ArrayList<Player> top5Scores;
	private ArrayList<Player> top5Steals;
	private ArrayList<Player> top5Blocks;
	private ArrayList<Player> top5Assists;

	public TeamStatsController() throws MalformedURLException, IOException, SQLException {
		theTeam = new TeamStats(favoriteTeam);
		top5Rebounds =  new ArrayList();
		top5Scores = new ArrayList();
		top5Steals = new ArrayList();
		top5Blocks = new ArrayList();
		top5Assists = new ArrayList();
	}

	/**
	 * This method will create the ArrayList of <player> for the first time, and return it afterwards
	 * @return the <player> ArrayList
	 */
	private List<Player> getReboundList(){
		if (top5Rebounds.isEmpty()){
			for (int i=0; i<5 ; i++) {
				top5Rebounds.add(new Player(theTeam.getTop5Rebounder().get(i), theTeam.getTop5Rebound().get(i)) );
			} 	
		}
		return top5Rebounds;
	}

	private List<Player> getScoreList(){
		// construct top5 list by looping
		// and return the list  
		if(top5Scores.isEmpty()) {
			for (int i=0; i<5 ; i++) {
				top5Scores.add(new Player(theTeam.getTop5Scorer().get(i), theTeam.getTop5Score().get(i)) );
			} 
		}
		return top5Scores;
	}

	private List<Player> getBlockList(){
		// construct top5 list by looping
		// and return the list
		if(top5Blocks.isEmpty()) {
			for (int i=0; i<5 ; i++) {
				top5Blocks.add(new Player(theTeam.getTop5Blocker().get(i), theTeam.getTop5Block().get(i)) );
			} 
		}
		return top5Blocks;
	}

	private List<Player> getStealList(){
		// construct top5 list by looping
		// and return the list  
		if (top5Steals.isEmpty()) {
			for (int i=0; i<5 ; i++) {
				top5Steals.add(new Player(theTeam.getTop5Stealer().get(i), theTeam.getTop5Steal().get(i)) );
			} 
		}
		return top5Steals;
	}

	private List<Player> getAssistList(){
		// construct top5 list by looping
		// and return the list  
		if (top5Assists.isEmpty()) {
			for (int i=0; i<5 ; i++) {
				top5Assists.add(new Player(theTeam.getTop5Assistant().get(i), theTeam.getTop5Assist().get(i)) );
			} 
		}
		return top5Assists;
	}



	public void back(ActionEvent event) throws IOException{
		Stage primaryStage =  (Stage) ((Node) event.getSource()).getScene().getWindow();  

		// set title of the stage 
		primaryStage.setTitle("Select Category");

		// load the category scene file 
		FXMLLoader loader = new FXMLLoader(getClass().getResource("SelectCategory.fxml"));	
		Parent root = loader.load();
		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void points(ActionEvent event) throws IOException{
		// load the TeamStats scene file 

		Parent root = FXMLLoader.load(getClass().getResource("TeamStats.fxml"));
		Scene scene = new Scene(root);
		top5.setEditable(true);
		name.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
		avg.setCellValueFactory(new PropertyValueFactory<Player, String>("avg"));
		top5.getItems().setAll(getScoreList());

	}

	public void assists(ActionEvent event) throws IOException{

		// load the TeamStats scene file 
		Parent root = FXMLLoader.load(getClass().getResource("TeamStats.fxml"));
		Scene scene = new Scene(root);
		top5.setEditable(true);
		name.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
		avg.setCellValueFactory(new PropertyValueFactory<Player, String>("avg"));
		top5.getItems().setAll(getAssistList());
	}

	public void steals(ActionEvent event) throws IOException{

		// load the TeamStats scene file 
		Parent root = FXMLLoader.load(getClass().getResource("TeamStats.fxml"));
		Scene scene = new Scene(root);

		top5.setEditable(true);
		name.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
		avg.setCellValueFactory(new PropertyValueFactory<Player, String>("avg"));
		top5.getItems().setAll(getStealList());
	}

	public void rebounds(ActionEvent event) throws IOException{

		// load the TeamStats scene file 
		Parent root = FXMLLoader.load(getClass().getResource("TeamStats.fxml"));
		Scene scene = new Scene(root);
		top5.setEditable(true);
		name.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
		avg.setCellValueFactory(new PropertyValueFactory<Player, String>("avg"));
		top5.getItems().setAll(getReboundList());

	}

	public void blocks(ActionEvent event) throws IOException{

		// load the TeamStats scene file 
		Parent root = FXMLLoader.load(getClass().getResource("TeamStats.fxml"));
		Scene scene = new Scene(root);

		top5.setEditable(true);
		name.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
		avg.setCellValueFactory(new PropertyValueFactory<Player, String>("avg"));
		top5.getItems().setAll(getBlockList());
	}
	
	//Creating a player class to store the name and avg number
	public static class Player {

		private final SimpleStringProperty name;
		private final SimpleStringProperty avg;

		private Player(String name, String avg) {
			this.name = new SimpleStringProperty(name);
			this.avg = new SimpleStringProperty(avg);
		}

		public String getName() {
			return name.get();
		}

		public String getAvg() {
			return avg.get();
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		File imageName = new File("resources/" + favoriteTeam + ".jpg"); 
		Image image = new Image(imageName.toURI().toString());
		// simple displays ImageView the image as is
		ivBack.setImage(image);
	}


}
