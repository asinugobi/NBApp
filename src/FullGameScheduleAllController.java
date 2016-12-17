import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FullGameScheduleAllController implements Initializable {

	@FXML private TableView<Game> schedule;
	@FXML private TableColumn<Game, String> opponent;
	@FXML private TableColumn<Game, String> date;
	@FXML private TableColumn<Game, String> time;
	@FXML private TableColumn<Game, String> location;
	private FullGameSchedule fullSchedule;
	private ArrayList<Game> season; 
	
	
	
	public FullGameScheduleAllController() throws MalformedURLException, IOException {
		fullSchedule = new FullGameSchedule(); 
		season = new ArrayList<Game>();
//		setUp(null); 
		
	}
	
	
	/**
	 * A class to make a game object with information pertaining to each game (opponent, date, time, and location) 
	 */
	public static class Game {

		private final SimpleStringProperty opponent;
		private final SimpleStringProperty date;
		private final SimpleStringProperty time;
		private final SimpleStringProperty location;


		private Game(String opponent, String date, String time, String location) {
			this.opponent = new SimpleStringProperty(opponent);
			this.date = new SimpleStringProperty(date);
			this.time = new SimpleStringProperty(time);
			this.location = new SimpleStringProperty(location);

		}

		public String getOpponent() {
			return opponent.get();
		}

		public String getDate() {
			return date.get();
		}

		public String getTime() {
			return time.get();
		}

		public String getLocation() {
			return location.get();
		}

	}
	
	

	
	private List<Game> getAllGames(){
		ArrayList<String[]> allGames = fullSchedule.getSeasonGames("Bulls");
		for (String[] match : allGames){
			if(match[6].equals("Bulls"))
				season.add(new Game(match[10], match[1], match[2], match[11])); 
			else 
				season.add(new Game(match[6], match[1], match[2], match[11]));
		}
		return season; 
	}	
	
	
	public void back(ActionEvent event) throws IOException{
		Stage primaryStage =  (Stage) ((Node) event.getSource()).getScene().getWindow();  
		
		// set title of the stage 
		primaryStage.setTitle("Full Game Schedule");
		
		// load the category scene file 
		Parent root = FXMLLoader.load(getClass().getResource("FullGameSchedule.fxml"));
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
//	public void setUp(ActionEvent event) throws IOException{
//
//		Parent root = FXMLLoader.load(getClass().getResource("FullGameScheduleAll.fxml"));
//		Scene scene = new Scene(root);
//		schedule.setEditable(true);
//		opponent.setCellValueFactory(new PropertyValueFactory<Game, String>("opponent"));
//		date.setCellValueFactory(new PropertyValueFactory<Game, String>("date"));
//		time.setCellValueFactory(new PropertyValueFactory<Game, String>("time"));
//		location.setCellValueFactory(new PropertyValueFactory<Game, String>("location"));
//		schedule.getItems().setAll(getAllGames());
//
//	}


	@Override
	public void initialize(URL locationURL, ResourceBundle resources) {
		// TODO Auto-generated method stub

		schedule.setEditable(true);
		opponent.setCellValueFactory(new PropertyValueFactory<Game, String>("opponent"));
		date.setCellValueFactory(new PropertyValueFactory<Game, String>("date"));
		time.setCellValueFactory(new PropertyValueFactory<Game, String>("time"));
		location.setCellValueFactory(new PropertyValueFactory<Game, String>("location"));
		schedule.getItems().setAll(getAllGames());
	}
}
