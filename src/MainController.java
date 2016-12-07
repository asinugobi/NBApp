
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController {
	@FXML 
	private Label loginStatus;
	
	@FXML 
	private Label accountStatus;
	
	@FXML 
	private TextField username; 
	
	@FXML 
	private TextField password; 
	
	@FXML 
	private TextField favoriteTeam; 
	
	@FXML 
	private TextField favoritePlayer; 
	
	@FXML 
	private TextField newUsername; 
	
	@FXML 
	private TextField newPassword;
	
	@FXML 
	private TextField category;
	
	/**
	 * This method is responsible for handling the user login scene. 
	 * It will determine whether the user login credentials are valid
	 * or invalid. 
	 * @param event
	 * @throws Exception 
	 */
	public void login(ActionEvent event) throws Exception{
		String userName = username.getText();
		String passWord = password.getText();
		
//		loginStatus.setText("Login successful");
		
		try {
			// read in file containing all the users' info 
			FileWriter fw = new FileWriter("resources/username2.txt",true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);
			
			// initializes variables for reading in name 
			String name = null; 
			String[] userArray; 
			boolean hasName = false; 
			
			Scanner input = new Scanner(new File("resources/username2.txt"));
			
			// read through users' info file and test for to see if file contains enter login info 
			if(input.hasNextLine()){
				while(input.hasNextLine()){
					name = input.nextLine();
					userArray = name.split(" "); 
					// login successful (file contains login info) 
					if(userName.equals(userArray[1]) && passWord.equals(userArray[3])){
						loginStatus.setText("Login successful.");
						selectCategory(event); 
						hasName = true; 
					}
				}	
				
				// login failed (file does not contain login info) 
				if(!hasName)
					loginStatus.setText("Login failed. Please try again or create account.");
				
			}else{
				loginStatus.setText("Login failed. Please try again.");
			}	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	           
    }
	
	/**
	 * This method is responsible for creating the stage for a new user account. 
	 * @param event
	 * @throws Exception
	 */
	public void newAccount(ActionEvent event) throws Exception{
		Stage primaryStage =  (Stage) ((Node) event.getSource()).getScene().getWindow();  
		primaryStage.setTitle("Create Account");
		
		Parent root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	/**
	 * This method is responsible for creating the stage for selecting a category. 
	 * @param event
	 * @throws Exception
	 */
	public void selectCategory(ActionEvent event) throws Exception{
//		Stage primaryStage = new Stage();
		Stage primaryStage =  (Stage) ((Node) event.getSource()).getScene().getWindow(); 
		
		primaryStage.setTitle("Select Category");
		
		Parent root = FXMLLoader.load(getClass().getResource("SelectCategory.fxml"));
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	/**
	 * This method is responsible for handling how the user creates a new account. 
	 * It will check to see if entered info is valid and if the chosen username already 
	 * exists. 
	 * @param event
	 * @throws Exception 
	 */
	public void createAccount(ActionEvent event) throws Exception{
		// set boolean values to check for each entry 
		boolean hasUsername = false; 
		boolean hasPwd = false; 
		boolean hasFavoriteTeam = false; 
		boolean hasFavoritePlayer = false; 
		
		// store each respective entry and test to see if value was entered 
		String userName = newUsername.getText(); 
		if(!userName.equals(""))
			hasUsername = true; 
		
		String pwd = newPassword.getText();
		if(!pwd.equals(""))
			hasPwd = true; 
		
		String favTeam = favoriteTeam.getText(); 
		if(!favTeam.equals(""))
			hasFavoriteTeam = true; 
		
		String favPlayer = favoritePlayer.getText(); 
		if(!favPlayer.equals(""))
			hasFavoritePlayer = true; 
		
		// if values are entered for each field, then check to see if user info file 
		// contains the same username and handle appropriately, otherwise prompt the 
		// user to enter value for each field 
		if(hasUsername && hasPwd && hasFavoriteTeam && hasFavoritePlayer){
			try {
				// read in file containing all the users' info 
				FileWriter fw = new FileWriter("resources/username2.txt",true);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter out = new PrintWriter(bw);

				// initializes variables for reading in name 
				String name = null; 
				String[] userArray; 
				boolean hasName = false; 
				Scanner input = new Scanner(new File("resources/username2.txt"));


				// read through users' info file and test for to see if file contains enter login info 
				if(input.hasNextLine()){
					while(input.hasNextLine()){
						name = input.nextLine();
						userArray = name.split(" "); 
						// login successful (file contains login info) 
						if(userName.equals(userArray[1])){
							accountStatus.setText("Username already exists. Try again.");
							hasName = true; 
							break; 
						}
					}	

					if(!hasName){
						out.print("\nUsername: " + userName + " " + "Pwd: " + pwd + " " + "Team: " + favTeam 
								+ " " + "Player: " + favPlayer);
						accountStatus.setText("Account created.");
						selectCategory(event);
					}



				}else{
					out.print("Username: " + userName + " " + "Pwd: " + pwd + " " + "Team: " + favTeam 
							+ " " + "Player: " + favPlayer);
					accountStatus.setText("Account created.");
					selectCategory(event);
				}	

				out.close(); 
				//			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			accountStatus.setText("Please enter values for each field.");
		}
	}
	
	/**
	 * Return the new username entered. 
	 * @return user's username 
	 */
	public String getNewUserName(){
		return newUsername.getText(); 
	}
	
	/**
	 * Return the new password entered. 
	 * @return user's password
	 */
	public String getNewPassword(){
		return newPassword.getText(); 
	}
	
	/**
	 * Return the new favorite team entered. 
	 * @return user's favorite team
	 */
	public String getNewFavoriteTeam(){
		return favoriteTeam.getText(); 
	}
	
	/**
	 * Return the new favorite player entered. 
	 * @return user's favorite player 
	 */
	public String getNewFavoritePlayer(){
		return favoritePlayer.getText(); 
	}
	
	
}


