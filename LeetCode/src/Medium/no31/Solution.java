package Medium.no31;

import java.util.Arrays;

class Solution {
	public void nextPermutation(int[] nums) {

		int index = 0;

		for (index = nums.length - 1; index > 0; index--) {
			if (nums[index - 1] < nums[index]) {
				break;
			}
		}
		System.out.println(index);
		if (index == 0) {
			Arrays.sort(nums);
			return;
		}
		index--;

		int[] subArr = Arrays.copyOfRange(nums, index, nums.length);
		int head = subArr[0];
		int cache = Integer.MAX_VALUE;

		for (int i = 0; i < subArr.length; i++) {
			if (subArr[i] > head) {
				cache = Math.min(cache, subArr[i]);
			}
		}

		Arrays.sort(subArr);
		boolean first = true;
		nums[index++] = cache;

		for (int i = 0; i < subArr.length; i++) {
			if (first && subArr[i] == cache) {
				first = false;
				continue;
			} else {
				nums[index++] = subArr[i];
			}

		}

	}

	public static void main(String[] args) {
		new Solution().nextPermutation(new int[] { 1, 2 });
	}
}