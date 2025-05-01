package Hard.no2071;

import java.util.Arrays;
import java.util.TreeMap;

class Solution {

	public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {

		Arrays.sort(tasks);
		Arrays.sort(workers);

		// left: 달성가능, right:달성불가능 수치 설정 후 이진탐색 실행
		int left = 0, right = Math.min(tasks.length, workers.length) + 1;
		while (left + 1 < right) {
			int mid = (left + right) / 2;
			if (check(tasks, workers, pills, strength, mid)) {
				left = mid;
			} else {
				right = mid;
			}
		}

		return left;
	}

	// target개의 task를 완수할 수 있는지 확인
	// tasks의 최소 target개의 element, workers의 최대 target개의 element로 판별
	private boolean check(int[] tasks, int[] workers, int pills, int strength, int target) {

		TreeMap<Integer, Integer> workerMap = new TreeMap<>();

		for (int i = 1; i <= target; i++) {
			int work = workers[workers.length - i];
			workerMap.put(work, workerMap.getOrDefault(work, 0) + 1);
		}

		while (target-- > 0) {

			int task = tasks[target];
			int currentWorker = -1;

			if (task <= workerMap.lastKey()) {
				// pill없이 task 완수 가능한 worker
				currentWorker = workerMap.lastKey();
			} else if (pills > 0 && workerMap.ceilingKey(task - strength) != null) {
				// pill사용하여 task 완수 가능한 worker
				pills--;
				currentWorker = workerMap.ceilingKey(task - strength);
			} else {
				return false;
			}

			workerMap.put(currentWorker, workerMap.get(currentWorker) - 1);
			if (workerMap.get(currentWorker) == 0)
				workerMap.remove(currentWorker);

		}

		return true;
	}

}