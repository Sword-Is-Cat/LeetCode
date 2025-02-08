package Medium.no2349;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

class NumberContainers {

	HashMap<Integer, int[]> indexMap;
	HashMap<Integer, Queue<int[]>> numberMap;

	public NumberContainers() {
		indexMap = new HashMap<Integer, int[]>();
		numberMap = new HashMap<Integer, Queue<int[]>>();
	}

	public void change(int index, int number) {
		if (!indexMap.containsKey(index))
			indexMap.put(index, new int[] { index, number });
		indexMap.get(index)[1] = number;
		if (!numberMap.containsKey(number))
			numberMap.put(number, new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0])));
		numberMap.get(number).offer(indexMap.get(index));
	}

	public int find(int number) {

		if (!numberMap.containsKey(number))
			return -1;

		Queue<int[]> que = numberMap.get(number);
		while (!que.isEmpty() && que.peek()[1] != number)
			que.poll();
		return que.isEmpty() ? -1 : que.peek()[0];

	}
}