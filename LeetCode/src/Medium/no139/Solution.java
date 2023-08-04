package Medium.no139;

import java.util.ArrayList;
import java.util.List;

class Solution {

	char[] str;
	List<char[]> dic;
	boolean[] dp;

	public boolean wordBreak(String s, List<String> wordDict) {

		str = s.toCharArray();
		dic = new ArrayList<>();
		for (String word : wordDict) {
			dic.add(word.toCharArray());
		}

		dp = new boolean[str.length + 1];
		dp[str.length] = true;

		for (int i = str.length - 1; i >= 0; i--) {
			dp[i] = checkBreakable(i);
		}

		return dp[0];
	}

	private boolean checkBreakable(int index) {

		boolean result = false;

		for (int i = 0; !result && i < dic.size(); i++) {
			char[] word = dic.get(i);
			if (index + word.length < dp.length && dp[index + word.length]) {
				result = true;
				for (int idx = 0; result && idx < word.length; idx++) {
					result &= word[idx] == str[index + idx];
				}
			}
		}

		return result;
	}
}