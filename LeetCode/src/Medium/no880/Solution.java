package Medium.no880;

class Solution {
	public String decodeAtIndex(String s, int k) {
		return process(s, 0, k, 0);
	}

	private String process(String str, int index, int targetIndex, long length) {

		char ch = str.charAt(index);

		if ('0' <= ch && ch <= '9') {
			int loop = ch - '0';
			if (targetIndex <= length * loop)
				return process(str, 0, (int) ((targetIndex - 1) % length) + 1, 0);
			else
				return process(str, index + 1, targetIndex, length * loop);

		} else {
			if (length + 1 == targetIndex)
				return Character.toString(ch);
			else
				return process(str, index + 1, targetIndex, length + 1);
		}

	}
}