
//Luke Halley

import java.io.File;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("resource")

	public static void main(String[] args) throws Exception {
		
		//Scanner
		File usersFile = new File("wiktionary.txt");
		Scanner inUsers = new Scanner(usersFile);
		String delims = "\t"; // each field in the file is separated(delimited) by a space.

		inUsers.nextLine();

		while (inUsers.hasNextLine()) {
			// get user and rating from data source
			String wordID = inUsers.nextLine().trim();
			// parse user details string
			String[] wordTokens = wordID.split(delims);

			// output user data to console.
			if (wordTokens.length == 2) {
				System.out.println("Word Weight: " + wordTokens[0] + " Word: " + wordTokens[1]);

			} else {
				inUsers.close();
				throw new Exception("Invalid member length: " + wordTokens.length);
			}

		}

		inUsers.close();
		
		//Getting user input
		try {
			System.out.println("Please Enter Your Text:");
			Scanner userInput = new Scanner(System.in);
			String userOutput = userInput.nextLine();
			System.out.println("The user input was: " + userOutput);
			System.out.println();
			
			//Getting some words from a string that begin with t
			String s = "my very long string to test";

			for(String matchingStrings : s.split(" ")){
			    if(matchingStrings.startsWith(userOutput)){
			        System.out.println(matchingStrings);
			    }
			}
			
		} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: " + e.getMessage());

		}
		


	}

}
