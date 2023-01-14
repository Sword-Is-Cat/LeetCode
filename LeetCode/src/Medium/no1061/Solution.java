package Medium.no1061;

class Solution {

	char[] charDic = new char[26];

	public String smallestEquivalentString(String s1, String s2, String baseStr) {

		for (int i = 0; i < charDic.length; i++)
			charDic[i] = (char) ('a' + i);

		char[] arr1 = s1.toCharArray(), arr2 = s2.toCharArray(), baseArr = baseStr.toCharArray();

		for (int i = 0; i < arr1.length; i++) {

			char rst1 = getChar(arr1[i]), rst2 = getChar(arr2[i]);

			if (rst1 < rst2)
				setChar(rst2, rst1);
			else
				setChar(rst1, rst2);

		}

		for (int i = 0; i < baseArr.length; i++)
			baseArr[i] = getChar(baseArr[i]);

		return new String(baseArr);
	}

	char getChar(char ch) {
		if (charDic[ch - 'a'] != ch)
			charDic[ch - 'a'] = getChar(charDic[ch - 'a']);
		return charDic[ch - 'a'];
	}

	void setChar(char idx, char val) {
		charDic[getChar(idx) - 'a'] = val;
	}
}