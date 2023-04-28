package Hard.no839;

import java.util.HashSet;

class Solution {

	int[] uf;

	public int numSimilarGroups(String[] strs) {

		uf = new int[strs.length];
		for (int i = 0; i < uf.length; i++)
			uf[i] = i;

		for (int i = 0; i < strs.length; i++) {
			for (int j = 0; j < i; j++) {
				if (isSimilar(strs[i], strs[j])) {
					setUnion(i, j);
				}
			}
		}

		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < uf.length; i++)
			set.add(getUnion(i));

		return set.size();
	}

	private boolean isSimilar(String a, String b) {

		int diff = 0;

		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				diff++;
			}
		}
		return diff == 0 || diff == 2;
	}

	private void setUnion(int a, int b) {

		a = getUnion(a);
		b = getUnion(b);

		uf[Math.max(a, b)] = Math.min(a, b);
		System.out.println(java.util.Arrays.toString(uf));
	}

	private int getUnion(int a) {

		if (a != uf[a]) {
			uf[a] = getUnion(uf[a]);
		}
		return uf[a];

	}
}