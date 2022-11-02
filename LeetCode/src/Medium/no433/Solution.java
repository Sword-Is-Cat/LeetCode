package Medium.no433;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
	public int minMutation(String start, String end, String[] bank) {

		if (start.equals(end))
			return 0;

		HashMap<String, HashSet<String>> linked = new HashMap<>();

		for (String key : bank)
			linked.put(key, new HashSet<>());

		for (int i = 0; i < bank.length; i++) {
			for (int j = i + 1; j < bank.length; j++) {
				if (cntDiff(bank[i], bank[j]) == 1) {
					linked.get(bank[i]).add(bank[j]);
					linked.get(bank[j]).add(bank[i]);
				}
			}
		}

		linked.put(start, new HashSet<>());

		for (String gene : bank) {
			if (cntDiff(start, gene) == 1)
				linked.get(start).add(gene);
		}

		ArrayList<HashSet<String>> list = new ArrayList<>();
		list.add(new HashSet<>());
		HashSet<String> allSet = new HashSet<>();
		list.get(0).add(start);

		while (list.get(list.size() - 1).size() > 0) {

			HashSet<String> prev = list.get(list.size() - 1);
			HashSet<String> newSet = new HashSet<>();

			for (String prevKey : prev) {

				for (String gene : linked.get(prevKey)) {
					if (allSet.add(gene))
						newSet.add(gene);
				}
			}

			if (newSet.contains(end))
				return list.size();
			else
				list.add(newSet);

		}

		return -1;
	}

	public int cntDiff(String str1, String str2) {

		int cnt = 0;

		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i))
				cnt++;
		}

		return cnt;

	}
}