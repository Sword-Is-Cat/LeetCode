package Medium.no3147;

class Solution {
	public int maximumEnergy(int[] energy, int k) {

		int ans = Integer.MIN_VALUE;
		for (int i = energy.length - 1; i >= 0; i--) {
			if (i + k < energy.length)
				energy[i] += energy[i + k];
			ans = Math.max(ans, energy[i]);
		}
		return ans;
	}
}