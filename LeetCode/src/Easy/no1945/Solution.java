package Easy.no1945;

class Solution {
	public int getLucky(String s, int k) {

		int sum = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int val = ch - 'a' + 1;
			while (val > 0) {
				sum += val % 10;
				val /= 10;
			}
		}

		while (k-- > 1) {
			int temp = 0;
			while (sum > 0) {
				temp += sum % 10;
				sum /= 10;
			}
			sum = temp;
		}

		return sum;
	}
}