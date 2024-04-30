package Medium.no1915;

class Solution {
	public long wonderfulSubstrings(String word) {

		int cnt[] = new int[1024];
		cnt[0] = 1;
		long ans = 0L;
		int bitmask = 0;

		for (char ch : word.toCharArray()) {

			int chIdx = ch - 'a';
			bitmask ^= 1 << chIdx;

			ans += cnt[bitmask];
			for (int i = 0; i < 10; i++) {
				ans += cnt[bitmask ^ (1 << i)];
			}

			cnt[bitmask]++;

		}

		return ans;

	}
}
