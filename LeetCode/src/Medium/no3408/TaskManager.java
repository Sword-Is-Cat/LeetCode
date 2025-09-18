package Medium.no3408;

import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class TaskManager {

	PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
	HashMap<Integer, Integer> priMap = new HashMap<>(), userMap = new HashMap<>();

	public TaskManager(List<List<Integer>> tasks) {
		for (List<Integer> task : tasks)
			add(task.get(0), task.get(1), task.get(2));
	}

	public void add(int userId, int taskId, int priority) {
		que.offer(new int[] { priority, taskId });
		priMap.put(taskId, priority);
		userMap.put(taskId, userId);
	}

	public void edit(int taskId, int newPriority) {
		que.offer(new int[] { newPriority, taskId });
		priMap.put(taskId, newPriority);
	}

	public void rmv(int taskId) {
		priMap.put(taskId, -1);
	}

	public int execTop() {
		while (!que.isEmpty()) {
			int[] item = que.poll();
			int pri = item[0], id = item[1];
			if (pri == priMap.get(id)) {
				priMap.put(id, -1);
				return userMap.get(id);
			}
		}
		return -1;
	}
}