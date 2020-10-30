package Medium.no46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

	Integer[] arr;
	boolean[] use;
	List<List<Integer>> list;
	int targetDepth;
	int[] nums;

	public List<List<Integer>> permute(int[] nums) {

		list = new ArrayList<>();
		use = new boolean[nums.length];
		arr = new Integer[nums.length];
		targetDepth = nums.length;
		this.nums = nums;

		dfs(0);

		return list;
	}

	void dfs(int index) {

		if (index == targetDepth) {
			list.add(Arrays.asList(arr.clone()));
		} else {
			for (int i = 0; i < arr.length; i++)
				if (!use[i]) {
					use[i] = true;
					arr[index] = nums[i];
					dfs(index + 1);
					use[i] = false;
				}
		}
	}
}