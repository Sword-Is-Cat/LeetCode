package Medium.no2109;

class Solution {
	public String addSpaces(String s, int[] spaces) {

		char[] arr = s.toCharArray(), ans = new char[arr.length + spaces.length];

		int rIdx = arr.length - 1, wIdx = ans.length - 1, sIdx = spaces.length - 1;

		while (wIdx >= 0) {
			ans[wIdx--] = arr[rIdx];
			if (sIdx >= 0 && rIdx == spaces[sIdx]) {
				ans[wIdx--] = ' ';
				sIdx--;
			}
			rIdx--;
		}

		return new String(ans);
	}
}