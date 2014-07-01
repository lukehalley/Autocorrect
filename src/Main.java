import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		File usersFile = new File("wiktionary.txt");
		Scanner inUsers = new Scanner(usersFile);
		String delims = "\t";// each field in the file is separated(delimited) by a space.
		
		inUsers.nextLine();
		
		while (inUsers.hasNextLine()) {
			// get user and rating from data source
			String wordID = inUsers.nextLine().trim();
			// parse user details string
			String[] userTokens = wordID.split(delims);

			// output user data to console.
			if (userTokens.length == 2) {
				System.out.println("Word ID: " + userTokens[0] + ", Word:" + userTokens[1]);

			} else {
				inUsers.close();
				throw new Exception("Invalid member length: " + userTokens.length);
			}
		}
		inUsers.close();

	}

}
