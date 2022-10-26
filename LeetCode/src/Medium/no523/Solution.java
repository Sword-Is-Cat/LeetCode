package Medium.no523;

import java.util.HashSet;

class Solution {
	public boolean checkSubarraySum(int[] nums, int k) {

		int[] mods = new int[nums.length + 1];
		long mod = 0;

		for (int i = 0; i < nums.length; i++) {
			mod = (mod + nums[i]) % k;
			mods[i + 1] = (int) mod;
		}

		HashSet<Integer> duplCheck = new HashSet<>();
		int temp = mods[0];

		for (int m : mods) {

			if(duplCheck.add(m)) {
				temp = m;
			}else if(temp == m) {
				temp = -1;
			}else {
				return true;
			}
		}
		return false;
	}
}