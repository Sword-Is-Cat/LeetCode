package Medium.no491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {

	List<List<Integer>> answer = new ArrayList<>();

	public List<List<Integer>> findSubsequences(int[] nums) {

		dfs(new ArrayList<>(), nums, 0);

		return answer;
	}

	void dfs(List<Integer> list, int[] nums, int idx) {

		if (idx == nums.length)
			return;

		HashSet<Integer> duplChk = new HashSet<>();

		int size = list.size();
		int last = list.isEmpty() ? -100 : list.get(size - 1);

		for (int i = idx; i < nums.length; i++) {

			int no = nums[i];
			if (last <= no && duplChk.add(no)) {
				List<Integer> temp = new ArrayList<>(list);
				temp.add(no);
				if (size > 0)
					answer.add(temp);
				dfs(temp, nums, i + 1);
			}
		}
	}
}