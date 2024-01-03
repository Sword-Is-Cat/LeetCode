package Medium.no2125;

class Solution {
	public int numberOfBeams(String[] bank) {

		int ans = 0, prev = 0;

		for (String security : bank) {
			
			int cnt = 0;
			for (int i = 0; i < security.length(); i++) {
				if (security.charAt(i) == '1')
					cnt++;
			}
			
			if (cnt > 0) {
				ans += prev * cnt;
				prev = cnt;
			}

		}

		return ans;
	}
}