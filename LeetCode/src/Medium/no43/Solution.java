package Medium.no43;

class Solution {

	// '0' = 48

	public String multiply(String num1, String num2) {

		char[] arr1 = num1.toCharArray();
		char[] arr2 = num2.toCharArray();

		int[] multi = new int[arr1.length + arr2.length - 1];

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				multi[i + j] += (arr1[i] - 48) * (arr2[j] - 48);
			}
		}

		int temp = 0;
		StringBuilder sb = new StringBuilder();

		for (int i = multi.length - 1; i >= 0; i--) {
			temp += multi[i];
			sb.append(temp % 10);
			temp /= 10;
		}

		String answer = sb.append(temp).reverse().toString().replaceFirst("^0+(?!$)", "");

		return answer.length() == 0 ? "0" : answer;

	}

}