package Medium.no1048;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
	public int longestStrChain(String[] words) {

		int[] chains = new int[words.length];
		HashMap<String, Integer> indexMap = new HashMap<>();

		Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));

		int ans = 0;

		for (int i = 0; i < words.length; i++) {

			String word = words[i];
			indexMap.put(word, i);

			int chain = 0;

			for (String predecessor : getPredecessors(word)) {
				if (indexMap.containsKey(predecessor)) {
					chain = Math.max(chain, chains[indexMap.get(predecessor)]);
				}
			}
			chain++;
			chains[i] = chain;
			ans = Math.max(ans, chain);
		}

		return ans;
	}

	private String[] getPredecessors(String str) {
		String[] rst = new String[str.length()];
		for (int i = 0; i < str.length(); i++) {
			rst[i] = str.substring(0, i) + str.substring(i + 1);
		}
		return rst;
	}
}