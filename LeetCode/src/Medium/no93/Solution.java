package Medium.no93;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

	HashMap<String, Boolean> cache = new HashMap<>();
	int length;

	public List<String> restoreIpAddresses(String s) {

		List<String> ans = new ArrayList<>();
		length = s.length();

		for (int l1 = 1; l1 < 4; l1++) {
			for (int l2 = l1 + 1; l2 < l1 + 4; l2++) {
				for (int l3 = l2 + 1; l3 < l2 + 4; l3++) {
					for (int l4 = l3 + 1; l4 < l3 + 4; l4++) {

						String str = query(l1, l2, l3, l4, s);
						if (str != null)
							ans.add(str);
					}
				}
			}
		}

		return ans;
	}

	protected String query(int l1, int l2, int l3, int l4, String s) {

		if (l4 != length)
			return null;

		String s1 = s.substring(0, l1), s2 = s.substring(l1, l2), s3 = s.substring(l2, l3), s4 = s.substring(l3);
		if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
			return new StringBuilder().append(s1).append('.').append(s2).append('.').append(s3).append('.').append(s4)
					.toString();
		}

		return null;

	}

	protected Boolean isValid(String str) {
		if (!cache.containsKey(str)) {
			int no = Integer.parseInt(str);
			cache.put(str, str.equals(Integer.toString(no)) && no < 256);
		}
		return cache.get(str);
	}
}