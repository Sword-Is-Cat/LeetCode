package Easy.no326;

class Solution {
	public boolean isPowerOfThree(int n) {

		if (n < 1)
			return false;

		int max = 1162261467;

		return max % n == 0;

	}
}