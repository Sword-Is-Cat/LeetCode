package Medium.no848;

class Solution {
	public String shiftingLetters(String s, int[] shifts) {

		char[] chArr = s.toCharArray();

		for (int i = 0; i < chArr.length; i++) {
			chArr[i] -= 'a';
		}

		int sum = 0;

		for (int idx = chArr.length - 1; idx >= 0; idx--) {
			sum += shifts[idx] % 26;
			chArr[idx] += sum % 26;
			chArr[idx] %= 26;
		}

		for (int i = 0; i < chArr.length; i++) {
			chArr[i] += 'a';
		}

		return new String(chArr);
	}
}