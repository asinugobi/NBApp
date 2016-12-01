import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.net.Authenticator;
import org.apache.commons.codec.binary.Base64;

/**
 * This class will let you download requested sports feed to specified directory
 * @author Eddie
 *
 */
public class FileDownloader {
	private String src;
	private String statsName;
	private String targetDirectory;
	private String date;
	
	/**
	 * Constructor will require a targetDirectory to store the download.
	 * @param target is the directory
	 */
	public FileDownloader(String target) {
		targetDirectory = target;
	}
	
	/**
	 * This method will download Cumulative Player Stats and print out the exact place of the download
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public void cumulativePlayers() throws MalformedURLException, IOException {
		statsName = "cumulative_player_stats";
		src = "https://www.mysportsfeeds.com/api/feed/pull/nba/2016-2017-regular/"+ statsName + ".csv?";
		String fileName = statsName + ".csv";
		System.out.println(download(src, targetDirectory, fileName));
	}
	/**
	 * This method will download Full Game Schedule and print out the exact place of the download
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public void fullSchedule() throws MalformedURLException, IOException {
		statsName = "full_game_schedule";
		src = "https://www.mysportsfeeds.com/api/feed/pull/nba/2016-2017-regular/"+ statsName + ".csv?";
		String fileName = statsName + ".csv";
		System.out.println(download(src, targetDirectory, fileName));
	}
	
	/**
	 * This method will download Daily Player Stats and print out the exact place of the download
	 * @param inputDate is the date for which we are searching
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public void  dailyPlayer(String inputDate) throws MalformedURLException, IOException {
		statsName = "daily_player_stats";
		date = inputDate;
		src = "https://www.mysportsfeeds.com/api/feed/pull/nba/2016-2017-regular/"+ statsName + ".csv?fordate=" + date;
		String fileName = statsName + ".csv";
		System.out.println(download(src, targetDirectory, fileName));
	}
	
	/**
	 * This method will download Scoreboard and print out the exact place of the download
	 * @param inputDate is the date for which we are searching
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public void  scoreBoard(String inputDate) throws MalformedURLException, IOException {
		statsName = "scoreboard";
		date = inputDate;
		src = "https://www.mysportsfeeds.com/api/feed/pull/nba/2016-2017-regular/"+ statsName + ".csv?fordate=" + date;
		String fileName = statsName + ".csv";
		System.out.println(download(src, targetDirectory, fileName));
	}
	


	/**
	 *  This method will download a file from URL to specified directory,
	 *  and the desired format of the file can be specified as well.
	 * @param sourceUrl is where we request for a file
	 * @param targetDirectory is where we put the download
	 * @param targetFile is the filename for the download
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static Path download(String sourceUrl, String targetDirectory, String targetFile) 
			throws MalformedURLException, IOException
	{
		// Generate the authentication for requesting
		String name = "Eddie";
		String password = "cit591";
		String authString = name + ":" + password;
		byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
		String authStringEnc = new String(authEncBytes);
		
		// Connect to the URL and make a request for file
		URL url = new URL(sourceUrl);
		URLConnection urlConnection = url.openConnection();
		urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
		InputStream is = urlConnection.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		
		// Copy requested file to the targetDirectory with a specified format of "targetFile", ex:test.txt
		String fileName = targetFile;
		Path targetPath = new File(targetDirectory + fileName).toPath();
		Files.copy(is, targetPath, StandardCopyOption.REPLACE_EXISTING);
		

//		// This block is used to read in the file while a request successes
//				int numCharsRead;
//				char[] charArray = new char[1024];
//				StringBuffer sb = new StringBuffer();
//				while ((numCharsRead = isr.read(charArray)) > 0) {
//					sb.append(charArray, 0, numCharsRead);
//				}
//				String result = sb.toString();

		return targetPath;
	}
}
