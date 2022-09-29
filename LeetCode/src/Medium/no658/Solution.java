package Medium.no658;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {

		PriorityQueue<Integer> que = new PriorityQueue<>(
				(a, b) -> Math.abs(a - x) == Math.abs(b - x) ? a - b : Math.abs(a - x) - Math.abs(b - x));

		for (int no : arr)
			que.add(no);

		List<Integer> list = new ArrayList<>();

		while (k-- > 0)
			list.add(que.poll());

		Collections.sort(list);

		return list;
	}
}