package Medium.no17;

import java.util.ArrayList;
import java.util.List;

class Solution {

	char[][] dic;

	public List<String> letterCombinations(String digits) {

		List<String> list = new ArrayList<>();
		dic = buildDic();

		if (digits.length() > 0)
			process(list, digits, new char[digits.length()], 0);

		return list;

	}

	private void process(List<String> list, String digits, char[] container, int index) {

		if (index == container.length) {
			list.add(new String(container));
			return;
		}

		for (char ch : dic[digits.charAt(index) - '2']) {
			container[index] = ch;
			process(list, digits, container, index + 1);
		}

	}

	private char[][] buildDic() {

		char[][] myDic = new char[8][];

		myDic[0] = new char[] { 'a', 'b', 'c' };
		myDic[1] = new char[] { 'd', 'e', 'f' };
		myDic[2] = new char[] { 'g', 'h', 'i' };
		myDic[3] = new char[] { 'j', 'k', 'l' };
		myDic[4] = new char[] { 'm', 'n', 'o' };
		myDic[5] = new char[] { 'p', 'q', 'r', 's' };
		myDic[6] = new char[] { 't', 'u', 'v' };
		myDic[7] = new char[] { 'w', 'x', 'y', 'z' };

		return myDic;
	}
}