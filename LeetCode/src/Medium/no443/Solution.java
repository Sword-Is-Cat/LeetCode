package Medium.no443;

class Solution {
	public int compress(char[] chars) {
		char prev = chars[0];
		int cnt = 1, reIdx = 1, wrIdx = 1;
		while (reIdx < chars.length) {
			char ch = chars[reIdx++];
			if (ch == prev) {
				cnt++;
			} else {
				if (cnt > 1) {
					for (char n : Integer.toString(cnt).toCharArray())
						chars[wrIdx++] = n;
				}
				cnt = 1;
				prev = ch;
				chars[wrIdx++] = ch;
			}
		}
		if (cnt > 1) {
			for (char n : Integer.toString(cnt).toCharArray())
				chars[wrIdx++] = n;
		}
		return wrIdx;
	}
}