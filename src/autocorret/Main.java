package autocorret;

import java.util.Scanner;

public class Main {

	@SuppressWarnings("resource")
	
	public static void main(String[] args) {
		
		BruteAutocomplete brute = new BruteAutocomplete();

		// Getting user input
		System.out.println("Please Enter Your Letter:");
		Scanner userInput = new Scanner(System.in);
		String str = userInput.next();

		if (str.length() > 1) {

			System.out.println("The user input was: " + str);
			brute.findPrefix(str);

		} else {

			System.out.println("The user input was: " + str);
			System.out.println("Invalid Input! Only Enter One Letter!");

		}

	}

}
