package Medium.no974;

class Solution {
	public int subarraysDivByK(int[] nums, int k) {

		int[] cnts = new int[k];
		cnts[0] = 1;
		int temp = 0, ans = 0;

		for (int i = 0; i < nums.length; i++) {
			temp += nums[i];
			ans += cnts[Math.floorMod(temp, k)]++;
		}
		return ans;
	}
}