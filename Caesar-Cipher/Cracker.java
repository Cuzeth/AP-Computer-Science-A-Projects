import java.util.Scanner;
import java.io.IOException;

public class Cracker {
	public static void main(Scanner scanner) {
		// Prompt user to input the encrypted text.
		System.out.println("Input encrypted text.");
		// Initialize message string from user's input.
		String message = scanner.nextLine().toLowerCase();
		// Convert every character from input to char array.
		char[] chars = message.toCharArray();

		// Start timing the process it'll take for the brute force to complete.
		long startTime = System.currentTimeMillis();

		// Start brute forcing the decryption by checking it against every key.
		for (int key = 1; key >= -25; key--) {
			// Initialize decypted message attempt.
			String newMessage = "";
			// Loop through every character from the message.
			for (char character : chars) {
				// If the character is not a letter then skip conversion.
				if (!Character.isLetter(character)) {
					newMessage += (Character.toString(character));
					continue;
				}
				// Explanation for this part is in Cipher:26.
				if (character + key < 97)
					newMessage += (Character.toString((character + key) + 26));
				else if (character + key > 122)
					newMessage += (Character.toString((character + key) - 26));
				else
					newMessage += (Character.toString(character + key));
			}

			// Turn the words from the decyption attempt into an array of strings.
			String[] words = newMessage.split("\\W+");
			// Start scanning every word against dictionary.
			for (String word : words) {
				// Try catch needed to use dictionary for some reason.
				try {
					// Initialize dictionary, no idea why you can't use it statically.
					Dictionary dict = new Dictionary();
					// If the word is not in the dictionary then mention it and skip.
					if (!dict.contains(word)) {
						System.out.println(word + " is not defined in the dictionary. Continuing...");
						continue;
					} else {
						// If the word is in the dictionary print out the entire decypted message with
						// its key value. Absolute value taken because this key is negative.
						System.out.println(
								"POSSIBLE CRACK FOUND: " + newMessage + " [KEY VALUE IS " + Math.abs(key) + "].");
					}
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
		// End process timing.
		long endTime = System.currentTimeMillis();
		// Inform user that every word has been tested.
		System.out.println("Brute force completed in " + (endTime - startTime) + "ms.");
	}
}