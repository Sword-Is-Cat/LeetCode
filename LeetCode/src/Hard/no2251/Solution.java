package Hard.no2251;

import java.util.Arrays;

class Solution {
	public int[] fullBloomFlowers(int[][] flowers, int[] people) {

		int[] bloom = new int[flowers.length];
		int[] wither = new int[flowers.length];

		for (int i = 0; i < flowers.length; i++) {
			bloom[i] = flowers[i][0];
			wither[i] = flowers[i][1];
		}

		Arrays.sort(bloom);
		Arrays.sort(wither);

		for (int i = 0; i < people.length; i++) {
			int time = people[i];
			int bloomed = binarySearch(bloom, time, true);
			int withered = binarySearch(wither, time, false);
			people[i] = bloomed - withered;
		}

		return people;
	}

	private int binarySearch(int[] array, int target, boolean includeEQ) {
		int left = -1, right = array.length;
		while (left + 1 < right) {
			int mid = (left + right) / 2;
			if (array[mid] < target || (includeEQ && array[mid] == target))
				left = mid;
			else
				right = mid;
		}
		return left + 1;
	}
}