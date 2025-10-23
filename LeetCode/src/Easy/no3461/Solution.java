package Easy.no3461;

class Solution {
	public boolean hasSameDigits(String s) {

		int[] arr = new int[s.length()];
		for (int i = 0; i < arr.length; i++)
			arr[i] = s.charAt(i) - '0';

		for (int length = s.length() - 1; length > 1; length--) {
			for (int i = 0; i < length; i++) {
				arr[i] = (arr[i] + arr[i + 1]) % 10;
			}
		}
		return arr[0] == arr[1];
	}
}