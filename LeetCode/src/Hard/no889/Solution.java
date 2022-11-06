package Hard.no889;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
	public String orderlyQueue(String s, int k) {

		String result = null;

		if (k == 1) {
			int length = s.length();
			s += s;
			PriorityQueue<String> que = new PriorityQueue<>();

			for (int i = 0; i < length; i++)
				que.add(s.substring(i, i + length));

			result = que.poll();

		} else {

			char[] arr = s.toCharArray();
			Arrays.sort(arr);
			result = new String(arr);
		}

		return result;
	}
}