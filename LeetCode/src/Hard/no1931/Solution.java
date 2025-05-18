package Hard.no1931;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

	private static final int MOD = 1_000_000_007;

	public int colorTheGrid(int m, int n) {

		List<Integer> validMasks = validMasks(m);
		Map<Integer, List<Integer>> possibleMasks = possibleMasks(validMasks, m);

		Map<Integer, Integer> prev, curr = new HashMap<>();
		for (int mask : validMasks) {
			curr.put(mask, 1);
		}

		while (n-- > 1) {
			prev = curr;
			curr = new HashMap<>();
			for (int prevMask : prev.keySet()) {
				for (int currMask : possibleMasks.get(prevMask)) {
					curr.put(currMask, (curr.getOrDefault(currMask, 0) + prev.get(prevMask)) % MOD);
				}
			}
		}

		int answer = 0;
		for (int key : curr.keySet()) {
			answer = (answer + curr.get(key)) % MOD;
		}

		return answer;
	}

	private Map<Integer, List<Integer>> possibleMasks(List<Integer> validMasks, int m) {
		Map<Integer, List<Integer>> result = new HashMap<>();

		for (Integer key : validMasks) {
			result.put(key, new ArrayList<>());
			for (Integer target : validMasks) {
				if (isPossible(key, target, m)) {
					result.get(key).add(target);
				}
			}
		}

		return result;
	}

	private boolean isPossible(int key, int target, int m) {
		while (m-- > 0) {
			if (key % 3 == target % 3)
				return false;
			key /= 3;
			target /= 3;
		}
		return true;
	}

	private List<Integer> validMasks(int m) {
		List<Integer> result = new ArrayList<>();
		int end = (int) Math.pow(3, m);
		for (int v = 0; v < end; v++) {
			if (isValid(v, m))
				result.add(v);
		}
		return result;
	}

	private boolean isValid(int mask, int m) {
		int prev = -1;
		while (m-- > 0) {
			if (mask % 3 == prev)
				return false;
			prev = mask % 3;
			mask /= 3;
		}
		return true;
	}

}