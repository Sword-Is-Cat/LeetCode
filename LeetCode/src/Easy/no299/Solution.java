package Easy.no299;

class Solution {
	public String getHint(String secret, String guess) {

		char[] arr = secret.toCharArray();
		char[] brr = guess.toCharArray();

		int a = 0;
		int b = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == brr[i]) {

				arr[i] = 0;
				brr[i] = 0;
				a++;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				for (int j = 0; j < brr.length; j++) {
					if (arr[i] == brr[j]) {
						arr[i] = 0;
						brr[j] = 0;
						b++;
						break;
					}
				}
			}
		}

		return a + "A" + b + "B";

	}
}