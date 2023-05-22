package Medium.no347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution_ {
	public int[] topKFrequent(int[] nums, int k) {

		Map<Integer, InstantVO> map = new HashMap<>();

		for (int num : nums) {
			if (!map.containsKey(num)) {
				map.put(num, new InstantVO(num));
			}
			map.get(num).add();
		}

		Queue<InstantVO> que = new PriorityQueue<>((a, b) -> b.cnt - a.cnt);

		for (int key : map.keySet())
			que.add(map.get(key));

		int[] result = new int[k];
		int idx = 0;

		while (idx < k) {
			result[idx++] = que.poll().no;
		}

		return result;

	}
}

class InstantVO {

	int no;
	int cnt;

	InstantVO(int no) {
		this.no = no;
		this.cnt = 0;
	}

	void add() {
		cnt++;
	}

}