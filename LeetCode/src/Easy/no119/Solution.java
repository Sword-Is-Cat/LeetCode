package Easy.no119;

import java.util.Arrays;
import java.util.List;

class Solution {
	public List<Integer> getRow(int rowIndex) {

		Integer[] arr = new Integer[rowIndex + 1];
		Arrays.fill(arr, 0);
		arr[rowIndex] = 1;

		while (arr[0] == 0) {
			for (int i = 0; i < arr.length - 1; i++) {
				arr[i] += arr[i + 1];
			}
		}

		return Arrays.asList(arr);
	}
}