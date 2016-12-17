import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FullGameScheduleController {


	private String username = null; 
	
	public void back(ActionEvent event) throws IOException{
		Stage primaryStage =  (Stage) ((Node) event.getSource()).getScene().getWindow();  
		
		// set title of the stage 
		primaryStage.setTitle("Select Category");
		
		// load the category scene file 
		FXMLLoader loader = new FXMLLoader(getClass().getResource("SelectCategory.fxml"));	
		Parent root = loader.load(); 
		// pass username info 
		CategoryController category = loader.<CategoryController>getController(); 
		category.setUserName(username);
		
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

	public void setUserName(String username) {
		// TODO Auto-generated method stub
		this.username = username; 
		System.out.println(username);
		
	}
	

	

}
