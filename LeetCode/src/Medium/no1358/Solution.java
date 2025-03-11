package Medium.no1358;

class Solution {
	public int numberOfSubstrings(String s) {

		int i = 0, j = 0;
		int[] count = new int[3];
		int ans = 0;

		while (j < s.length()) {

			while (j < s.length() && count[0] * count[1] * count[2] == 0) {
				count[s.charAt(j++) - 'a']++;
			}

			if (count[0] * count[1] * count[2] > 0) {
				ans += s.length() - j + 1;
				count[s.charAt(i++) - 'a']--;
			}
		}
		
		while(count[0] * count[1] * count[2] > 0) {
			ans++;
			count[s.charAt(i++) - 'a']--;
		}

		return ans;
	}
}