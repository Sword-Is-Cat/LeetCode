package Easy.no1287;

import java.util.Arrays;

class Solution {
	public int findSpecialInteger(int[] arr) {

		Arrays.sort(arr);
		int cutLength = arr.length / 4;

		for (int i = 0; i + cutLength < arr.length; i++) {
			if (arr[i] == arr[i + cutLength])
				return arr[i];
		}

		return -1;
	}
}