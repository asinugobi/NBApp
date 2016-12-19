 /**
  * Main application for launching NBA Feeds App
  * @author obinnaasinugo
  */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NBApp extends Application{

	public static void main(String[] args){
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Welcome to NBA Feeds!");
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml")); 
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void printUser(String user){
		System.out.println(user);
	}
	

}
