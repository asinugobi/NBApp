
import static org.junit.Assert.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class FileReaderv3Test {

//	private FileReaderv3 testFile;
	
//	@Before 
//	public void setupFile(){
//		testFile = new FileReaderv3("MYSPORTSFEEDS-CUMULATIVE_PLAYER_STATS-NBA-20152016REGULAR-1.csv"); 
//	}
	
	@Test
	public void test() {
		File testFile = new File("MYSPORTSFEEDS-DAILY_PLAYER_STATS-NBA-20152016REGULAR-20151028.csv"); 
		
		
		try(Scanner in = new Scanner(testFile); 
				PrintWriter out = new PrintWriter("output-test.txt"); 
				){

				while(in.hasNextLine()){
					String line = in.nextLine(); 
					out.println(line);
				}

			} catch (Exception e){
				e.printStackTrace();
			}
		
		assertNotNull("File cannot be null", testFile);
	}

}
