package Medium.no1846;

import java.util.Arrays;

class Solution {
	public int maximumElementAfterDecrementingAndRearranging(int[] arr) {

		Arrays.sort(arr);
		int value = 0;

		for (int no : arr) {
			if (value < no)
				value++;
		}

		return value;
	}
}