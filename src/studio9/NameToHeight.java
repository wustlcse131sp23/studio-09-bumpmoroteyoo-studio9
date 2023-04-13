package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class NameToHeight {
	/**
	 * Construct and fill a map with your studio group members' names, each
	 * associated with his or her height.
	 * 
	 * Construct an ArgsProcessor and loop asking the args processor for a name to
	 * lookup the height. When the user cancels (that is: when args processor
	 * returns null), break from the loop. Otherwise, loop up the name in the map
	 * and output the results. Be sure to handle the case where the map does not
	 * contain a specified name.
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		/* Map syntax:
		 * Map<key type, value type> name = new HashMap<>();
		 */
		Map<String, Double> nameToHeight = new HashMap<>();
		nameToHeight.put("William", 5.5);
		nameToHeight.put("Nic", 5.5);
		nameToHeight.put("Ella", 5.7);
		nameToHeight.put("Leslie", 5.0);
		String input = "";
		Double height = 0.0;
		// "quit" is the exit word
		while (!input.equals("quit")) {
			System.out.println("Enter a name");
			input = in.nextLine();
			height = nameToHeight.get(input);
			if (height == null) {
				System.out.println("Try again");
			}
			System.out.println(input + ": " + height);
		}

	}
}
