public class User {
	private String[] names = { "Amr", "Josh", "Bob", "Fred", "Jerry", "John", "Terry", "Jake", "Ahmad", "Tommy" };
	String name;
	int PIN;
	int balance;
	int wallet;

	public User() {
		this.name = names[(int) (Math.random() * names.length)];
		this.PIN = (int) (Math.random() * 10000);
		this.balance = (int) (Math.random() * 1000);
		this.wallet = (int) (Math.random() * 1000);
	}

	public boolean checkBal(String type, int amount) {

		if (type.equals("withdraw") && (amount > this.balance)) {
			return false;
		} else if (type.equals("withdraw") && (amount <= this.balance)) {
			return true;
		} else if (type.equals("deposit") && (amount > this.wallet)) {
			return false;
		} else if (type.equals("deposit") && (amount <= this.wallet)) {
			return true;
		}

		return false;

	}

	public void deposit(int amount) {
		this.wallet -= amount;
		this.balance += amount;
	}

	public void withdraw(int amount) {
		this.wallet += amount;
		this.balance -= amount;
	}

	public static Integer tryParse(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			return null;
		}
	}
	// https://stackoverflow.com/questions/1486077/good-way-to-encapsulate-integer-parseint
}