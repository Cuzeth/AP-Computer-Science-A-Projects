import java.util.*;

class Main {
	public static void main(String[] args) {
		// Generate a random ArrayList that is made up of 10 elements.
		ArrayList<Integer> randomArrayList = AMR.genArr(10);
		System.out.println("ORIGINAL ARRAY: " + randomArrayList.toString());
		System.out.println("MINIMUM: " + AMR.min(randomArrayList));
		System.out.println("MAXIMUM: " + AMR.max(randomArrayList));
		System.out.println("SUM: " + AMR.sum(randomArrayList));
		System.out.println("AVERAGE: " + AMR.average(randomArrayList));
		System.out.println("MODE: " + AMR.mode(randomArrayList));
		System.out.println("INDEXOF 5: " + AMR.findElement(randomArrayList, 5));
		System.out.println("ISMULTIPLE, 2: " + AMR.isMultiple(randomArrayList, 2));
		System.out.println("ISALLMULTIPLE, 2: " + AMR.isAllMultiple(randomArrayList, 2));
		System.out.println("NUMBER (AMOUNT OF NUMS DIVIS BY 2): " + AMR.number(randomArrayList, 2));
		System.out.println("DUPLICATECOUNT: " + AMR.duplicateCount(randomArrayList));
		System.out.println("COMPARE: " + AMR.convertStupidThing(AMR.compare(randomArrayList)));
		System.out.println("MOVE 5 RIGHT: " + AMR.move(randomArrayList, 5, "right").toString());
		System.out.println("MOVE 17 LEFT: " + AMR.move(randomArrayList, 17, "left").toString());
		System.out.println("REVERSE: " + AMR.reverse(randomArrayList).toString());
		System.out.println("SORT: " + AMR.insertion_sort(randomArrayList).toString());
	}
}