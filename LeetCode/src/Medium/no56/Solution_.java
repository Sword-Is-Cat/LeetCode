package Medium.no56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_ {
	public int[][] merge(int[][] intervals) {

		int beforeLeng = intervals.length;
		int afterLeng = 0;

		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < beforeLeng; i++)
			list.add(intervals[i]);

		while (beforeLeng > afterLeng) {
			beforeLeng = afterLeng;
			list = merge(list);
			afterLeng = list.size();
		}

		intervals = new int[afterLeng][];
		for (int i = 0; i < afterLeng; i++)
			intervals[i] = list.get(i);

		return intervals;
	}

	List<int[]> merge(List<int[]> list) {

		List<int[]> newList = new ArrayList<>();

		if (list.size() > 0) {

			int[] temp = list.get(0);
			newList.add(temp);

			for (int[] arr : list) {
				if (temp[1] >= arr[0])
					temp[1] = Math.max(temp[1], arr[1]);
				else {
					newList.add(arr);
					temp = arr;
				}
			}
		}

		return newList;
	}
}