package Medium.no1268;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

	List<List<String>> ans;

	public List<List<String>> suggestedProducts(String[] products, String searchWord) {

		Arrays.sort(products);
		ans = new ArrayList<>();

		for (int idx = 0; idx < searchWord.length(); idx++) {

			List<String> list = new ArrayList<>();
			String key = searchWord.substring(0, idx + 1);

			for (String word : idx == 0 ? Arrays.asList(products) : ans.get(idx - 1)) {
				if (word.indexOf(key) == 0)
					list.add(word);
			}
			ans.add(list);
		}

		for (int i = 0; i < ans.size(); i++) {
			if (ans.get(i).size() > 3) {
				ans.set(i, ans.get(i).subList(0, 3));
			}
		}

		return ans;
	}
}