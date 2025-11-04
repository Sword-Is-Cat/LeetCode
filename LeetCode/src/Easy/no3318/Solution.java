package Easy.no3318;

class Solution {
	public int[] findXSum(int[] nums, int k, int x) {

		int max = 0;
		for (int num : nums)
			max = Math.max(num, max);

		int[] cnt = new int[max + 1];
		int[] ans = new int[nums.length - k + 1];

		for (int i = 0; i < nums.length; i++) {

			cnt[nums[i]]++;
			if (i >= k - 1) {
				ans[i - k + 1] = x_sum(cnt, x);
				cnt[nums[i - k + 1]]--;
			}
		}

		return ans;

	}

	private int x_sum(int[] cnt, int x) {
		int rst = 0;
		int[] temp = cnt.clone();
		while (x-- > 0) {
			int maxFreq = 0, val = 0;
			for (int i = 0; i < temp.length; i++) {
				if (maxFreq < temp[i]) {
					maxFreq = temp[i];
					val = i;
				} else if (maxFreq == temp[i]) {
					val = Math.max(val, i);
				}
			}
			rst += maxFreq * val;
			temp[val] = 0;
			if (maxFreq == 0)
				break;
		}

		return rst;
	}

}