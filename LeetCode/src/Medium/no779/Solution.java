package Medium.no779;

class Solution {
	public int kthGrammar(int n, int k) {
		k--;
		int ans = 0;
		while (k > 0) {
			ans ^= k % 2;
			k >>= 1;
		}
		return ans;
	}
}