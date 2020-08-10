package Easy.no599;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public String[] findRestaurant(String[] list1, String[] list2) {

		List<String> list = new ArrayList<>();
		int sum = Integer.MAX_VALUE;

		for (int i = 0; i < list1.length; i++) {
			for (int j = 0; j < list2.length; j++) {
				if (list1[i].equals(list2[j])) {
					if (sum > i + j) {
						sum = i + j;
						list.clear();
						list.add(list1[i]);
					} else if (sum == i + j)
						list.add(list1[i]);
				}
			}
		}

		String[] answer = new String[list.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}

		return answer;

	}
}