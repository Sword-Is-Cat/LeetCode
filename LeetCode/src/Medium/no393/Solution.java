package Medium.no393;

class Solution {
	public boolean validUtf8(int[] data) {

		int stack = 0;

		for (int dat : data) {

			int cnt = countHead(dat);

			if (cnt > 4)
				return false;

			if (stack == 0) {

				if (cnt == 1)
					return false;
				else if (cnt > 1)
					stack += cnt - 1;

			} else {

				if (cnt == 1)
					stack--;
				else
					return false;

			}

		}

		return stack == 0;
	}

	int countHead(int dat) {

		int init = 128;
		int cnt = 0;

		while (dat >= init && init > 0) {
			dat -= init;
			cnt++;
			init /= 2;
		}

		return cnt;
	}
}