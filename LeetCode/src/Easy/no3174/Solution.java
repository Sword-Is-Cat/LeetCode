package Easy.no3174;

import java.util.Arrays;

class Solution {
	public String clearDigits(String s) {

		char[] arr = s.toCharArray();
		int cursor = 0;
		for (int i = 0; i < arr.length; i++) {
			if ('0' <= arr[i] && arr[i] <= '9') {
				cursor--;
			} else {
				arr[cursor++] = arr[i];
			}
		}

		return new String(Arrays.copyOfRange(arr, 0, cursor));

	}
}