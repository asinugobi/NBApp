/**
 * This controller class is responsible for handling the GUI interface for the user when selecting a category 
 * @author obinnaasinugo
 */

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class CategoryController {
	
	/**
	 * Load the appropriate category based on which category button was pushed.
	 * @param event, clicked category button 
	 * @throws IOException
	 */
	public void loadCategory(ActionEvent event) throws IOException{
		// set the stage using current window 
		Stage primaryStage =  (Stage) ((Node) event.getSource()).getScene().getWindow();  
		
		// grab the id of the category button that was pushed 
		Button btn = (Button) event.getSource();
		String id = btn.getId();
		
		// set title of the stage 
		primaryStage.setTitle(id);
		
		// split the id category name and concatenate into one string 
		String[] categoryArray = id.split(" ");
		String category = ""; 
		for(String part : categoryArray)
			category = category + part; 
		
		// load the category scene file 
		Parent root = FXMLLoader.load(getClass().getResource(category + ".fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**
	 * Method will allow user to return back to Select Category stage 
	 * @param event
	 * @throws IOException
	 */
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
	
	public void logout(ActionEvent event) throws IOException{
		Stage primaryStage =  (Stage) ((Node) event.getSource()).getScene().getWindow();  
		
		// set title of the stage 
		primaryStage.setTitle("Welcome to NBA Feeds!");
		
		// load the category scene file 
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
