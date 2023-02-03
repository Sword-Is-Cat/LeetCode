package Medium.no6;

class Solution {
	public String convert(String s, int numRows) {

		if (numRows == 1)
			return s;

		StringBuilder[] sbArr = new StringBuilder[numRows];
		for (int i = 0; i < numRows; i++)
			sbArr[i] = new StringBuilder();

		for (int idx = 0; idx < s.length(); idx++) {

			char ch = s.charAt(idx);
			int position = idx % (numRows * 2 - 2);
			if (position >= numRows)
				position = 2 * numRows - 2 - position;

			sbArr[position].append(ch);

		}

		StringBuilder ans = new StringBuilder();

		for (int i = 0; i < sbArr.length; i++) {
			ans.append(sbArr[i]);
		}

		return ans.toString();
	}
}