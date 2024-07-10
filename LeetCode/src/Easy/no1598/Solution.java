package Easy.no1598;

class Solution {
	public int minOperations(String[] logs) {

		int ans = 0;

		for (String log : logs) {

			if (log.charAt(0) == '.') {
				if (log.charAt(1) == '.') {
					ans = Math.max(0, ans - 1);
				}
			} else {
				ans++;
			}
		}

		return ans;
	}
}