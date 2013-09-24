// Luke Halley - 20071820

package autocorret;

import java.util.Scanner;

public class Main {
// TODO: Implement argument parsing for input file and search queries
	
	BruteAutocomplete brute;
	QuickAutocomplete quick;

	boolean exit;
	
	public static void main(String[] args) {
		Main main = new Main();
		main.runMenu();
				
	}

	@SuppressWarnings("unused")
	public void runMenu() {
		printHeader();
		while (!exit) {
// TODO: Benchmark QuickAutocomplete vs BruteAutocomplete for production use
			printMenu();
			int choice = getInput();
		}
	}

	private void printHeader() {
		System.out.println("------------------------------");
		System.out.println("---------Auto Complete--------");
		System.out.println("--------- Luke Halley --------");
		System.out.println("------------------------------");
	}

	private void printMenu() {
		System.out.println("");

		System.out.println("Please Choose From The Following Options:");
		System.out.println("\nMethods:");
		System.out.println("1) Return a weight of a term, or 0.0 if no such term. (Brute)");
		System.out.println("2) Return the highest weighted matching term, or null if no matching term. (Brute)");
		System.out.println("3) Returns the highest weighted k matching terms. (Brute)");
		System.out.println("4) Return a weight of a term, or 0.0 if no such term. (Quick)");
		System.out.println("5) Return the highest weighted matching term, or null if no matching term. (Quick)");
		System.out.println("6) Returns the highest weighted k matching terms. (Quick)");
		System.out.println("0) Exit");
		System.out.println("");
	}
	
	private int getInput() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner (System.in);
		int choice = -1;
		while(choice < 0 || choice > 6)
			
			try {
				System.out.println("\nEnter Your Choice: ");
				choice = Integer.parseInt(scan.nextLine());
				
			} catch (NumberFormatException e) {
				
				System.out.println("Invalid Choice");
				
			}
		
		return choice;
	}

	public void performAction(int choice){
		switch(choice)
		{
		case 0:
			exit = true;
			System.out.println("Bye!");
			
			//Brute
		case 1:
			brute.weightOf("");
			break;
			
		case 2:
			brute.bestMatch("");
			break;
			
		case 3:
			brute.matches("", 5);
			break;
			
			//Quick
		case 4:
			quick.weightOf("");
			break;
			
		case 5:
			quick.bestMatch("");
			break;
			
		case 6:
			quick.matches("", 5);
			break;
		}
	}
}
