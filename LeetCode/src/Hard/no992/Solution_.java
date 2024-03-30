package Hard.no992;

class Solution_ {
	public int subarraysWithKDistinct(int[] nums, int k) {

		int answer = nums.length * (nums.length + 1) / 2;
		int left = 0, right = 0, cnt = 0;
		int[] counter = new int[nums.length + 1];

		while (left < nums.length || right < nums.length) {

			while (right < nums.length && cnt < k) {
				int addNum = nums[right++];
				if (counter[addNum]++ == 0) {
					cnt++;
				}
			}

			if (cnt < k)
				answer--;

			int rmvNum = nums[left++];
			if (--counter[rmvNum] == 0) {
				cnt--;
			}

			answer -= right - left;

		}

		left = right = cnt = 0;
		counter = new int[nums.length + 1];

		while (left < nums.length || right < nums.length) {

			while (right < nums.length && cnt <= k) {
				int addNum = nums[right++];
				if (counter[addNum]++ == 0) {
					cnt++;
				}
			}

			if (cnt > k)
				answer -= nums.length - right + 1;

			int rmvNum = nums[left++];
			if (--counter[rmvNum] == 0) {
				cnt--;
			}

		}

		return answer;
	}
}