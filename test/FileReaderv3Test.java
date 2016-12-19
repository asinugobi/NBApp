
import static org.junit.Assert.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

/**
 * This class test if the FileReaderv3 can read in data from specified file.
 * @author Eddie
 *
 */
public class FileReaderv3Test {
	
	private FileReaderv3 test;
	
	@Before
	public void setUpFileReader() {
		test = new FileReaderv3("resources/cumulative_player_stats.csv") ;
	}
	
	@Test
	public void testReadFile() {
		ArrayList<String> lines = test.getLines();
		assertNotNull("Lines cannot be null, the FileReader should read in some data", lines);
	}
	
	@Test
	public void testReadIn() {
		File testFile = new File("resources/cumulative_player_stats.csv"); 	
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
