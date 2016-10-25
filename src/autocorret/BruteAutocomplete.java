package autocorret;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BruteAutocomplete implements AutoComplete {

	private ArrayList<Term> termsArray = new ArrayList<Term>();

	public BruteAutocomplete() {
		loadTerms();
		weightOf("the");
		bestMatch("st");
		matches("be", 32);
	}

	// Loads all terms from wiktionary.txt, taking away the spaces and lines.
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
//					System.out.println("Word Weight: " + wordTokens[0] + " Word: " + wordTokens[1]);
					Term t = new Term(wordTokens[1], Long.parseLong(wordTokens[0]));
					termsArray.add(t);
					// collections.
				} else {
					inUsers.close();
				}

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		}

	}

	// User enters a full term and it returns it weight
	@Override
	public double weightOf(String term) {

		for (Term t : termsArray) {

			if (t.getTermName().equals(term)) {

				return t.getWeight();

			}

		}

		return 0;
	}

	// Returns the best matching term
	@Override
	public String bestMatch(String prefix) {
		String bestTerm = null;
		long bestWeight = -1;

		for (Term t : termsArray) {
			// make for loops into one
			if (t.getTermName().startsWith(prefix)) {

				if (bestWeight < t.getWeight()) {

					bestWeight = t.getWeight();
					bestTerm = t.getTermName();
				}

			}

		}

		return bestTerm;
	}

	// Returns a number of Strings with their Weights.
	@Override
	public Iterable<String> matches(String prefix, int k) {

		ArrayList<String> result = new ArrayList<>();

		for (Term t : termsArray) {
			// make for loops into one
			if (t.getTermName().startsWith(prefix) && (result.size() <= k)) {

				result.add(t.getTermName());

			}

		}

		return result;

	}

}