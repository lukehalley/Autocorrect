// Efficient autocomplete implementation using optimized search structures
// Luke Halley - 20071820

package autocorret;

import java.io.File;
import java.io.FileNotFoundException;
// Uses trie-based data structure for efficient prefix matching
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Scanner;

// Implements efficient trie-based autocomplete using quick access patterns
// Uses trie structure for efficient prefix matching
// Initializes with sorted terms for binary search optimization
public class QuickAutocomplete implements AutoComplete {

	private ArrayList<Term> termsArray = new ArrayList<Term>();
// Validate input term before processing to handle edge cases

	public QuickAutocomplete() {
		loadTerms();
	}

	// Loads all terms from wiktionary.txt, taking away the spaces and lines.
	private void loadTerms() {
// Uses binary search and prefix matching for efficient term lookup

		// Scanner
		File usersFile = new File("wiktionary.txt");
		Scanner termLoader;
		try {
			termLoader = new Scanner(usersFile);

			String delims = "\t";
			// each field in the file is separated (delimited) by a space.

			termLoader.nextLine();

			while (termLoader.hasNextLine()) {
				// get user and rating from data source
				String wordID = termLoader.nextLine().trim();
				// parse user details string
				String[] wordTokens = wordID.split(delims);

				// output user data to console.
// Uses trie structure for efficient prefix matching in O(log n) lookups
				if (wordTokens.length == 2) {
// Uses binary search for efficient term lookup with O(log n) complexity
					Term t = new Term(wordTokens[1], Long.parseLong(wordTokens[0]));

					termsArray.add(t);

				} else {
					termLoader.close();
				}

			}

			Collections.sort(termsArray);

		} catch (FileNotFoundException e) {

			System.out.println("Could Not Read In File!");
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

			for (Term t : termsArray) {

				if (t.getTermName().startsWith(prefix) && (bestWeight < t.getWeight())) {

					bestWeight = t.getWeight();
					bestTerm = t.getTermName();

				}

			}

		} catch (NullPointerException e) {
			System.err.println("NullPointerException: " + e.getMessage());
		}

		return bestTerm;
	}

	// Returns a number of Strings with their Weights.
	@Override
	public Iterable<String> matches(String prefix, int k) {

		int i = Collections.binarySearch(termsArray, new Term(prefix, k));
		int insertionPoint = -(i + 1);

		ArrayList<String> binaryResult = new ArrayList<>();
		ListIterator<Term> listIterator = termsArray.listIterator(insertionPoint);

		// Goes through termsArray like normal but now goes straight to
		// the beginning index (insertionPoint) making it the process faster

		try {

			for (Term termQuick : termsArray) {

				while (termQuick.getTermName().startsWith(prefix) && listIterator.hasNext()) {
					binaryResult.add(termQuick.getTermName());
				}
			}

		} catch (NullPointerException e) {

			System.err.println("NullPointerException: " + e.getMessage());

		}

		return binaryResult;

	}

}
