package Medium.no3133;

class Solution {
	public long minEnd(int n, int x) {

		long answer = x, nLong = n - 1;
		int i = 0;
		while (nLong > 0) {
			while (((answer >> i) & 1) == 1) {
				i++;
			}
			answer |= ((nLong & 1) << i);
			nLong >>= 1;
			i++;
		}
		return answer;
	}
}