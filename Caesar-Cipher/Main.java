import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		// Open scanner.
		Scanner scanner = new Scanner(System.in);
		// Loop forever, give user option to stop when they want to.
		while (true) {
			// Asking for option.
			System.out.println("Press 1 for encryption/decryption. 2 for cracking. Press -1 to exit.");
			// Initialize user's option value.
			int option = Util.tryParse(scanner.nextLine());
			// Try catch in order to make sure users cannot input any other value.
			try {
				// If the option is 0, which is provided by my method, ask them to input a valid
				// number.
				if (option == 0)
					throw new InputError("Please enter a valid number.");
				// If user wants to exit then exit.
				else if (option == -1)
					break;
				// If option is out of bounds, ask them to put in a valid option.
				else if (option > 2 || option < 1)
					throw new InputError("Please enter a valid option.");
			} catch (InputError e) {
				System.out.println(e.getMessage());
			}
			// Run class main function depending on user's input.
			if (option == 1) {
				// Run normal Cipher main encryption and decryption method.
				Cipher.main(scanner);
			} else if (option == 2) {
				// Run main cracker method.
				Cracker.main(scanner);
			}
		}
		scanner.close();
	}
}