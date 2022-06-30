package Medium.no406;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
	public int[][] reconstructQueue(int[][] people) {

		Arrays.sort(people, (a, b) -> b[0] == a[0] ? a[1] - b[1] : b[0] - a[0]);
		ArrayList<int[]> list = new ArrayList<>();

		for (int[] man : people) 
			list.add(man[1], man);

		int[][] ans = new int[people.length][];

		for (int idx = 0; idx < people.length; idx++)
			ans[idx] = list.get(idx);

		return ans;
	}
}