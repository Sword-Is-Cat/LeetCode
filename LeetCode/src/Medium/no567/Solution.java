package Medium.no567;

class Solution {

	int[] cnt = new int[26];

	public boolean checkInclusion(String s1, String s2) {

		int length = s1.length();
		for (char ch : s1.toCharArray())
			cnt[ch - 'a']++;

		char[] chars = s2.toCharArray();
		int[] arr = new int[26];

		for (int i = 0; i < chars.length; i++) {

			arr[chars[i] - 'a']++;

			if (length <= i) {
				arr[chars[i - length] - 'a']--;
			}
			if (query(arr))
				return true;
		}
		return false;
	}

	protected boolean query(int[] arr) {
		boolean rst = true;
		for (int i = 0; rst && i < 26; i++) {
			rst &= cnt[i] == arr[i];
		}
		return rst;
	}
}