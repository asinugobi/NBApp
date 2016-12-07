import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
		
//		System.out.println(category);
		
		// load the category scene file 
		Parent root = FXMLLoader.load(getClass().getResource(category + ".fxml"));
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();
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

}
