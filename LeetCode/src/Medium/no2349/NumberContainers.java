package Medium.no2349;

import java.util.HashMap;
import java.util.PriorityQueue;

class NumberContainers {

	HashMap<Integer, Integer> idxVal;
	HashMap<Integer, PriorityQueue<Integer>> valIdxQ;

	public NumberContainers() {
		idxVal = new HashMap<Integer, Integer>();
		valIdxQ = new HashMap<Integer, PriorityQueue<Integer>>();
	}

	public void change(int index, int number) {
		idxVal.put(index, number);
		if (!valIdxQ.containsKey(number))
			valIdxQ.put(number, new PriorityQueue<>());
		valIdxQ.get(number).add(index);
	}

	public int find(int number) {

		if (valIdxQ.containsKey(number)) {

			PriorityQueue<Integer> que = valIdxQ.get(number);

			while (!que.isEmpty()) {

				int i = que.peek();
				int val = idxVal.get(i);
				if (number == val)
					return i;
				else
					que.poll();

			}
			return -1;

		} else
			return -1;
	}
}