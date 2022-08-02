package Medium.no187;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
	public List<String> findRepeatedDnaSequences(String s) {

		HashSet<String> single = new HashSet<>();
		HashSet<String> dupl = new HashSet<>();

		for (int i = 0; i < s.length() - 9; i++) {

			String sub = s.substring(i, i + 10);
			System.out.println(sub);

			if (!single.add(sub))
				dupl.add(sub);
		}
		return new ArrayList<>(dupl);
	}
}