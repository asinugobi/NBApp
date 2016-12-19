import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class FullGameScheduleController implements Initializable {
	
	// load user info into controller
	private LoginModel loginModel = new LoginModel(); 
	private String username ;
	private String favoritePlayer; 
	private String favoriteTeam;  
	private FullGameSchedule fullSchedule;
	
	@FXML private ImageView ivBack; // background image 
	@FXML private ImageView ivHome; // home team image
	@FXML private ImageView ivAway; // away team image 
	@FXML private Label awayTeam; // store away team label  
	@FXML private Label homeTeam; // store home team label 
	@FXML private Label gameDetails; // store time and location 
	@FXML private Label at; // store at sign 
	@FXML private Label noGame; // store label for no game 

	/**
	 * Initialize constructor to handle and load the user info (favorite team and player) 
	 * @throws SQLException
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public FullGameScheduleController() throws SQLException, MalformedURLException, IOException {
		username = loginModel.getUsername(); 
		favoritePlayer = loginModel.getPlayer(username); 
		favoriteTeam = loginModel.getTeam(username);
		fullSchedule = new FullGameSchedule();
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

	public void setUpNoGame(){
		noGame.setText("No game today...");
	}
	
	/**
	 * This method will take in a game and set up the stage with the appropriate 
	 * labels and images of away/ home team along with game details.
	 * @param game
	 */
	public void setUpGame(String[] game){
		String away = game[0]; // store away team  
		String home = game[1]; // store home team 
		String time = game[2] + " EST"; // store time of game
		String gameLocation = game[3];  // store location of the game 
		
		awayTeam.setText(away);
		homeTeam.setText(home);
		gameDetails.setText(time + ", " + gameLocation);
		at.setText("@"); 
		
		File imageNameHome = new File("resources/" + home + ".jpg"); 
        Image imageHome = new Image(imageNameHome.toURI().toString());
        // simple displays ImageView the image as is
        ivHome.setImage(imageHome);
        
        File imageNameAway = new File("resources/" + away + ".jpg"); 
        Image imageAway = new Image(imageNameAway.toURI().toString());
        // simple displays ImageView the image as is
        ivAway.setImage(imageAway);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		// construct the date
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date dateobj = new Date();
		String date = df.format(dateobj); // store date 
		 
		String[] game = fullSchedule.getGame(favoriteTeam, date); // load game 
		// check to see if there's a game today 
		if(game==null)
			setUpNoGame(); 
		else
			setUpGame(game); 
	
		File imageName = new File("resources/" + favoriteTeam + ".jpg"); // load background image 
        Image image = new Image(imageName.toURI().toString());
        // simple displays ImageView the image as is
        ivBack.setImage(image);
	}
}
