package Challenge.October1st_1;

import java.util.ArrayList;
import java.util.List;

class Solution {

	List<List<Integer>> answer;
	List<Integer> list;
	int[] candi;
	int target;

	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		answer = new ArrayList<>();
		list = new ArrayList<>();
		candi = candidates;
		this.target = target;

		process(0, 0, 0);

		return answer;
	}

	void process(int sum, int index, int length) {

		if (sum == target) {

			List<Integer> list2 = new ArrayList<>();

			for (int i = 0; i < list.size(); i++) {
				list2.add(list.get(i));
			}
			answer.add(list2);

		} else if (sum > target) {
			return;
		} else {
			for (int i = index; i < candi.length; i++) {
				list.add(candi[i]);
				process(sum + candi[i], i, length+1);
				list.remove(length);
			}
		}
	}
}