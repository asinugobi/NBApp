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

public class PlayerInjuriesController implements Initializable {
	
	private PlayerInjuries hurt ;
	@FXML private TableView<Player1> injury;
	@FXML private TableColumn<Player1, String> name;
	@FXML private TableColumn<Player1, String> status;
	private ArrayList<Player1> team;
	private ArrayList<Player1> individual;
	
	public PlayerInjuriesController() throws MalformedURLException, IOException {
		hurt = new PlayerInjuries ("Will Barton", "Spurs");
		team =  new ArrayList();
		individual = new ArrayList();
	}
	
	private List<Player1> getTeamList(){
		if (team.isEmpty()){
			for (String name: hurt.getTeam()) {
				team.add( new Player1(name +": " + hurt.getAllInjuries().get(name))  );
			}
			if (team.isEmpty()) {
				team.add( new Player1("Your favorite team is fine.") );
			}
		}
		return team;
	}
	
	private List<Player1> getIndividual(){
		String thePlayer = hurt.getPlayer() ;
		if (individual.isEmpty()){
			if (hurt.getPlayer() == null) {
				individual.add(new Player1("Your favorite player is fine.")) ;
			} else {
				individual.add( new Player1(thePlayer +": " + hurt.getAllInjuries().get(thePlayer)) );
			}
		}
		return individual;
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
	
	public void myTeam(ActionEvent event) throws IOException{
		// load the TeamStats scene file 

		Parent root = FXMLLoader.load(getClass().getResource("PlayerInjuries.fxml"));
		Scene scene = new Scene(root);
		injury.setEditable(true);
		name.setCellValueFactory(new PropertyValueFactory<Player1, String>("name"));
		injury.getItems().setAll(getTeamList());

	}
	
	public void myPlayer(ActionEvent event) throws IOException{
		// load the TeamStats scene file 

		Parent root = FXMLLoader.load(getClass().getResource("PlayerInjuries.fxml"));
		Scene scene = new Scene(root);
		injury.setEditable(true);
		name.setCellValueFactory(new PropertyValueFactory<Player1, String>("name"));
		injury.getItems().setAll(getIndividual());

	}
	
	//Creating a player class to store the name and avg number
		public static class Player1 {
			private final SimpleStringProperty name;
		

			private Player1(String name) {
				this.name = new SimpleStringProperty(name);
			}

			public String getName() {
				return name.get();
			}

		}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	

}
