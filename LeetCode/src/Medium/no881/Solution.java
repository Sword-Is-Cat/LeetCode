package Medium.no881;

import java.util.Arrays;

class Solution {
	public int numRescueBoats(int[] people, int limit) {

		Arrays.sort(people);

		int left = 0, right = people.length - 1;

		while (left <= right) {

			if (people[left] + people[right--] <= limit)
				left++;

		}

		return people.length - right - 1;
	}
}