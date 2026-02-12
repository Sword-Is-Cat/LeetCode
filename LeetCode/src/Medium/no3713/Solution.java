package Medium.no3713;

class Solution {
	public int longestBalanced(String s) {
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			int[] cnts = new int[26];
			for (int j = i; j < s.length(); j++) {
				int alph = s.charAt(j) - 'a';
				cnts[alph]++;
				if (isBalanced(cnts, cnts[alph])) {
					ans = Math.max(ans, j - i + 1);
				}
			}
		}
		return ans;
	}

	private boolean isBalanced(int[] cnts, int cnt) {
		for (int i = 0; i < cnts.length; i++) {
			if (cnts[i] != cnt && cnts[i] != 0) {
				return false;
			}
		}
		return true;
	}
}