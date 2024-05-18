import java.util.Scanner;

public class Cipher {
	public static void main(Scanner scanner) {
		// Ask user for text input.
		System.out.println("Please enter your text.");
		// Initialize Cipher message
		String message = scanner.nextLine().toLowerCase();
		// Ask user for cipher key.
		System.out.println("Please enter your key.");
		// Initialize key integer, mod 26 to make sure that the number isn't bigger than
		// 26.
		int key = Util.tryParse(scanner.nextLine()) % 26;
		// Try catch in order to make sure users cannot input any other value.
		try {
			// If the key is 0, which is provided by my method, ask them to input a valid
			// key.
			if (key == 0)
				throw new InputError("Please enter a valid number.");
		} catch (InputError e) {
			System.out.println(e.getMessage());
		}
		// Convert every character from input to char array.
		char[] chars = message.toCharArray();
		// Initialize the encrypted/decrypted message variable.
		String newMessage = "";
		// Loop through every character from the message.
		for (char character : chars) {
			// If the character is not a letter then skip conversion.
			if (!Character.isLetter(character)) {
				newMessage += (Character.toString(character));
				continue;
			}
			// This is a bit tricky:
			// If the converted character's value is smaller than 97, which is an "a", then
			// add 26 to its value.
			// If the converted character's value is greater than 122, which is a "z", then
			// remove 27 from its value.
			// If the converted character's value is within the alphabetical ASCII
			// characters, then simply convert it normally.
			// The program does this in order to make sure that normal letters do not get
			// converted to random characters.
			if (character + key < 97)
				newMessage += (Character.toString((character + key) + 26));
			else if (character + key > 122)
				newMessage += (Character.toString((character + key) - 26));
			else
				newMessage += (Character.toString(character + key));
		}
		// Print out the encrypted/decrypted message unless key is 0.
		if (!newMessage.equals(message))
			System.out.println(newMessage);
	}
}