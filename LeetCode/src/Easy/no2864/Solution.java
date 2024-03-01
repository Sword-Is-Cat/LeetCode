package Easy.no2864;

class Solution {
	public String maximumOddBinaryNumber(String s) {

		char[] array = s.toCharArray();
		int cntOne = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] == '1')
				cntOne++;
		}

		for (int i = 0; i < array.length; i++) {
			if (--cntOne > 0) {
				array[i] = '1';
			} else {
				array[i] = '0';
			}
		}
		array[array.length - 1] = '1';

		return new String(array);
	}
}
