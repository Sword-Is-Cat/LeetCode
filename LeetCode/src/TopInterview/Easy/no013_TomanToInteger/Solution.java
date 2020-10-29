package TopInterview.Easy.no013_TomanToInteger;

class Solution {
	public int romanToInt(String s) {

		char[] arr = s.toCharArray();
		int answer = 0;

		for (int i = 0; i < arr.length; i++) {
			switch (arr[i]) {
			case 'M':
				answer += 1000;
				break;
			case 'C':
				if (i + 1 < arr.length && arr[i + 1] == 'D') {
					answer += 400;
					i++;
				} else if (i + 1 < arr.length && arr[i + 1] == 'M') {
					answer += 900;
					i++;
				} else
					answer += 100;
				break;
			case 'X':
				if (i + 1 < arr.length && arr[i + 1] == 'C') {
					answer += 90;
					i++;
				} else if (i + 1 < arr.length && arr[i + 1] == 'L') {
					answer += 40;
					i++;
				} else
					answer += 10;
				break;
			case 'I':
				if (i + 1 < arr.length && arr[i + 1] == 'X') {
					answer += 9;
					i++;
				} else if (i + 1 < arr.length && arr[i + 1] == 'V') {
					answer += 4;
					i++;
				} else
					answer += 1;
				break;
			case 'D':
				answer += 500;
				break;
			case 'L':
				answer += 50;
				break;
			case 'V':
				answer += 5;
				break;
			}
		}

		return answer;
	}
}