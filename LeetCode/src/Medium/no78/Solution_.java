package Medium.no78;

import java.util.ArrayList;
import java.util.List;

class Solution_ {

	List<List<Integer>> list;
	boolean[] flags;

	public List<List<Integer>> subsets(int[] nums) {

		list = new ArrayList<>();
		flags = new boolean[nums.length];

		dfs(0, nums);

		return list;
	}

	void dfs(int index, int[] nums) {

		if (index == nums.length) {
			
			List<Integer> temp = new ArrayList<>();
			
			for (int i = 0; i < nums.length; i++)
				if (flags[i])
					temp.add(nums[i]);
			
			list.add(temp);
			
		} else {
			
			flags[index] = true;
			dfs(index + 1, nums);
			flags[index] = false;
			dfs(index + 1, nums);
		}
	}
}