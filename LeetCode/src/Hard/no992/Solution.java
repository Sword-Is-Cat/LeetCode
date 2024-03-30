package Hard.no992;

class Solution {
	public int subarraysWithKDistinct(int[] nums, int k) {

		return subarraysWithKorLessDistinct(nums, k) - subarraysWithKorLessDistinct(nums, k - 1);
	}

	private int subarraysWithKorLessDistinct(int[] nums, int k) {

		int answer = 0;
		int left = 0, right = 0, cnt = 0;
		int[] counter = new int[nums.length + 1];

		while (left < nums.length || right < nums.length) {

			while (right < nums.length && cnt <= k) {
				int addNum = nums[right++];
				if (counter[addNum]++ == 0) {
					cnt++;
				}
			}

			if (cnt <= k)
				answer++;

			int rmvNum = nums[left++];
			if (--counter[rmvNum] == 0) {
				cnt--;
			}

			answer += right - left;

		}

		return answer;
	}
}