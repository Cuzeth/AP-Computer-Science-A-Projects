import java.util.*;

class Main {

	public static void main(String[] args) {
		int[] nums = new Random().ints(10, 0, 1000).toArray();
		int largestNum = 0;
		int largestNumIndex = 0;
		System.out.println(Arrays.toString(nums));

		for (int i = 0; i < nums.length; i++) {

			for (int x = 0; x < nums.length - i; x++) {

				if (largestNum < nums[x]) {
					largestNum = nums[x];
					largestNumIndex = x;
				}

			}

			System.out.println(largestNum);

			nums[(nums.length - i) - 1] = (nums[(nums.length - i) - 1] + nums[largestNumIndex])
					- (nums[largestNumIndex] = nums[(nums.length - i) - 1]); // https://stackoverflow.com/a/41911352

			System.out.println(Arrays.toString(nums));

			largestNum = 0;
			largestNumIndex = 0;

		}

	}

}