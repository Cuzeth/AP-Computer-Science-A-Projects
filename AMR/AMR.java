import java.util.*;

public class AMR {

	// Generate an ArrayList of random numbers.
	public static ArrayList<Integer> genArr(int amount) {
		ArrayList<Integer> amr = new ArrayList<Integer>();
		for (int i = 0; i < amount; i++) {
			amr.add((int) (Math.random() * 100));
		}
		return amr;
	}

	// Stupid ArrayList<int[]> is impossible to print out.
	public static String convertStupidThing(ArrayList<int[]> list) {
		String fullAmr = "[ ";
		for (int i = 0; i < 5; i++) {
			int[] tmp = list.get(i);
			String amr = "[";
			for (int j = 0; j < tmp.length; j++) {
				amr += (tmp[j]);
				if (j != tmp.length - 1)
					amr += ", ";
			}
			amr += "] ";
			fullAmr += amr;
		}
		fullAmr += "]";

		return fullAmr;
	}

	// Find the minimum value in the ArrayList and return it.
	public static int min(ArrayList<Integer> digitList) {

		// Initialize the value of the smallest number.
		int smallestNum = Integer.MAX_VALUE;

		// Loop through every element of the ArrayList, and record the smallest number.
		for (int x = 0; x < digitList.size(); x++) {

			if (smallestNum > digitList.get(x)) {
				smallestNum = digitList.get(x);
			}

		}

		return smallestNum;

	}

	// Find the maximum value in the ArrayList and return it.
	public static int max(ArrayList<Integer> digitList) {

		int largestNum = 0;

		for (int x = 0; x < digitList.size(); x++) {

			if (largestNum < digitList.get(x)) {
				largestNum = digitList.get(x);
			}

		}

		return largestNum;

	}

	// Add every element in the ArrayList and return the sum.
	public static int sum(ArrayList<Integer> digitList) {

		int sum = 0;

		for (int x = 0; x < digitList.size(); x++) {

			sum += digitList.get(x);

		}

		return sum;

	}

	// Gets the sum of all the elements then divides them by the amount.
	public static double average(ArrayList<Integer> digitList) {

		return (sum(digitList) / (double) digitList.size());

	}

	// Finds the mode.
	public static int mode(ArrayList<Integer> digitList) {

		// If no number occurs multiple times then there will be no mode.
		if (duplicateCount(digitList) == 0)
			return -1;

		int count = 0;
		int maxCount = 0;
		int maxValue = 0;

		for (int i = 0; i < digitList.size(); i++) {
			count = 0;
			for (int j = 0; j < digitList.size(); j++) {
				if (digitList.get(j) == digitList.get(i)) {
					count++;
				}
			}
			if (count > maxCount) {
				maxCount = count;
				maxValue = digitList.get(i);
			}
		}

		return maxValue;

	}

	// Returns the index of the given value. -1 if undefined.
	public static int findElement(ArrayList<Integer> digitList, int num) {

		int index = -1;

		for (int x = 0; x < digitList.size(); x++) {

			if (num == digitList.get(x)) {
				index = x;
				break;
			}

		}

		return index;

	}

	// Returns true if at least one of the numbers are divisible by the divisor.
	public static boolean isMultiple(ArrayList<Integer> digitList, int divisor) {

		boolean abuMultiple = false;

		for (int x = 0; x < digitList.size(); x++) {

			if (digitList.get(x) % divisor == 0) {
				abuMultiple = true;
				break;
			}

		}

		return abuMultiple;

	}

	// Returns true if all of the numbers are divisible by the divisor.
	public static boolean isAllMultiple(ArrayList<Integer> digitList, int divisor) {

		boolean abuMultiple = false;

		for (int x = 0; x < digitList.size(); x++) {

			if (digitList.get(x) % divisor == 0) {
				abuMultiple = true;
			} else {
				abuMultiple = false;
				break;
			}

		}

		return abuMultiple;

	}

	// Returns the count of how many elements are divisble by that number.
	public static int number(ArrayList<Integer> digitList, int divisor) {

		int count = 0;

		for (int x = 0; x < digitList.size(); x++) {
			if (digitList.get(x) % divisor == 0) {
				count++;
			}
		}

		return count;

	}

	// Converts every pair of elements into int[] and stores it into an ArrayList.
	public static ArrayList<int[]> compare(ArrayList<Integer> digitList) {
		// Access all consecutive pairs of elements
		ArrayList<int[]> newList = new ArrayList<int[]>();

		for (int i = 0; i < digitList.size(); i += 2) {
			int[] pair = { digitList.get(i), digitList.get(i + 1) };
			newList.add(pair);
		}

		return newList;

	}

	// Returns the amount of times elements are duplicated.
	public static int duplicateCount(ArrayList<Integer> digitList) {

		int duplicatedItems = 0;

		for (int x = 0; x < digitList.size(); x++) {

			for (int y = digitList.size() - 1; y > x; y--) {

				if (digitList.get(x) == digitList.get(y)) {
					duplicatedItems++;
				}

			}

		}

		return duplicatedItems;
	}

	// Shift or rotate elements left or right
	public static ArrayList<Integer> move(ArrayList<Integer> digitList, int distance, String direction) {

		ArrayList<Integer> newList = new ArrayList<Integer>(digitList);

		// If you're going right then you need to take the index and add the distance,
		// then mod it so that it doesn't go out of bounds.
		if (direction.equals("right")) {
			for (int i = 0; i < newList.size() / 2; i++) {
				Collections.swap(newList, i, (i + distance) % digitList.size());
			}
		}
		// If you're going left then you need to take the size and add the distance and
		// index, then you mod it which gives you the exact position that it should be
		// in.
		if (direction.equals("left")) {
			for (int i = 0; i < newList.size() / 2; i++) {
				Collections.swap(newList, i, (digitList.size() + distance + i) % digitList.size());
			}
		}

		return newList;

	}

	public static ArrayList<Integer> reverse(ArrayList<Integer> digitList) {
		// Reverse the order of the elements
		ArrayList<Integer> newList = new ArrayList<Integer>();
		for (int i = digitList.size() - 1; i >= 0; i--) {

			newList.add(digitList.get(i));

		}

		return newList;
	}

	public static ArrayList<Integer> insertion_sort(ArrayList<Integer> digitList) {
		// Sort the list using Insertion Sort
		ArrayList<Integer> newList = new ArrayList<Integer>(digitList);
		int largestNum = 0;
		int largestNumIndex = 0;

		for (int i = 0; i < newList.size(); i++) {

			for (int x = 0; x < newList.size() - i; x++) {

				if (largestNum < newList.get(x)) {
					largestNum = newList.get(x);
					largestNumIndex = x;
				}

			}

			Collections.swap(newList, (newList.size() - i) - 1, largestNumIndex);

			largestNum = 0;
			largestNumIndex = 0;

		}

		return newList;

	}
}

// UNUSED CODE BUT HELPFUL FOR FUTURE REFERENCE

// public static int[] isMultiple(ArrayList<Integer> digitList, int divisor) {
// ArrayList<Integer> abuMultiple = new ArrayList<Integer>();
// for (int x = 0; x < digitList.size(); x++) {
// if (digitList.get(x) % divisor == 0) {
// abuMultiple.add(digitList.get(x));
// }
// }
// return abuMultiple.stream().mapToInt(Integer::intValue).toArray();
// // https://stackoverflow.com/a/23945015
// }