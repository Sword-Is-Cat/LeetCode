package Medium.no373;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

		PriorityQueue<List<Integer>> que = new PriorityQueue<>((a, b) -> listSum(b) - listSum(a));

		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				List<Integer> list = new ArrayList<>();
				list.add(nums1[i]);
				list.add(nums2[j]);

				que.add(list);
				if (que.size() > k)
					que.poll();

				if (listSum(list) > listSum(que.peek()))
					break;
			}
		}

		return new ArrayList<>(que);

	}

	private int listSum(List<Integer> list) {

		if (list == null || list.size() < 2)
			return 0;

		return list.get(0) + list.get(1);
	}

}