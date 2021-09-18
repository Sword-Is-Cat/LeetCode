package Easy.no680;

class Solution {
	public boolean validPalindrome(String s) {

		char[] arr = s.toCharArray();

		return process(0, arr.length - 1, arr, true);

	}

	public boolean process(int left, int right, char[] arr, boolean chance) {

		while (left < right) {

			if (arr[left] == arr[right]) {
				left++;
				right--;
			} else {

				if (chance) {
					return process(left + 1, right, arr, false) || process(left, right - 1, arr, false);
				} else {
					return false;
				}

			}
		}

		return true;

	}
}