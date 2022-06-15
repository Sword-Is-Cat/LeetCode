package Medium.no93;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

	HashMap<String, Boolean> cache = new HashMap<>();

	public List<String> restoreIpAddresses(String s) {

		List<String> ans = new ArrayList<>();
		int length = s.length();

		for (int l1 = 1; l1 < 4; l1++) {
			for (int l2 = l1 + 1; l2 < l1 + 4; l2++) {
				for (int l3 = l2 + 1; l3 < l2 + 4; l3++) {
					for (int l4 = l3 + 1; l4 < l3 + 4; l4++) {

						if (l4 == length) {
							if (isValid(s.substring(0, l1)) && isValid(s.substring(l1, l2))
									&& isValid(s.substring(l2, l3)) && isValid(s.substring(l3, l4))) {
								ans.add(s.substring(0, l1) + "." + s.substring(l1, l2) + "." + s.substring(l2, l3) + "."
										+ s.substring(l3, l4));
							}
						}
					}
				}
			}
		}

		return ans;
	}

	boolean isValid(String str) {

		if (!cache.containsKey(str)) {

			boolean result = true;
			int num = 0;

			if (str.isEmpty() || str.length() > 3)
				result = false;

			if (result) {

				num = Integer.parseInt(str);

				result &= num <= 255;
				result &= str.equals(Integer.toString(num));
			}

			cache.put(str, result);
		}

		return cache.get(str);
	}
}
