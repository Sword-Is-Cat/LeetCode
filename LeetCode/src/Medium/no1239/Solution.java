package Medium.no1239;

import java.util.List;

class Solution {
	public int maxLength(List<String> arr) {

		return dfs(arr, new int[26], 0);
	}

	private int dfs(List<String> arr, int[] counter, int index) {
		if (index == arr.size())
			return countLength(counter);
		String str = arr.get(index);
		int result = dfs(arr, counter, index + 1);
		for (int i = 0; i < str.length(); i++) {
			counter[str.charAt(i) - 'a']++;
		}
		result = Math.max(result, dfs(arr, counter, index + 1));
		for (int i = 0; i < str.length(); i++) {
			counter[str.charAt(i) - 'a']--;
		}
		return result;
	}

	private int countLength(int[] counter) {
		int result = 0;
		for (int val : counter) {
			if (val > 1)
				return -1;
			result += val;
		}
		return result;
	}
}