package Medium.no2486;

class Solution {
	public int appendCharacters(String s, String t) {

		char[] sArr = s.toCharArray(), tArr = t.toCharArray();
		int ti = 0;

		for (int i = 0; i < sArr.length; i++) {
			if (sArr[i] == tArr[ti])
				ti++;
			if (ti == tArr.length)
				return 0;
		}

		return tArr.length - ti;
	}
}