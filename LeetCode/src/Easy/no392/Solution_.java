package Easy.no392;

class Solution_ {
	public boolean isSubsequence(String s, String t) {

		if (s.length() == 0)
			return true;

		boolean answer = false;

		char[] sArr = s.toCharArray();
		char[] tArr = t.replaceAll("[^" + s + "]", "").toCharArray();

		int i = 0;

		for (char ch : tArr) {

			if (sArr[i] == ch)
				i++;

			if (i == sArr.length) {
				answer = true;
				break;
			}
		}

		return answer;

	}
}