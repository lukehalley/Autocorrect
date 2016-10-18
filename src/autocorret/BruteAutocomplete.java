package autocorret;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BruteAutocomplete implements AutoComplete {

	private ArrayList<Term> terms = new ArrayList<Term>();

	public BruteAutocomplete() {
		loadTerms();
	}
	
	@Override
	public double weightOf(String term) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String bestMatch(String prefix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<String> matches(String prefix, int k) {
		// TODO Auto-generated method stub
		return null;
	}

	private void loadTerms() {
		
		// Scanner
		File usersFile = new File("wiktionary.txt");
		Scanner inUsers;
		try {
			inUsers = new Scanner(usersFile);

			String delims = "\t";
			// each field in the file is separated (delimited) by a space.

			inUsers.nextLine();

			while (inUsers.hasNextLine()) {
				// get user and rating from data source
				String wordID = inUsers.nextLine().trim();
				// parse user details string
				String[] wordTokens = wordID.split(delims);

				// output user data to console.
				if (wordTokens.length == 2) {
					System.out.println("Word Weight: " + wordTokens[0] + " Word: " + wordTokens[1]);
					Term t = new Term(wordTokens[1], Long.parseLong(wordTokens[0]));
					terms.add(t);
				} else {
					inUsers.close();
				}

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void findPrefix(String str) {

		for (Term t : terms) {

			if (t.getTermName().startsWith(str)) {

				System.out.println(t);
			}
			
		}
		
	}
	
}
