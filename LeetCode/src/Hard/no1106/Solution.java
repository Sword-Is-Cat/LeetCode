package Hard.no1106;

class Solution {
	public boolean parseBoolExpr(String expression) {
		char[] arr = expression.toCharArray();
		return parseBoolExprArr(arr, 0, arr.length);
	}

	private boolean parseBoolExprArr(char[] arr, int from, int to) {

		int stack = 0;
		boolean result = false, isAnd = false;
		switch (arr[from]) {
		case 't':
			return true;
		case 'f':
			return false;
		case '!':
			return !parseBoolExprArr(arr, from + 2, to - 1);
		case '&':
			result = true;
			isAnd = true;
			break;
		case '|':
			break;
		}

		int start = from + 2, end = to - 1;
		for (int i = start; i < end; i++) {
			switch (arr[i]) {
			case '(':
				stack++;
				break;
			case ')':
				stack--;
				break;
			case ',':
				if (stack == 0) {
					if (isAnd) {
						result &= parseBoolExprArr(arr, start, i);
					} else {
						result |= parseBoolExprArr(arr, start, i);
					}
					start = i + 1;
				}
				break;

			}
		}
		if (isAnd) {
			result &= parseBoolExprArr(arr, start, end);
		} else {
			result |= parseBoolExprArr(arr, start, end);
		}

		return result;
	}
}