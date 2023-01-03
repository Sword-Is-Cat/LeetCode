package Easy.no944;

class Solution {
	public int minDeletionSize(String[] strs) {

		int ans = 0;

		for (int charIdx = 0; charIdx < strs[0].length(); charIdx++) {
			for (int strIdx = 1; strIdx < strs.length; strIdx++) {
				if (Character.compare(strs[strIdx - 1].charAt(charIdx), strs[strIdx].charAt(charIdx)) > 0) {
					ans++;
					break;
				}
			}
		}

		return ans;
	}
}