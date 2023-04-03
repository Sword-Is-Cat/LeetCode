package Medium.no881;

import java.util.Arrays;

class Solution_ {
	public int numRescueBoats(int[] people, int limit) {

		Arrays.sort(people);

		int left = 0;
		int right = people.length - 1;

		int cnt = 0;

		while (left <= right) {

			cnt++;

			if (people[left] + people[right--] <= limit) {
				left++;
			}
		}
		return cnt;
	}
}