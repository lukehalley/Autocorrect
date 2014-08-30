package autocorret;

import java.util.Scanner;

public class Main {

	@SuppressWarnings("resource")
	
	public static void main(String[] args) {
		
		BruteAutocomplete brute = new BruteAutocomplete();

		// Getting user input, if the user enters upper case charcaters they are converted into lower case.
		
		System.out.println("Please Enter Your Letter:");
		Scanner userInput = new Scanner(System.in);
		String prefix = userInput.next();
		prefix = prefix.toLowerCase();
		
		// Passes prefix to matches, gives NullPointerException if an invalid entry is input by user 
		// (ie - nothing or a number etc..)
		
		if (prefix.length() >= 1) {

			System.out.println("The user prefix input was: " + prefix);
			brute.matches(prefix);
			
		} else {
			
			throw new NullPointerException("Invalid Entry!");
		}

	}

}
