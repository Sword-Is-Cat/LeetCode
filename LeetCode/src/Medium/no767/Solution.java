package Medium.no767;

import java.util.PriorityQueue;

class Solution {
	public String reorganizeString(String s) {

		char[] arr = s.toCharArray();
		Counter[] cnts = new Counter[26];
		for (int i = 0; i < 26; i++) {
			cnts[i] = new Counter((char) ('a' + i));
		}
		for (char ch : arr) {
			cnts[ch - 'a'].cnt++;
		}
		PriorityQueue<Counter> que = new PriorityQueue<>((a, b) -> b.cnt - a.cnt);
		for (Counter item : cnts) {
			if (item.cnt > 0)
				que.add(item);
		}

		int idx = 0;
		Counter prev = new Counter(' ');

		while (!que.isEmpty()) {

			Counter curr = que.poll();

			arr[idx++] = curr.ch;
			curr.cnt--;

			if (prev.cnt > 0)
				que.add(prev);

			prev = curr;

		}

		return prev.cnt > 0 ? "" : new String(arr);
	}

	class Counter {
		char ch;
		int cnt;

		Counter(char ch) {
			this.ch = ch;
			this.cnt = 0;
		}
	}
}