package Hard.no3307;

class Solution {
	public char kthCharacter(long k, int[] operations) {

		k--;
		int cnt = 0, i = 0;

		while (k > 0) {
			cnt += operations[i++] * k & 1;
			k>>=1;
		}

		return (char) ('a' + cnt % 26);
	}

}