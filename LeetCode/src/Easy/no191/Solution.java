package Easy.no191;

public class Solution {
	public int hammingWeight(int n) {

		int loop = 32, ans = 0;

		while (loop-- > 0) {
			ans += n & 1;
			n >>= 1;
		}
		return ans;
	}
}