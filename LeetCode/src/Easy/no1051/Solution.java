package Easy.no1051;

import java.util.Arrays;

class Solution {
	public int heightChecker(int[] heights) {

		int[] arr = heights.clone();
		Arrays.sort(arr);

		int cnt = 0;

		for (int i = 0; i < arr.length; i++)
			if (arr[i] != heights[i]) cnt++;
		
		return cnt;

	}
}