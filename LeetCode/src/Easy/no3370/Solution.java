package Easy.no3370;

class Solution {
	public int smallestNumber(int n) {
		int ans = 1;
		while (n > 0) {
			n >>= 1;
			ans <<= 1;
		}
		return ans - 1;
	}
}