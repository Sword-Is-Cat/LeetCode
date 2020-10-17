package Medium.no18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

	List<List<Integer>> answer;
	int[] num;
	Integer[] arr;

	public List<List<Integer>> fourSum(int[] nums, int target) {

		answer = new ArrayList<>();
		arr = new Integer[4];
		Arrays.sort(nums);
		num = nums;

		process(0, -1, 0, target);

		return answer;
	}

	void process(int depth, int index, int sum, int target) {

		if (depth == 4) {
			if (sum == target)
				answer.add(Arrays.asList(arr.clone()));
			return;
		}

		int checkDupl = 1000000001;
		for (int i = index + 1; i < num.length; i++) {
			if (num[i] == checkDupl)
				continue;
			checkDupl = num[i];
			arr[depth] = num[i];
			process(depth + 1, i, sum + num[i], target);
		}
	}
}