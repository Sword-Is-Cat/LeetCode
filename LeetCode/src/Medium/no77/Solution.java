package Medium.no77;

import java.util.ArrayList;
import java.util.List;

class Solution {

	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> combine(int n, int k) {

		int[] arr = new int[k];

		append(arr, 0, 1, n);

		return result;
	}

	void append(int[] arr, int idx, int min, int max) {

		if (idx == arr.length) {
			List<Integer> list = new ArrayList<>();
			for (int no : arr)
				list.add(no);
			result.add(list);
		} else {

			for (int num = min; num <= max; num++) {
				arr[idx] = num;
				append(arr, idx + 1, num + 1, max);
			}
		}
	}
}