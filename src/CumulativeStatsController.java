import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
/**
 * This class will control the Cumualtive Stats Panel
 * @author chimezie
 *
 */
public class CumulativeStatsController implements Initializable{

	@FXML private TableView<Player> top5;
	@FXML private TableColumn<Player, String> name;
	@FXML private TableColumn<Player, Double> avg;
	@FXML private ImageView ivBack; 
	private ArrayList<Player> top5Rebounds;
	private ArrayList<Player> top5Scores;
	private ArrayList<Player> top5Steals;
	private ArrayList<Player> top5Blocks;
	private ArrayList<Player> top5Assists;
	private CumulativePlayerStats stats;
	
	// load user info into controller
	private LoginModel loginModel = new LoginModel(); 
	private String username ;
	private String favoritePlayer; 
	private String favoriteTeam;  

	public CumulativeStatsController() throws MalformedURLException, IOException, SQLException {
		top5Rebounds =  new ArrayList<Player>();
		top5Scores = new ArrayList<Player>();
		top5Steals = new ArrayList<Player>();
		top5Blocks = new ArrayList<Player>();
		top5Assists = new ArrayList<Player>();
		stats = new CumulativePlayerStats();
		username = loginModel.getUsername(); 
		favoritePlayer = loginModel.getPlayer(username); 
		favoriteTeam = loginModel.getTeam(username); 
	}

	private List<Player> getReboundList(){
		Map<String, Double> temp = stats.getStats("rebounds");

		for(String i : temp.keySet()){
			top5Rebounds.add(new Player(i, temp.get(i)));
		}
		return top5Rebounds;
	}

	private List<Player> getScoreList(){
		Map<String, Double> temp = stats.getStats("points");

		for(String i : temp.keySet()){
			top5Scores.add(new Player(i, temp.get(i)));
		}
		return top5Scores;
	}

	private List<Player> getBlockList(){
		Map<String, Double> temp = stats.getStats("blocks");

		for(String i : temp.keySet()){
			top5Blocks.add(new Player(i, temp.get(i)));
		}
		return top5Blocks;
	}

	private List<Player> getStealList(){
		Map<String, Double> temp = stats.getStats("steals");

		for(String i : temp.keySet()){
			top5Steals.add(new Player(i, temp.get(i)));
		}
		return top5Steals;
	}

	private List<Player> getAssistList(){
		Map<String, Double> temp = stats.getStats("assists");

		for(String i : temp.keySet()){
			top5Assists.add(new Player(i, temp.get(i)));
		}
		return top5Assists;
	}



	public void back(ActionEvent event) throws IOException{
		Stage primaryStage =  (Stage) ((Node) event.getSource()).getScene().getWindow();

		// set title of the stage
		primaryStage.setTitle("Select Category");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("SelectCategory.fxml"));	
		Parent root = loader.load(); 
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("SelectCategory.fxml"));
//		Parent root = loader.load();
		CategoryController category = loader.<CategoryController>getController();
//		category.setUserName(username);
		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void points(ActionEvent event) throws IOException{

		Parent root = FXMLLoader.load(getClass().getResource("CumulativePlayerStats.fxml"));
		Scene scene = new Scene(root);
		top5.setEditable(true);
		name.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
		avg.setCellValueFactory(new PropertyValueFactory<Player, Double>("avg"));
		top5.getItems().setAll(getScoreList());

	}

	public void assists(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("CumulativePlayerStats.fxml"));
		Scene scene = new Scene(root);
		top5.setEditable(true);
		name.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
		avg.setCellValueFactory(new PropertyValueFactory<Player, Double>("avg"));
		top5.getItems().setAll(getAssistList());
	}

	public void steals(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("CumulativePlayerStats.fxml"));
		Scene scene = new Scene(root);

		top5.setEditable(true);
		name.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
		avg.setCellValueFactory(new PropertyValueFactory<Player, Double>("avg"));
		top5.getItems().setAll(getStealList());
	}

	public void rebounds(ActionEvent event) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("CumulativePlayerStats.fxml"));
		Scene scene = new Scene(root);
		top5.setEditable(true);
		name.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
		avg.setCellValueFactory(new PropertyValueFactory<Player, Double>("avg"));
		top5.getItems().setAll(getReboundList());

	}


	/**
	* populates the table view with the block information
	* @param event
	*/
	public void blocks(ActionEvent event) throws IOException{

		// load the scene file
		Parent root = FXMLLoader.load(getClass().getResource("CumulativePlayerStats.fxml"));
		Scene scene = new Scene(root);

		top5.setEditable(true);
		name.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
		avg.setCellValueFactory(new PropertyValueFactory<Player, Double>("avg"));
		top5.getItems().setAll(getBlockList());
	}

  /**
  * A class to make a player object with name and player stats
  */
	public static class Player {

		private final SimpleStringProperty name;
		private final SimpleDoubleProperty avg;

		private Player(String name, Double avg) {
			this.name = new SimpleStringProperty(name);
			this.avg = new SimpleDoubleProperty(avg);
		}

		public String getName() {
			return name.get();
		}

		public Double getAvg() {
			return avg.get();
		}

	}

  // initializes table_view
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		File imageName = new File("resources/" + favoriteTeam + ".jpg"); 
		Image image = new Image(imageName.toURI().toString());
		// simple displays ImageView the image as is
		ivBack.setImage(image);
	}
}
