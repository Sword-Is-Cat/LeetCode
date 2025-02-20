package Medium.no1980;

import java.util.HashSet;
import java.util.Set;

class Solution {
	public String findDifferentBinaryString(String[] nums) {

		Set<String> set = new HashSet<>();
		for (String num : nums) {
			set.add(num);
		}

		StringBuilder sb = new StringBuilder();
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			sb.append("0");
		}
		String prefix = sb.toString();

		for (int i = 0; i <= nums.length; i++) {
			String str = Integer.toBinaryString(i);
			str = (prefix + str).substring(str.length());
			if (set.add(str))
				return str;
		}

		return null;
	}
}