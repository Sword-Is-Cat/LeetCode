package Easy.no500;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public String[] findWords(String[] words) {

		List<String> list = new ArrayList<>();

		for (String str : words) {

			int length = str.length();

			int length1 = str.toLowerCase().replaceAll("[qwertyuiop]", "").length();
			int length2 = str.toLowerCase().replaceAll("[asdfghjkl]", "").length();
			int length3 = str.toLowerCase().replaceAll("[zxcvbnm]", "").length();
			if (length1 == length || length1 == 0)
				if (length2 == length || length2 == 0)
					if (length3 == length || length3 == 0)
						list.add(str);
		}

		String[] answer = new String[list.size()];

		for (int i = 0; i < answer.length; i++)
			answer[i] = list.get(i);

		return answer;

	}
}