package Medium.no2381;

class Solution {
	public String shiftingLetters(String s, int[][] shifts) {

		char[] word = s.toCharArray();
		int[] change = new int[word.length + 1];

		for (int[] shift : shifts) {
			int d = shift[2] == 1 ? 1 : -1;
			change[shift[0]] += d;
			change[shift[1] + 1] -= d;
		}

		int chngSum = 0;
		for (int i = 0; i < word.length; i++) {
			chngSum += change[i];
			word[i] = (char) ((word[i] - 'a' + 52000 + chngSum) % 26 + 'a');
		}

		return new String(word);
	}
}