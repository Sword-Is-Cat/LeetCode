package Medium.no1695;

import java.util.HashSet;

class Solution {
	public int maximumUniqueSubarray(int[] nums) {

		HashSet<Integer> set = new HashSet<>();

		int from = 0, to = 0, sum = 0, rst = 0;

		while (to < nums.length) {

			if (set.contains(nums[to])) {
				int rmvNum = nums[from++];
				set.remove(rmvNum);
				sum -= rmvNum;
			} else {
				int addNum = nums[to++];
				set.add(addNum);
				sum += addNum;
				rst = Math.max(rst, sum);
			}

		}

		return rst;
	}
}