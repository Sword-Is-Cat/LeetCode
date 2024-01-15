package Medium.no2225;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution_ {
	public List<List<Integer>> findWinners(int[][] matches) {

		ArrayList<List<Integer>> ans = new ArrayList<>();
		ans.add(new ArrayList<>());
		ans.add(new ArrayList<>());

		HashSet<Integer> lose_0 = new HashSet<>();
		HashSet<Integer> lose_1 = new HashSet<>();

		for (int i = 0; i < matches.length; i++) {
			lose_0.add(matches[i][0]);
			lose_0.add(matches[i][1]);
		}

		for (int i = 0; i < matches.length; i++) {

			int loser = matches[i][1];

			if (lose_0.contains(loser)) {
				lose_0.remove(loser);
				lose_1.add(loser);
			} else if (lose_1.contains(loser)) {
				lose_1.remove(loser);
			}
		}

		ans.get(0).addAll(lose_0);
		ans.get(0).sort((a, b) -> a - b);
		ans.get(1).addAll(lose_1);
		ans.get(1).sort((a, b) -> a - b);

		return ans;
	}
}