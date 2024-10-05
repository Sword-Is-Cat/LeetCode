package Medium.no567;

class Solution {

	public boolean checkInclusion(String s1, String s2) {

		int length = s1.length();

		int[] cnt = new int[26];
		for (char ch : s1.toCharArray()) {
			cnt[ch - 'a']++;
		}

		char[] chars = s2.toCharArray();
		int[] arr = new int[26];
		boolean answer = false;
		for (int i = 0; !answer && i < chars.length; i++) {

			arr[chars[i] - 'a']++;
			if (length <= i)
				arr[chars[i - length] - 'a']--;

			answer |= arrayEqual(cnt, arr);

		}
		return answer;
	}

	protected boolean arrayEqual(int[] arr1, int[] arr2) {
		boolean result = arr1.length == arr2.length;
		for (int i = 0; result && i < arr1.length; i++) {
			result &= arr1[i] == arr2[i];
		}
		return result;
	}
}