package Medium.no17;

import java.util.ArrayList;
import java.util.List;

class Solution {

	List<String> answer = new ArrayList<>();
	char[][] charList = { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' }, { 'm', 'n', 'o' },
			{ 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };
	StringBuilder sb = new StringBuilder();
	char[] digit;

	public List<String> letterCombinations(String digits) {

		if (digits.length() != 0) {

			digit = digits.toCharArray();
			process(0, digits.length());
		}
		
		return answer;

	}

	public void process(int i, int length) {

		if (i == length) {
			answer.add(sb.toString());
		} else {
			for (char ch : charList[digit[i] - 50]) {
				sb.append(ch);
				process(i + 1, length);
				sb.deleteCharAt(i);
			}
		}

	}
}
