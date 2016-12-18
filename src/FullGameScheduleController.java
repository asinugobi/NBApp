import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class FullGameScheduleController implements Initializable {
	
	// load user info into controller
	private LoginModel loginModel = new LoginModel(); 
	private String username ;
	private String favoritePlayer; 
	private String favoriteTeam;  
	
	@FXML private ImageView iv1; 

	/**
	 * Initialize constructor to handle and load the user info (favorite team and player) 
	 * @throws SQLException
	 */
	public FullGameScheduleController() throws SQLException {
		username = loginModel.getUsername(); 
		favoritePlayer = loginModel.getPlayer(username); 
		favoriteTeam = loginModel.getTeam(username); 
	}

	/**
	 * Return back to the Select Category stage. 
	 * @param event
	 * @throws IOException
	 */
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
	
	/**
	 * This method is responsible for going to display the stage for full season of games 
	 * @param event
	 * @throws IOException
	 */
	public void allGames(ActionEvent event) throws IOException{
		Stage primaryStage =  (Stage) ((Node) event.getSource()).getScene().getWindow();  
		
		// set title of the stage 
		primaryStage.setTitle("Season Games");
		
		// load the category scene file 
		Parent root = FXMLLoader.load(getClass().getResource("FullGameScheduleAll.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		// load the image
		File imageName = new File("resources/CHI-1.png"); 
        Image image = new Image(imageName.toURI().toString());
        // simple displays ImageView the image as is
        iv1.setImage(image);
	}

}
