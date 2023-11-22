package Medium.no1424;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public int[] findDiagonalOrder(List<List<Integer>> nums) {

		List<int[]> list = new ArrayList<>();

		for (int i = 0; i < nums.size(); i++) {
			for (int j = 0; j < nums.get(i).size(); j++) {
				list.add(new int[] { i, j, nums.get(i).get(j) });
			}
		}

		list.sort((a, b) -> a[0] + a[1] - b[0] - b[1] == 0 ? (b[0] - a[0]) : (a[0] + a[1] - b[0] - b[1]));

		int[] arr = new int[list.size()];

		for (int i = 0; i < arr.length; i++)
			arr[i] = list.get(i)[2];

		return arr;

	}
}