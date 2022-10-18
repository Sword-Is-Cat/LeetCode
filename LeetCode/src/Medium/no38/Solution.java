package Medium.no38;

class Solution {
	public String countAndSay(int n) {
		String[] arr = new String[n];
		arr[0] = "1";

		for (int i = 1; i < arr.length; i++) {
			arr[i] = saying(arr[i - 1]);
		}

		return arr[arr.length - 1];
	}

	String saying(String str) {

		char prev = str.charAt(0);
		int cnt = 0;
		StringBuilder sb = new StringBuilder();

		for (char ch : str.toCharArray()) {

			if (prev == ch) {
				cnt++;
			} else {

				sb.append(cnt);
				sb.append(prev);

				prev = ch;
				cnt = 1;

			}
		}
		sb.append(cnt);
		sb.append(prev);

		return sb.toString();
	}
}