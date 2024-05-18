public class Util {
	public static int tryParse(String input) {
		// Try turning input into int, if invalid return -1.
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			return 0;
		}
	}
}