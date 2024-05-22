package Medium.no131;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<List<String>> partition(String s) {

		boolean[][] table = getBooleanTable(s);
		List<List<String>> ans = new ArrayList<>();
		dfs(ans, new ArrayList<>(), s, table, 0);
		return ans;
	}

	private void dfs(List<List<String>> ans, List<String> item, String str, boolean[][] table, int idx) {
		if (idx == str.length()) {
			ans.add(item);
		} else {
			for (int end = str.length() - 1; end >= idx; end--) {
				if (table[idx][end]) {
					List<String> next = idx == end ? item : new ArrayList<>(item);
					next.add(str.substring(idx, end + 1));
					dfs(ans, next, str, table, end + 1);
				}
			}
		}
	}

	private boolean[][] getBooleanTable(String str) {
		int length = str.length();
		boolean[][] result = new boolean[length][length];
		for (int leng = 0; leng < length; leng++) {
			for (int from = 0; from + leng < length; from++) {
				if (leng == 0) {
					result[from][from + leng] = true;
				} else if (leng == 1) {
					result[from][from + leng] = str.charAt(from) == str.charAt(from + leng);
				} else {
					result[from][from + leng] = str.charAt(from) == str.charAt(from + leng)
							&& result[from + 1][from + leng - 1];
				}
			}
		}
		return result;
	}
}