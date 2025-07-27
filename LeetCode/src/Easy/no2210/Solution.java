package Easy.no2210;

class Solution {
	public int countHillValley(int[] nums) {

		int prev = nums[0], prevC = 0, cnt = 0;
		for (int num : nums) {
			int c = Integer.compare(prev, num);
			if (c == 0)
				continue;
			if (prevC * c == -1)
				cnt++;
			prev = num;
			prevC = c;
		}

		return cnt;
	}
}