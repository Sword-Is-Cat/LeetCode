package Hard.no214;

class Solution {
	public String shortestPalindrome(String s) {

		if (s.length() < 2)
			return s;

		int startIdx = s.length() / 2;
		int left, right;
		boolean flag = true;

		while (startIdx >= 0) {

//			System.out.println("idx:" + startIdx + ", char:" + s.charAt(startIdx));
//			System.out.println("case1");

			left = right = startIdx;
			flag = true;
			if (left <= s.length() - right - 1) {
				while (flag && left >= 0) {
//					System.out.println("left:"+s.charAt(left)+", right:"+s.charAt(right));
					flag &= s.charAt(left--) == s.charAt(right++);
				}
				if (flag)
					return new StringBuilder().append(s.substring(startIdx)).reverse().append(s.substring(startIdx + 1))
							.toString();
			}
//			System.out.println("case2");

			left = right = startIdx;
			left--;
			flag = true;
			if (left <= s.length() - right - 1) {
				while (flag && left >= 0) {
//					System.out.println("left:"+s.charAt(left)+", right:"+s.charAt(right));
					flag &= s.charAt(left--) == s.charAt(right++);
				}
				if (flag)
					return new StringBuilder().append(s.substring(startIdx)).reverse().append(s.substring(startIdx))
							.toString();
			}

			startIdx--;
		}

		return null;

	}
}