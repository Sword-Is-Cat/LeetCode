package Medium.no1202;

import java.util.List;
import java.util.PriorityQueue;

class Solution {
	@SuppressWarnings("unchecked")
	public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

		char[] arr = s.toCharArray();
		Indexer idxs = new Indexer(arr.length);

		for (List<Integer> pair : pairs) {
			int a = pair.get(0), b = pair.get(1);
			idxs.link(a, b);
		}

		Object[] ques = new Object[arr.length];

		for (int i = 0; i < arr.length; i++) {
			int idx = idxs.findIdx(i);
			if (ques[idx] == null)
				ques[idx] = new PriorityQueue<>();
			((PriorityQueue<Character>) ques[idx]).add(arr[i]);
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < arr.length; i++) {
			sb.append(((PriorityQueue<Character>) ques[idxs.findIdx(i)]).poll());
		}

		return sb.toString();
	}
}

class Indexer {

	int[] idxs;

	Indexer(int length) {
		idxs = new int[length];
		for (int idx = 0; idx < length; idx++)
			idxs[idx] = idx;
	}

	void link(int a, int b) {
		idxs[findIdx(a)] = findIdx(b);
	}

	int findIdx(int a) {
		if (idxs[a] != a)
			idxs[a] = findIdx(idxs[a]);
		return idxs[a];
	}
}