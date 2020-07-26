package Medium.no216;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

	List<List<Integer>> list;

	public List<List<Integer>> combinationSum3(int k, int n) {

		list = new ArrayList<>();

		Integer[] arr = new Integer[k];

		process(0, 0, arr, k, n);

		return list;

	}

	void process(int head, int index, Integer[] arr, int k, int n) {

		if (index == k) {

			int sum = 0;
			for (int i : arr) {
				sum += i;
			}
			if (sum == n) {
				Integer[] clone = arr.clone();
				list.add(Arrays.asList(clone));
			}
		} else {
			for (int i = head + 1; i < 10; i++) {

				arr[index] = i;
				process(i, index + 1, arr, k, n);
			}
		}
	}
}