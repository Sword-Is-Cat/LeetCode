package Easy.no1903;

class Solution {
	public String largestOddNumber(String num) {
		int index = num.length();
		while (index-- > 0) {
			if ((num.charAt(index) - '0') % 2 == 1)
				break;
		}
		return num.substring(0, ++index);
	}
}