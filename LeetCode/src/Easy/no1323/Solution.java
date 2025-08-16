package Easy.no1323;

class Solution {
	public int maximum69Number(int num) {

		int MOD = 0, temp = 1, n = num;
		while (n > 1) {
			if (n % 10 == 6) {
				MOD = temp;
			}
			temp *= 10;
			n /= 10;
		}

		return MOD == 0 ? num : (num / (MOD * 10) * (MOD * 10) + MOD * 9 + num % MOD);
	}
}