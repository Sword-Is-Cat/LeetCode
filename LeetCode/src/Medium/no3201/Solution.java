package Medium.no3201;

class Solution {
	public int maximumLength(int[] nums) {

		int[] row = new int[2], flip = new int[2];
		for (int num : nums) {
			int p = num & 1;
			row[p]++;
			flip[p] = flip[p ^ 1] + 1;
		}

		return Math.max(Math.max(row[0], row[1]), Math.max(flip[0], flip[1]));

	}
}