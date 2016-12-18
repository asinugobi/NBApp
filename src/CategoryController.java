/**
 * This controller class is responsible for handling the GUI interface for the user when selecting a category 
 * @author obinnaasinugo
 */

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
		
//		Parent root = null; // set root to null 
		
//		// set up stage and pass through user name to next controller depending on which category is pressed 
//		switch(category){
//		case "CumulativePlayerStats":
//			FXMLLoader loader = new FXMLLoader(getClass().getResource(category + ".fxml"));	
//			root = loader.load(); 
//			CumulativeStatsController stats = loader.<CumulativeStatsController>getController(); 
//			stats.setUserName(username);
//			break;
//
//		case "DailyPlayerStats": 
//			FXMLLoader loaderDaily = new FXMLLoader(getClass().getResource(category + ".fxml"));	
//			root = loaderDaily.load(); 
//			DailyStatsController statsDaily = loaderDaily.<DailyStatsController>getController(); 
//			statsDaily.setUserName(username);
//			break; 
//			
//		case "FullGameSchedule": 
//			FXMLLoader loaderFullSchedule = new FXMLLoader(getClass().getResource(category + ".fxml"));	
//			root = loaderFullSchedule.load(); 
//			FullGameScheduleController fullSchedule = loaderFullSchedule.<FullGameScheduleController>getController(); 
//			fullSchedule.setUserName(username);
//			break;
//		case "TeamStats":
//			FXMLLoader loaderTeamStats = new FXMLLoader(getClass().getResource(category + ".fxml"));	
//			root = loaderTeamStats.load(); 
//			TeamStatsController teamStats = loaderTeamStats.<TeamStatsController>getController(); 
//			teamStats.setUserName(username);
//			break;
//		case "PlayerInjuries": 
//			FXMLLoader loaderPlayerInjuries = new FXMLLoader(getClass().getResource(category + ".fxml"));	
//			root = loaderPlayerInjuries.load(); 
//			PlayerInjuriesController playerInjuries = loaderPlayerInjuries.<PlayerInjuriesController>getController(); 
//			playerInjuries.setUserName(username);
//			break;
//		default: 
//			root = FXMLLoader.load(getClass().getResource(category + ".fxml"));
//			break; 
//			
//		}
		// set up stage and pass through user name to next controller depending on which category is pressed 
//		switch(category){
//		case "CumulativePlayerStats":
//			FXMLLoader loader = new FXMLLoader(getClass().getResource(category + ".fxml"));	
//			root = loader.load(); 
//			CumulativeStatsController stats = loader.<CumulativeStatsController>getController(); 
//			stats.setUserName(username);
//			break;
//
//		case "DailyPlayerStats": 
//			FXMLLoader loaderDaily = new FXMLLoader(getClass().getResource(category + ".fxml"));	
//			root = loaderDaily.load(); 
//			DailyStatsController statsDaily = loaderDaily.<DailyStatsController>getController(); 
//			statsDaily.setUserName(username);
//			break; 
//			
//		case "TeamStandings": 
//			FXMLLoader loaderStandings = new FXMLLoader(getClass().getResource(category + ".fxml"));	
//			root = loaderStandings.load(); 
//			TeamStandingsController standings = loaderStandings.<TeamStandingsController>getController(); 
//			standings.setUserName(username);
//			break; 
//			
//		case "Scoreboard": 
//			FXMLLoader loaderScoreBoard = new FXMLLoader(getClass().getResource(category + ".fxml"));	
//			root = loaderScoreBoard.load(); 
//			ScoreBoardController scoreboard = loaderScoreBoard.<ScoreBoardController>getController(); 
//			scoreboard.setUserName(username);
//			break;
//			
//		case "FullGameSchedule": 
//			FXMLLoader loaderFullSchedule = new FXMLLoader(getClass().getResource(category + ".fxml"));	
//			root = loaderFullSchedule.load(); 
//			FullGameScheduleController fullSchedule = loaderFullSchedule.<FullGameScheduleController>getController(); 
//			fullSchedule.setUserName(username);
//			break;
//		case "TeamStats":
//			FXMLLoader loaderTeamStats = new FXMLLoader(getClass().getResource(category + ".fxml"));	
//			root = loaderTeamStats.load(); 
//			TeamStatsController teamStats = loaderTeamStats.<TeamStatsController>getController(); 
//			teamStats.setUserName(username);
//			break;
//		case "PlayerInjuries": 
//			FXMLLoader loaderPlayerInjuries = new FXMLLoader(getClass().getResource(category + ".fxml"));	
//			root = loaderPlayerInjuries.load(); 
//			PlayerInjuriesController playerInjuries = loaderPlayerInjuries.<PlayerInjuriesController>getController(); 
//			playerInjuries.setUserName(username);
//			break;
//		default: 
//			root = FXMLLoader.load(getClass().getResource(category + ".fxml"));
//			break; 
//			
//		}
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

}
