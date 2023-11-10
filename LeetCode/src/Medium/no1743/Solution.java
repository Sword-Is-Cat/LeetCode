package Medium.no1743;

import java.util.HashMap;
import java.util.Map;

class Solution {

	final int void_value = Integer.MIN_VALUE;
	Map<Integer, int[]> data;

	public int[] restoreArray(int[][] adjacentPairs) {

		data = processDatas(adjacentPairs);
		int[] ans = new int[adjacentPairs.length + 1];

		int prev = void_value, curr = getFirstItem(), next;

		ans[0] = curr;

		for (int i = 1; i < ans.length; i++) {
			next = findNextValue(prev, curr);
			ans[i] = next;
			prev = curr;
			curr = next;
		}

		return ans;
	}

	private Map<Integer, int[]> processDatas(int[][] connections) {

		Map<Integer, int[]> result = new HashMap<>();

		for (int[] connection : connections) {

			int value1 = connection[0], value2 = connection[1];

			if (result.containsKey(value1)) {
				result.get(value1)[1] = value2;
			} else {
				result.put(value1, new int[] { value2, void_value });
			}

			if (result.containsKey(value2)) {
				result.get(value2)[1] = value1;
			} else {
				result.put(value2, new int[] { value1, void_value });
			}
		}
		return result;
	}

	private int getFirstItem() {

		for (int key : data.keySet()) {
			if (data.get(key)[1] == void_value)
				return key;
		}
		return void_value;
	}

	private int findNextValue(int prev, int curr) {
		int[] pair = data.get(curr);
		return prev == pair[0] ? pair[1] : pair[0];
	}
}