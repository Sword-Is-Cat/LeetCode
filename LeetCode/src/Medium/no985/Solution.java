package Medium.no985;

class Solution {
	public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {

		int[] ans = new int[queries.length];
		int evenSum = 0;

		for (int num : nums) {
			if (num % 2 == 0)
				evenSum += num;
		}

		for (int i = 0; i < queries.length; i++) {

			int[] query = queries[i];
			int idx = query[1], val = query[0];

			if (nums[idx] % 2 == 0)
				evenSum -= nums[idx];

			nums[idx] += val;

			if (nums[idx] % 2 == 0)
				evenSum += nums[idx];

			ans[i] = evenSum;

		}

		return ans;
	}
}