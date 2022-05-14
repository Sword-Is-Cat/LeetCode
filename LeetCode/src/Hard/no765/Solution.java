package Hard.no765;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

	Map<Integer, Integer> seatNo = new HashMap<>();
	int[] row;
	boolean[] found;

	public int minSwapsCouples(int[] row) {

		for (int idx = 0; idx < row.length; idx++)
			seatNo.put(row[idx], idx);

		this.row = row;
		found = new boolean[row.length];

		int result = 0;

		for (int idx = 0; idx < row.length; idx++) {
			if (!found[idx])
				result += findCouple(idx);
		}

		return result;
	}

	int myCouple(int no) {
		return (no / 2) * 4 + 1 - no;
	}

	int findCouple(int idx) {

		if (found[idx])
			return 0;

		Set<Integer> set = new HashSet<>();

		while (!found[idx]) {

			found[idx] = true;
			int human = row[idx];
			set.add(human);

			int sideIdx = myCouple(idx);
			found[sideIdx] = true;
			int sideHuman = row[sideIdx];
			set.add(sideHuman);

			int sideHumanLover = myCouple(sideHuman);
			int sideHumanLoverIdx = seatNo.get(sideHumanLover);
			idx = sideHumanLoverIdx;

		}

		return set.size() / 2 - 1;
	}
}