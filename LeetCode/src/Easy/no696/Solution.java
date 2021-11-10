package Easy.no696;

class Solution {
	public int countBinarySubstrings(String s) {

		char[] arr = s.toCharArray();
		char last = '2';
		int cnt = 0;
		int lastCnt = 0;
		int answer = 0;

		for (char ch : arr) {
			if (ch == last)
				cnt++;
			else {
				answer += Math.min(cnt, lastCnt);
				last = ch;
				lastCnt = cnt;
				cnt = 1;
			}
		}

		answer += Math.min(cnt, lastCnt);

		return answer;
	}
}