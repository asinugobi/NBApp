import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * This class will present the performance of franchise players for a specified
 * team.
 * 
 * @author Eddie
 *
 */

public class TeamStats {
	private FileDownloader dl;
	private FileReaderv3 cumu;
	private String teamName;
	private ArrayList<String> lines;
	private HashMap<String, Double> scores;
	private HashMap<String, Double> rebounds;
	private HashMap<String, Double> assists;
	private HashMap<String, Double> steals;
	private HashMap<String, Double> blocks;
	private ArrayList<String> top5Scores;
	private ArrayList<String> top5Rebounds;
	private ArrayList<String> top5Assists;
	private ArrayList<String> top5Steals;
	private ArrayList<String> top5Blocks;

	/**
	 * Constructor will read in cumulative_player_stats.csv and store it to
	 * lines for further parsing.
	 * 
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public TeamStats(String team) throws MalformedURLException, IOException {
		dl = new FileDownloader("/Users/Eddie/Documents/cit-591-projects-fall-2016-sports_feeds/resources/");
		dl.cumulativePlayers();
		cumu = new FileReaderv3("resources/cumulative_player_stats.csv");
		lines = cumu.getLines();
		teamName = team;
		blocks = new HashMap<String, Double>();
		rebounds = new HashMap<String, Double>();
		assists = new HashMap<String, Double>();
		steals = new HashMap<String, Double>();
		scores = new HashMap<String, Double>();
		top5Scores = new ArrayList<String>();
		top5Rebounds = new ArrayList<String>();
		top5Steals = new ArrayList<String>();
		top5Assists = new ArrayList<String>();
		top5Blocks = new ArrayList<String>();
		scoresGenerator();
		blocksGenerator();
		stealsGenerator();
		assistsGenerator();
		reboundsGenerator();
	}
	
	/**
	 * This method will generate top5 team players of specified category in an ArrayList
	 * @param input the HashMap for specified category of team stats
	 * @param stats	the specified Top5 category we want to generate 
	 */
	private void top5Generator(HashMap <String, Double> input, ArrayList<String> stats) {
		for (String name : input.keySet()){
			if (stats.isEmpty()) {
				stats.add(name);
			} else {
				int i = 0;
				for (String rank: stats) {
					if ( input.get(name) >= input.get(rank) ) {
						if (stats.size() < 5) {
							stats.add(i, name);
							break;
						} else {
							stats.remove(4);
							stats.add(i, name);
							break;
						}
					} 
					i++;
				}
				if (stats.size() < 5) {
					stats.add(name) ;
				}
			}
		}
		
		//		Set set = input.entrySet();
//		Iterator i = set.iterator();
//		while(i.hasNext()) {
//		         Map.Entry next = (Map.Entry)i.next();
//		         if (stats.isEmpty()) {
//		        	 stats.add(next.getKey().toString());
//		         }
//		         else if (!stats.isEmpty() && stats.size() < 5) {
//		        	 stats.add(next.getKey().toString());
//		         } else {
//		        	 for (String str: stats) {
//		        		
//		        	 }
//		         }
//		}
	}
	
	
	/**
	 * This method will generate a HashMap list storing team players and BPG.
	 */
	private void blocksGenerator() {
		for(String line: lines) {
			String[] str = line.split(",");
			if (str.length < 19) {
				continue;
			}
			else if ( str[16].equalsIgnoreCase(teamName) ) {
				blocks.put(str[3] + " " + str[2], Double.parseDouble(str[53]));
			} else if ( str[17].equalsIgnoreCase(teamName) ) {
				blocks.put(str[3] + " " + str[2], Double.parseDouble(str[54]));
			}
		}
	}
	/**
	 * This method will generate a HashMap list storing team players and PPG.
	 */
	private void scoresGenerator() {
		for(String line: lines) {
			String[] str = line.split(",");
			if (str.length < 19) {
				continue;
			} else if ( str[16].equalsIgnoreCase(teamName) ) {
				scores.put(str[3] + " " + str[2], Double.parseDouble(str[47]));
			} else if ( str[17].equalsIgnoreCase(teamName) ) {
				scores.put(str[3] + " " + str[2], Double.parseDouble(str[48]));
			}
		}
	}
	
	/**
	 * This method will generate a HashMap list storing team players and SPG.
	 */
	private void stealsGenerator() {
		for(String line: lines) {
			String[] str = line.split(",");
			if (str.length < 19) {
				continue;
			}
			else if ( str[16].equalsIgnoreCase(teamName) ) {
				steals.put(str[3] + " " + str[2], Double.parseDouble(str[51]));
			} else if ( str[17].equalsIgnoreCase(teamName) ) {
				steals.put(str[3] + " " + str[2], Double.parseDouble(str[52]));
			}
		}
	}
	
	/**
	 * This method will generate a HashMap list storing team players and APG.
	 */
	private void assistsGenerator() {
		for(String line: lines) {
			String[] str = line.split(",");
			if (str.length < 19) {
				continue;
			}
			else if ( str[16].equalsIgnoreCase(teamName) ) {
				assists.put(str[3] + " " + str[2], Double.parseDouble(str[45]));
			} else if ( str[17].equalsIgnoreCase(teamName) ) {
				assists.put(str[3] + " " + str[2], Double.parseDouble(str[46]));
			}
		}
	}
	
	/**
	 * This method will generate a HashMap list storing team players and RPG.
	 */
	private void reboundsGenerator() {
		for(String line: lines) {
			String[] str = line.split(",");
			if (str.length < 19) {
				continue;
			}
			else if ( str[16].equalsIgnoreCase(teamName) ) {
				rebounds.put(str[3] + " " + str[2], Double.parseDouble(str[43]));
			} else if ( str[17].equalsIgnoreCase(teamName) ) {
				rebounds.put(str[3] + " " + str[2], Double.parseDouble(str[44]));
			}
		}
	}
	
	/**
	 * @return the blocks
	 */
	public HashMap<String, Double> getBlocks() {
		return blocks;
	}


	/**
	 * @return the scores
	 */
	public HashMap<String, Double> getScores() {
		return scores;
	}

	/**
	 * @return the rebounds
	 */
	public HashMap<String, Double> getRebounds() {
		return rebounds;
	}

	/**
	 * @return the assists
	 */
	public HashMap<String, Double> getAssists() {
		return assists;
	}

	/**
	 * @return the steals
	 */
	public HashMap<String, Double> getSteals() {
		return steals;
	}

	/**
	 * @return the top5Scores
	 */
	public ArrayList<String> getTop5Scores() {
		top5Generator(scores, top5Scores);
		return top5Scores;
	}

	/**
	 * @return the top5Rebounds
	 */
	public ArrayList<String> getTop5Rebounds() {
		top5Generator(rebounds, top5Rebounds);
		return top5Rebounds;
	}

	/**
	 * @return the top5Assists
	 */
	public ArrayList<String> getTop5Assists() {
		top5Generator(assists, top5Assists);
		return top5Assists;
	}

	/**
	 * @return the top5Steals
	 */
	public ArrayList<String> getTop5Steals() {
		top5Generator(steals, top5Steals);
		return top5Steals;
	}

	/**
	 * @return the top5Blockss
	 */
	public ArrayList<String> getTop5Blockss() {
		top5Generator(blocks, top5Blocks);
		return top5Blocks;
	}
	
}
