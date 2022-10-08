package Medium.no16;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
	public int threeSumClosest(int[] nums, int target) {

		PriorityQueue<Integer> sums = new PriorityQueue<>((a, b) -> Math.abs(a - target) - Math.abs(b - target));

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {

			int left = i + 1, right = nums.length - 1;

			while (left < right) {

				int curSum = nums[i] + nums[left] + nums[right];
				sums.add(curSum);

				if (curSum > target) {
					right--;
				} else {
					left++;
				}

			}

		}

		return sums.peek();

	}
}