package Medium.no792;

import java.util.HashMap;

class Solution {

	HashMap<String, Boolean> resultCache;
	String parent;

	public int numMatchingSubseq(String s, String[] words) {

		int ans = 0;
		resultCache = new HashMap<>();
		parent = s;

		for (String word : words) {
			if (isSubstring(word))
				ans++;
		}

		return ans;
	}

	boolean isSubstring(String child) {

		if (!resultCache.containsKey(child)) {

			int pIdx = 0;
			int cIdx = 0;

			while (pIdx < parent.length() && cIdx < child.length()) {

				if (parent.charAt(pIdx++) == child.charAt(cIdx))
					cIdx++;

			}

			resultCache.put(child, cIdx == child.length());

		}

		return resultCache.get(child);
	}
}