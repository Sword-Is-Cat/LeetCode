package Easy.no3304;

class Solution {
	public char kthCharacter(int k) {
		char ans = 'a';
		k--;
		while (k > 0) {
			ans += k & 1;
			k >>= 1;
		}
		return ans;
	}
}