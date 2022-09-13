package Easy.no728;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Integer> selfDividingNumbers(int left, int right) {

		List<Integer> list = new ArrayList<>();

		for (int no = left; no <= right; no++) {
			if (isSelfDiv(no))
				list.add(no);
		}

		return list;
	}

	boolean isSelfDiv(int no) {

		int temp = no;

		while (temp > 0) {

			int div = temp % 10;

			if (div == 0 || no % div != 0)
				return false;
			temp /= 10;

		}

		return true;
	}
}