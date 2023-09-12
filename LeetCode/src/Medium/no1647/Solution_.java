package Medium.no1647;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution_ {
	public int minDeletions_(String s) {

		HashMap<Character, Integer> map = new HashMap<>();

		for (char key : s.toCharArray()) {

			if (!map.containsKey(key))
				map.put(key, 1);
			else
				map.put(key, map.get(key) + 1);
		}

		PriorityQueue<Integer> que = new PriorityQueue<>();

		for (char key : map.keySet())
			que.add(map.get(key));

		boolean worked = true;
		int cnt = 0;

		while (worked) {

			worked = false;
			PriorityQueue<Integer> newQue = new PriorityQueue<>();

			int prev = 0;
			while (!que.isEmpty()) {
				int curr = que.poll();
				if (prev == curr) {
					if (curr > 1)
						newQue.add(curr - 1);
					cnt++;
					worked = true;
				} else {
					if (prev > 0)
						newQue.add(prev);
					prev = curr;
				}
			}
			if (prev > 0)
				newQue.add(prev);
			que = newQue;

		}

		return cnt;
	}

	public int minDeletions(String s) {

		HashMap<Character, Integer> map = new HashMap<>();

		for (char key : s.toCharArray()) {

			if (!map.containsKey(key))
				map.put(key, 1);
			else
				map.put(key, map.get(key) + 1);
		}

		Integer[] arr = new Integer[map.size()];

		int idx = 0;
		for (char key : map.keySet())
			arr[idx++] = map.get(key);

		Arrays.sort(arr, Comparator.reverseOrder());

		int max = arr[0];
		int cnt = 0;

		for (int i = 0; i < arr.length; i++, max--) {

			System.out.println("count:" + arr[i] + ", max:" + max);
			if (max < 0)
				max = 0;

			if (arr[i] > max) {
				cnt += arr[i] - max;
			} else {
				max = arr[i];
			}
			System.out.println("cnt:" + cnt + ", max:" + max);
		}

		return cnt;
	}
}