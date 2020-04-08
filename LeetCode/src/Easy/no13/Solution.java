package Easy.no13;

class Solution {
	public int romanToInt(String s) {

		int answer = 0;

		answer -= (s.contains("IV")) ? 2 : 0;
		answer -= (s.contains("IX")) ? 2 : 0;
		answer -= (s.contains("XL")) ? 20 : 0;
		answer -= (s.contains("XC")) ? 20 : 0;
		answer -= (s.contains("CD")) ? 200 : 0;
		answer -= (s.contains("CM")) ? 200 : 0;

		char[] arr = s.toCharArray();

		for (char ch : arr) {
			switch (ch) {
			case 'I':
				answer += 1;
				break;
			case 'V':
				answer += 5;
				break;
			case 'X':
				answer += 10;
				break;
			case 'L':
				answer += 50;
				break;
			case 'C':
				answer += 100;
				break;
			case 'D':
				answer += 500;
				break;
			case 'M':
				answer += 1000;
				break;
			default:
			}
		}

		return answer;
	}
}