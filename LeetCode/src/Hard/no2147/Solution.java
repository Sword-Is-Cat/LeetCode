package Hard.no2147;

class Solution {
	public int numberOfWays(String corridor) {
		long ans = 1;
		int plant = 0, seat = 0, MOD = 1_000_000_007;

		for (char ch : corridor.toCharArray()) {
			if (ch == 'P') {
				plant++;
			} else {
				if (seat > 0 && seat % 2 == 0) {
					ans = ans * (plant + 1) % MOD;
				}
				seat++;
				plant = 0;
			}
		}

		if (seat % 2 == 1 || seat == 0) {
			return 0;
		}
		return (int) ans;
	}
}