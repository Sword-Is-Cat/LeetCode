package Easy.no405;

class Solution {
	public String toHex(int num) {

		char[] arr = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		boolean minus = false;

		if (num < 0) {
			num = Integer.MAX_VALUE + (num + 1);
			minus = true;
		}

		char[] answer = new char[8];

		for (int i = 7; i >= 0; i--) {

			if (i == 0 && minus)
				answer[i] = arr[(num % 16) + 8];
			else
				answer[i] = arr[num % 16];

			num /= 16;
		}

		String str = "";
		int i = 0;

		while (i < 8 && answer[i] == '0')
			i++;

		while (i < 8) {
			str += answer[i];
			i++;
		}

		return str.length() == 0 ? "0" : str;
	}
}