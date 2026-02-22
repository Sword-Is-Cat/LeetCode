package Easy.no868;

class Solution {
	public int binaryGap(int n) {
		int ans = 0, cnt = -100;

		while (n > 0) {
			int curr = n % 2;
			cnt++;
			if (curr == 1) {
				ans = Math.max(ans, cnt);
				cnt = 0;
			}
			n /= 2;
		}

		return ans;
	}
}