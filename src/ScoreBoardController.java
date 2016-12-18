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
public class ScoreBoardController implements Initializable{
	private String username = null; 
	@FXML private TableView<Player> top5;
	@FXML private TableColumn<Player, String> name;
	@FXML private TableColumn<Player, Double> avg;
	private ArrayList<Player> top5Rebounds;
	private ArrayList<Player> top5Scores;
	private ArrayList<Player> top5Steals;
	private ArrayList<Player> top5Blocks;
	private ArrayList<Player> top5Assists;
	private CumulativePlayerStats stats;

	public ScoreBoardController() throws MalformedURLException, IOException {
		top5Rebounds =  new ArrayList<Player>();
		top5Scores = new ArrayList<Player>();
		top5Steals = new ArrayList<Player>();
		top5Blocks = new ArrayList<Player>();
		top5Assists = new ArrayList<Player>();
		stats = new CumulativePlayerStats();
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



	public void back(ActionEvent event) throws IOException{
		Stage primaryStage =  (Stage) ((Node) event.getSource()).getScene().getWindow();

		// set title of the stage
		primaryStage.setTitle("Select Category");

		// load the category scene file
		Parent root = FXMLLoader.load(getClass().getResource("SelectCategory.fxml"));
		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void points(ActionEvent event) throws IOException{

		Parent root = FXMLLoader.load(getClass().getResource("CumulativePlayerStats.fxml"));
		Scene scene = new Scene(root);
		top5.setEditable(true);
		//name.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
		avg.setCellValueFactory(new PropertyValueFactory<Player, Double>("avg"));
		top5.getItems().setAll(getScoreList());

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

		// public void setFirstName(String fName) {
		// 	name.set(fName);
		// }

		public Double getAvg() {
			return avg.get();
		}

		// public void setLastName(String fName) {
		// 	avg.set(fName);
		// }

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

	}
}
