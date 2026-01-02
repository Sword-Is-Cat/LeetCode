package Easy.no961;

class Solution {
	public int repeatedNTimes(int[] nums) {
		boolean[] flags = new boolean[10001];
		for (int num : nums) {
			if (flags[num])
				return num;
			flags[num] = true;
		}
		return -1;
	}
}