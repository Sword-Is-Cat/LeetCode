package Medium.no368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public List<Integer> largestDivisibleSubset(int[] nums) {

		Arrays.sort(nums);

		int length = nums.length;
		int[][] infos = new int[2][length];

		Arrays.fill(infos[0], 1);
		Arrays.fill(infos[1], -1);

		int head = 0, maxDivs = 1;

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] % nums[j] == 0 && infos[0][i] < infos[0][j] + 1) {
					infos[0][i] = infos[0][j] + 1;
					infos[1][i] = j;
				}
			}

			if (maxDivs < infos[0][i]) {
				head = i;
				maxDivs = infos[0][i];
			}
		}

		List<Integer> ans = new ArrayList<>();

		while (head > -1) {
			ans.add(nums[head]);
			head = infos[1][head];
		}

		return ans;
	}
}