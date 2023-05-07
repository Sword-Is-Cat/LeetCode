package Hard.no1964;

class Solution {
	public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {

		int length = obstacles.length;

		int[] dp = new int[length];
		int[] ans = new int[length];

		int dpLength = 0;

		for (int i = 0; i < length; i++) {
			int idx = binarySearch(dp, obstacles[i], dpLength - 1);

			dp[idx] = obstacles[i];

			if (idx == dpLength)
				dpLength++;

			ans[i] = idx + 1;

		}

		return ans;
	}

	private int binarySearch(int[] arr, int target, int right) {

		int left = 0;

		while (left <= right) {

			int mid = (left + right) / 2;

			if (target < arr[mid])
				right = mid - 1;
			else
				left = mid + 1;

		}
		return left;
	}
}