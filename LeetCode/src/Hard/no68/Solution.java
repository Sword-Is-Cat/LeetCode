package Hard.no68;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<String> fullJustify(String[] words, int maxWidth) {

		List<String> ans = new ArrayList<>();

		List<String> temp = new ArrayList<>();
		int tempLength = -1;

		for (String word : words) {

			if (tempLength + word.length() + 1 > maxWidth) {
				ans.add(listToString(temp, tempLength, maxWidth));
				temp.clear();
				tempLength = -1;
			}

			temp.add(word);
			tempLength += word.length() + 1;

		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < temp.size(); i++) {
			if (i > 0)
				sb.append(" ");
			sb.append(temp.get(i));
		}
		while (sb.length() < maxWidth)
			sb.append(" ");

		ans.add(sb.toString());

		return ans;
	}

	String listToString(List<String> list, int tempLength, int maxLength) {

		int size = list.size(), tabs = size - 1, length = maxLength - tempLength + tabs + tabs - 1;
		StringBuilder sb = new StringBuilder();

		if (size == 1) {
			sb.append(list.get(0));
			while (sb.length() < maxLength) {
				sb.append(" ");
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (i > 0) {
					sb.append(repeat(" ", length-- / tabs));
				}
				sb.append(list.get(i));
			}
		}

		return sb.toString();
	}

	String repeat(String str, int times) {
		StringBuilder sb = new StringBuilder();
		while (times-- > 0)
			sb.append(str);
		return sb.toString();
	}

}