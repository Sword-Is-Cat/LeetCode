package Easy.no1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public List<List<Integer>> minimumAbsDifference(int[] arr) {

		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(arr);
		int diff = arr[arr.length - 1] - arr[0];
		for (int i = 1; i < arr.length; i++) {
			diff = Math.min(diff, arr[i] - arr[i - 1]);
		}
		for (int i = 1; i < arr.length; i++) {
			if (diff == arr[i] - arr[i - 1]) {
				List<Integer> item = new ArrayList<>();
				item.add(arr[i - 1]);
				item.add(arr[i]);
				ans.add(item);
			}
		}

		return ans;
	}
}