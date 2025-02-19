package Medium.no1415;

import java.util.Arrays;

class Solution {
	public String getHappyString(int n, int k) {

		k--;
		char[] arr = new char[n];
		Arrays.fill(arr, 'a');

		for (int i = arr.length - 1; i > 0; i--) {
			arr[i] += k % 2;
			k /= 2;
		}

		if (k > 2)
			return "";
		arr[0] += k;

		for (int i = 1; i < arr.length; i++) {
			switch (arr[i - 1]) {
			case 'a':
				arr[i]++;
				break;
			case 'b':
				if (arr[i] == 'b')
					arr[i]++;
				break;
			case 'c':
				break;
			}
		}

		return new String(arr);
	}
}