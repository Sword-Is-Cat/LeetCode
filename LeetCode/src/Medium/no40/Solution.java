package Medium.no40;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

	List<List<Integer>> answer = new ArrayList<>();
	Map<Integer, Integer> cntMap = new HashMap<>();
	List<Integer> mapKeyList;

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {

		List<Integer> list = new ArrayList<>();

		for (int key : candidates)
			cntMap.put(key, cntMap.getOrDefault(key, 0) + 1);

		mapKeyList = new ArrayList<>(cntMap.keySet());

		process(0, 0, target, list);

		return answer;

	}

	public void process(int index, int sum, int target, List<Integer> list) {

		if (sum == target) {
			answer.add(new ArrayList<>(list));
			return;
		}

		if (sum > target || index == mapKeyList.size())
			return;

		int value = mapKeyList.get(index);
		int cnt = cntMap.get(value);

		for (int i = 0; i <= cnt; i++) {

			if (i != 0) {
				list.add(value);
				sum += value;
			}
			process(index + 1, sum, target, list);

		}

		for (int i = 0; i < cnt; i++)
			list.remove(list.size() - 1);
	}

}