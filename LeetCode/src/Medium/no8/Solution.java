package Medium.no8;

class Solution {

	public int myAtoi(String str) {

		char[] arr = str.toCharArray();

		boolean isMinus = false;
		int head = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 32)
				continue;
			else if (arr[i] == 43) {
				head = i + 1;
				break;
			} else if (arr[i] == 45) {
				isMinus = true;
				head = i + 1;
				break;
			} else if (48 <= arr[i] && arr[i] <= 57) {
				head = i;
				break;
			} else
				break;
		}

		long answer = 0;

		for (int i = head; i < arr.length; i++) {
			if(answer>Integer.MAX_VALUE)
				break;
			else if (48 <= arr[i] && arr[i] <= 57) {
				answer = answer * 10 + (long) arr[i] - 48;
			} else
				break;
		}
		
		if (isMinus)
			answer *= -1;

		int rAnswer = 0;

		if (answer > Integer.MAX_VALUE)
			rAnswer = Integer.MAX_VALUE;
		else if (answer < Integer.MIN_VALUE)
			rAnswer = Integer.MIN_VALUE;
		else
			rAnswer = (int) answer;

		return rAnswer;

	}
}