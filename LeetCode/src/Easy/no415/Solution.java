package Easy.no415;

class Solution {
	public String addStrings(String num1, String num2) {

		char[] no1 = num1.toCharArray();
		char[] no2 = num2.toCharArray();

		int length = Math.max(no1.length, no2.length);

		int[] arr1 = new int[length];
		int[] arr2 = new int[length];
		int[] arr3 = new int[length];
		int[] arr4 = new int[length];

		for (int i = 1; i <= length; i++) {
			arr1[length - i] = no1.length - i < 0 ? 0 : no1[no1.length - i] - 48;
			arr2[length - i] = no2.length - i < 0 ? 0 : no2[no2.length - i] - 48;
		}

		for (int i = 1; i <= length; i++) {
			if (i == length)
				arr4[length - i] = arr1[length - i] + arr2[length - i] + arr3[length - i];
			else if (arr1[length - i] + arr2[length - i] + arr3[length - i] > 9) {
				arr4[length - i] = arr1[length - i] + arr2[length - i] + arr3[length - i] - 10;
				arr3[length - 1 - i] = 1;
			} else
				arr4[length - i] = arr1[length - i] + arr2[length - i] + arr3[length - i];
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < length; i++)
			sb.append(arr4[i]);

		return sb.toString();

	}
}