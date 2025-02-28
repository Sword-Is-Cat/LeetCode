package Hard.no1092;

class Solution {
	public String shortestCommonSupersequence(String str1, String str2) {

		String subsequence = longestSubsequence(str1, str2);
		int idx1 = 0, idx2 = 0, idx3 = 0;

		StringBuilder answer = new StringBuilder();

		while (idx1 < str1.length() || idx2 < str2.length()) {

			if (idx3 < subsequence.length()) {
				while (str1.charAt(idx1) != subsequence.charAt(idx3)) {
					answer.append(str1.charAt(idx1++));
				}
				while (str2.charAt(idx2) != subsequence.charAt(idx3)) {
					answer.append(str2.charAt(idx2++));
				}
				answer.append(subsequence.charAt(idx3++));
				idx1++;
				idx2++;
			} else {
				answer.append(str1.substring(idx1));
				answer.append(str2.substring(idx2));
				idx1 = str1.length();
				idx2 = str2.length();
			}

		}

		return answer.toString();
	}

	public String longestSubsequence(String str1, String str2) {

		return longestSubsequenceProcess(str1, str2, 0, 0, new String[str1.length()][str2.length()]);
	}

	public String longestSubsequenceProcess(String str1, String str2, int idx1, int idx2, String[][] dp) {

		if (str1.length() == idx1 || str2.length() == idx2)
			return "";

		if (dp[idx1][idx2] == null) {

			if (str1.charAt(idx1) == str2.charAt(idx2)) {
				dp[idx1][idx2] = str1.charAt(idx1) + longestSubsequenceProcess(str1, str2, idx1 + 1, idx2 + 1, dp);
			} else {
				String subseq1 = longestSubsequenceProcess(str1, str2, idx1 + 1, idx2, dp);
				String subseq2 = longestSubsequenceProcess(str1, str2, idx1, idx2 + 1, dp);
				dp[idx1][idx2] = subseq1.length() > subseq2.length() ? subseq1 : subseq2;
			}

		}
		return dp[idx1][idx2];

	}
}