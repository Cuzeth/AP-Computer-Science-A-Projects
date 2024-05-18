import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		try (Scanner userInput = new Scanner(System.in)) {

			final User newUser = new User();
			System.out.println("// Your name is " + newUser.name + " and your PIN is " + newUser.PIN);
			System.out.println("Enter your first name and PIN code separated by a comma.");
			final String[] userInfoArr = (userInput.nextLine()).toLowerCase().replaceAll("\\s", "").split(",");

			if ((userInfoArr.length >= 3) || (userInfoArr.length < 2)) {
				throw new UserDefinedException(
						"Incorrect syntax. Please provide your first name and PIN code separated by a comma.");
			}

			if (!(newUser.name.toLowerCase().equals(userInfoArr[0]))
					|| (Integer.parseInt(userInfoArr[1]) != newUser.PIN)) {
				throw new UserDefinedException("Incorrect username or PIN.");
			}

			while (true) {
				System.out.println("Your current balance is: $" + newUser.balance + " and you have $" + newUser.wallet
						+ " in your wallet. Would you like to deposit or withdraw? (Type \"leave\" to exit.)");
				String option = (userInput.nextLine()).toLowerCase().replaceAll("\\s", "").split(",")[0];
				if (option.equals("leave")) {
					throw new UserDefinedException("Thank you for banking with X Bank. Please take your card.");
				}
				if (!(option.equals("withdraw") || option.equals("deposit"))) {
					throw new UserDefinedException("Please enter a valid option.");
				}
				System.out.println("How much would you like to " + option + "?");
				Integer amount = User.tryParse((userInput.nextLine()).replaceAll("\\s", "").split(",")[0]);

				if (amount == null) {
					throw new UserDefinedException("Please enter a valid number.");
				}

				if (amount <= 0) {
					throw new UserDefinedException("You cannot enter a negative number.");
				} else if (!newUser.checkBal(option, amount)) {
					throw new UserDefinedException(
							"You do not have a sufficient amount of money for this transaction.");
				}

				if (option.equals("withdraw")) {
					newUser.withdraw(amount);
				} else if (option.equals("deposit")) {
					newUser.deposit(amount);
				}
			}

		} catch (UserDefinedException err) {
			// System.out.println("Caught the exception");
			System.out.println(err.getMessage());
		}
	}
}