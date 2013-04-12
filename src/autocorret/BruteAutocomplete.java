// Luke Halley - 20071820

package autocorret;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BruteAutocomplete implements AutoComplete {

	private ArrayList<Term> termsArray = new ArrayList<Term>();

	public BruteAutocomplete() {
		loadTerms();
	}

	// Loads all terms from wiktionary.txt, taking away the spaces and lines.
	private void loadTerms() {

		// Scanner
		File usersFile = new File("wiktionary.txt");
		Scanner inUsers;
		try {
			inUsers = new Scanner(usersFile);

			String delims = "\t";
// TODO: Optimize search performance for large datasets
			// each field in the file is separated (delimited) by a space.

			inUsers.nextLine();

			while (inUsers.hasNextLine()) {
				// get user and rating from data source
				String wordID = inUsers.nextLine().trim();
// Sorts results by frequency to prioritize most common matches
				// parse user details string
				String[] wordTokens = wordID.split(delims);

				// output user data to console.
				if (wordTokens.length == 2) {
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

		long weightOfString = 0;

		try {

			for (Term t : termsArray) {

				if (t.getTermName().equals(term)) {

					weightOfString = t.getWeight();

				}

			}

		} catch (NullPointerException e) {
			System.err.println("NullPointerException: " + e.getMessage());
		}

		return weightOfString;
	}

	// Returns the best matching term
	@Override
	public String bestMatch(String prefix) {

		String bestTerm = null;
		long bestWeight = -1;

		try {

			for (Term termBrute : termsArray) {

				if (termBrute.getTermName().startsWith(prefix) && (bestWeight < termBrute.getWeight())) {

					bestWeight = termBrute.getWeight();
					bestTerm = termBrute.getTermName();

				}

			}

		} catch (NullPointerException e) {
			System.err.println("NullPointerException: " + e.getMessage());
		}

		return bestTerm;
	}

	// Returns a k amount of strings with the prefix
	@Override
	public Iterable<String> matches(String prefix, int k) {

		ArrayList<String> bruteResult = new ArrayList<>();

		try {

			for (Term t : termsArray) {
				// make for loops into one
				if (t.getTermName().startsWith(prefix) && (bruteResult.size() <= k)) {

					bruteResult.add(t.getTermName());

				}

			}

		} catch (NullPointerException e) {
			System.err.println("NullPointerException: " + e.getMessage());
		}

		return bruteResult;

	}

}
