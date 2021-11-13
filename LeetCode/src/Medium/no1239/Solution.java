package Medium.no1239;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

	int answer = 0;
	List<String> arr;

	public int maxLength(List<String> arr) {

		this.arr = arr;
		Set<Character> set = new HashSet<>();

		proc(set, 0);

		return answer;
	}

	public void proc(Set<Character> set, int index) {

		if (index == arr.size()) {
			answer = Math.max(answer, set.size());
			return;
		}

		proc(new HashSet<Character>(set), index + 1);

		String str = arr.get(index);

		if (check(set, str)) {

			for (int i = 0; i < str.length(); i++)
				set.add(str.charAt(i));

			proc(new HashSet<Character>(set), index + 1);

		}

	}

	public boolean check(Set<Character> set, String str) {

		Set<Character> temp = new HashSet<>();

		for (int i = 0; i < str.length(); i++) {

			if (!temp.add(str.charAt(i)))
				return false;

			if (set.contains(str.charAt(i)))
				return false;
		}

		return true;

	}

}