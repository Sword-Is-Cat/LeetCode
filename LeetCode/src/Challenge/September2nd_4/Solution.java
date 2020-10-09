package Challenge.September2nd_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

	List<List<Integer>> answer;
	Integer[] arr;
	int depth;
	int target;

	public List<List<Integer>> combinationSum3(int k, int n) {

		answer = new ArrayList<>();
		arr = new Integer[k];
		depth = k;
		target = n;

		process(0, 0, 0);

		return answer;
	}

	void process(int index, int sum, int last) {
		if (sum == target)
			if (index == depth) {
				answer.add(Arrays.asList(arr.clone()));
			} else
				return;
		else if (sum > target || index == depth)
			return;
		else
			for (int i = last + 1; i < 10; i++) {
				arr[index] = i;
				process(index + 1, sum + i, i);
			}
	}
}