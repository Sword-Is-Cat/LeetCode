package Easy.no2206;

class Solution {
	public boolean divideArray(int[] nums) {

		boolean[] oddCount = new boolean[501];
		for (int num : nums) {
			oddCount[num] ^= true;
		}

		for (int i = 0; i < oddCount.length; i++) {
			if (oddCount[i])
				return false;
		}

		return true;
	}
}