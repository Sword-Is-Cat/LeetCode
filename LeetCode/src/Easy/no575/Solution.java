package Easy.no575;

import java.util.HashSet;
import java.util.Set;

class Solution {
	public int distributeCandies(int[] candies) {

		int length = candies.length;

		Set<Integer> set = new HashSet<>();

		for (int i : candies)
			set.add(i);

		int length2 = set.size();

		length = length / 2;

		return length > length2 ? length2 : length;

	}
}