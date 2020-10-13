package Challenge.October1st_3;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public int removeCoveredIntervals(int[][] intervals) {

		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
			}
		});

		boolean[] flags = new boolean[intervals.length];

		for (int i = 0; i < intervals.length - 1; i++)
			if (!flags[i])
				for (int j = i + 1; j < intervals.length; j++)
					if (intervals[i][1] >= intervals[j][1])
						flags[j] = true;

		int answer = 0;
		for (int i = 0; i < flags.length; i++)
			if (!flags[i])
				answer++;

		return answer;
	}
}