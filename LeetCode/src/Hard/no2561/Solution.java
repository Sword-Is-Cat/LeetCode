package Hard.no2561;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public long minCost(int[] basket1, int[] basket2) {

		Map<Integer, Integer> count = new HashMap<>();
		int minVal = Integer.MAX_VALUE;

		for (int fruit : basket1) {
			count.put(fruit, count.getOrDefault(fruit, 0) + 1);
			minVal = Math.min(minVal, fruit);
		}

		for (int fruit : basket2) {
			count.put(fruit, count.getOrDefault(fruit, 0) - 1);
			minVal = Math.min(minVal, fruit);
		}

		List<Integer> exchangeList = new ArrayList<>();

		for (int fruit : count.keySet()) {
			int quantity = count.get(fruit);
			if (quantity % 2 == 1)
				return -1;
			for (int i = 0; i < Math.abs(quantity / 2); i++)
				exchangeList.add(fruit);
		}

		Collections.sort(exchangeList);

		long answer = 0;
		int length = exchangeList.size();

		for (int i = 0; i < length / 2; i++) {
			answer += Math.min(2 * minVal, exchangeList.get(i));
		}

		return answer;
	}
}
