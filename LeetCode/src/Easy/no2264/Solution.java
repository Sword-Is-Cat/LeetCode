package Easy.no2264;

class Solution {
	public String largestGoodInteger(String num) {

		int loop = 10;

		while (loop-- > 0) {
			String str = strMaker(loop);
			if (num.indexOf(str) > -1)
				return str;
		}

		return "";
	}

	private String strMaker(int num) {
		return new StringBuilder().append(num).append(num).append(num).toString();
	}
}