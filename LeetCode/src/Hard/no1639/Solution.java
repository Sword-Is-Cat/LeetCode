package Hard.no1639;

class Solution {

	final static int MOD = (int) Math.pow(10, 9) + 7;
	int[][] count;

	int t, w;
	Long[][] cache;
	char[] tgt;

	public int numWays(String[] words, String target) {

		t = target.length();
		w = words[0].length();
		tgt = target.toCharArray();
		count = new int[w][26];
		cache = new Long[t][w];

		for (String word : words) {
			for (int i = 0; i < w; i++) {
				count[i][word.charAt(i) - 'a']++;
			}
		}

		return (int) calculate(0, 0);
	}

	private long calculate(int ti, int wi) {

		if (ti == t)
			return 1;

		if (wi == w)
			return 0;

		if (t - ti > w - wi)
			return 0;

		if (cache[ti][wi] == null) {
			cache[ti][wi] = calculate(ti, wi + 1) + count[wi][tgt[ti] - 'a'] * calculate(ti + 1, wi + 1);
			cache[ti][wi] %= MOD;
		}

		return cache[ti][wi];

	}
}