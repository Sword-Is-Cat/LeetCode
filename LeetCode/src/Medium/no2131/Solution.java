package Medium.no2131;

import java.util.HashMap;
import java.util.HashSet;

class Solution {
	public int longestPalindrome(String[] words) {

		HashMap<String, Integer> counter = new HashMap<>();

		for (String word : words) {
			if (!counter.containsKey(word))
				counter.put(word, 0);
			counter.put(word, counter.get(word) + 1);
		}

		int cntPair = 0, cntDblPalin = 0;
		boolean singlePalin = false;
		HashSet<String> worked = new HashSet<>();

		for (String word : counter.keySet()) {

			if (worked.contains(word))
				continue;

			if (isPalin(word)) {

				int cnt = counter.get(word);
				cntDblPalin += cnt / 2;
				singlePalin |= cnt % 2 == 1;

			} else {

				String rev = reverseString(word);
				if (counter.containsKey(rev)) {

					cntPair += Math.min(counter.get(word), counter.get(rev));
					worked.add(rev);

				}
			}
		}

		return cntPair * 4 + cntDblPalin * 4 + (singlePalin ? 2 : 0);
	}

	public boolean isPalin(String str) {
		return str.charAt(0) == str.charAt(1);
	}

	public String reverseString(String str) {
		return new StringBuilder(str).reverse().toString();
	}
}