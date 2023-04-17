package Easy.no1431;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

		List<Boolean> list = new ArrayList<>();
		int max = candies[0];

		for (int candy : candies) {
			max = Math.max(max, candy);
		}

		for (int candy : candies) {
			list.add(candy + extraCandies >= max);
		}

		return list;
	}
}