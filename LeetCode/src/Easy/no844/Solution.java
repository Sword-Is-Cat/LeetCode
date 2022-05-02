package Easy.no844;

import java.util.Stack;

class Solution {
	public boolean backspaceCompare(String s, String t) {

		char[] sArr = s.toCharArray();
		char[] tArr = t.toCharArray();

		Stack<Character> sStack = new Stack<>(), tStack = new Stack<>();

		for (char sCh : sArr) {
			if (sCh == '#') {
				if (!sStack.isEmpty())
					sStack.pop();
			} else
				sStack.add(sCh);
		}

		for (char tCh : tArr) {
			if (tCh == '#') {
				if (!tStack.isEmpty())
					tStack.pop();
			} else
				tStack.add(tCh);
		}

		while (!sStack.isEmpty() && !tStack.isEmpty()) {
			if (sStack.pop() != tStack.pop())
				return false;
		}

		return sStack.isEmpty() && tStack.isEmpty();

	}
}