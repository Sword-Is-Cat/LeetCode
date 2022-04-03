package Hard.no410;

class Solution {
	public int splitArray(int[] nums, int m) {

		int min = 0;
		int max = 0;

		for (int no : nums) {
			min = Math.max(min, no);
			max += no;
		}

		min--;

		while (min + 1 < max) {

			int mid = (min + max) / 2;

			int cnt = cntSubArrays(nums, mid);

			if (cnt <= m)
				max = mid;
			else
				min = mid;

		}

		return max;

	}

	int cntSubArrays(int[] nums, int limit) {

		int cnt = 0;
		int sum = 0;

		for (int no : nums) {

			if (sum + no > limit) {
				cnt++;
				sum = 0;
			}

			sum += no;

		}

		cnt += sum > 0 ? 1 : 0;

		//System.out.println("cntSubArr : [limit:" + limit + ", cnt:" + cnt + "]");

		return cnt;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().splitArray(new int[] { 1, 4, 4 }, 3));
	}
}