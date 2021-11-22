package Medium.no1328;

class Solution {
	public String breakPalindrome(String palindrome) {

		if (palindrome.length() == 1)
			return "";

		char[] arr = palindrome.toCharArray();

		boolean flag = false;

		for (int i = 0; i < arr.length / 2; i++) {
			if (arr[i] != 'a') {
				arr[i] = 'a';
				flag = true;
				break;
			}
		}

		if (!flag) {
			arr[arr.length - 1]++;
		}

		return new String(arr);

	}
}