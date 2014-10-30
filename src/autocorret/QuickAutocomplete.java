package autocorret;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Scanner;

public class QuickAutocomplete implements AutoComplete {

	private ArrayList<Term> termsArray = new ArrayList<Term>();

	public QuickAutocomplete() {
		loadTerms();
		weightOf("the");
		bestMatch("st");
		matches("be", 32);
	}

	// Loads all terms from wiktionary.txt, taking away the spaces and lines.
	private void loadTerms() {

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
				if (wordTokens.length == 2) {
					Term t = new Term(wordTokens[1], Long.parseLong(wordTokens[0]));

					termsArray.add(t);

				} else {
					termLoader.close();
				}

			}

			Collections.sort(termsArray);

			printArrayList(termsArray);

		} catch (FileNotFoundException e) {

			e.printStackTrace();

		}

	}

	// User enters a full term and it returns it weight
	@Override
	public double weightOf(String term) {

		long weightOfString = 0;

		for (Term t : termsArray) {

			if (t.getTermName().equals(term)) {

				weightOfString = t.getWeight();

			}

		}

		return weightOfString;
	}

	// Returns the best matching term
	@Override
	public String bestMatch(String prefix) {

		String bestTerm = null;
		long bestWeight = -1;

		for (Term t : termsArray) {

			if (t.getTermName().startsWith(prefix) && (bestWeight < t.getWeight())) {

				bestWeight = t.getWeight();
				bestTerm = t.getTermName();

			}

		}

		return bestTerm;
	}

	// Returns a number of Strings with their Weights.
	@Override
	public Iterable<String> matches(String prefix, int k) {

		int i = Collections.binarySearch(termsArray, new Term("th", -1));
		int insertionPoint = -(i + 1);

		ArrayList<String> binaryResult = new ArrayList<>();
		ListIterator<Term> it = termsArray.listIterator(insertionPoint);

		// Now we know where to start gathering the words, make a while loop
		// that makes a new array list for all
		// words that match that prefix ( get method java )

		for (Term termQuick : termsArray) {

			while (termQuick.getTermName().startsWith(prefix) && it.hasNext()) {
				binaryResult.add(termQuick.getTermName());
			}
		}

		return binaryResult;
	}

	private static void printArrayList(ArrayList<Term> termsArray) {
		System.out.println("First 250 Terms After Sorting: ");
		System.out.println("");
		for (int i = 0; i <= 250; i++) {
			System.out.println(termsArray.get(i).getTermName());
		}
	}
}
