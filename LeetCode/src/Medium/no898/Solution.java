package Medium.no898;

import java.util.HashSet;

class Solution {
	public int subarrayBitwiseORs(int[] arr) {

		HashSet<Integer> answer = new HashSet<>(), prev, curr = new HashSet<>();

		for (int num : arr) {
			prev = curr;
			curr = new HashSet<>();
			for (int p : prev) {
				curr.add(num | p);
			}
			curr.add(num);
			answer.addAll(curr);
		}

		return answer.size();
	}
}