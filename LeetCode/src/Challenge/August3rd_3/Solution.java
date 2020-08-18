package Challenge.August3rd_3;

import java.util.ArrayList;
import java.util.List;

class Solution {

	int n, k;
	List<Integer> list;

	public int[] numsSameConsecDiff(int N, int K) {

		n = N;
		k = K;
		list = new ArrayList<>();

		if (n == 1)
			process(0, 0, 1);

		for (int i = 1; i < 10; i++)
			process(i, i, 1);

		int[] arr = new int[list.size()];

		for (int i = 0; i < arr.length; i++)
			arr[i] = list.get(i);

		return arr;

	}

	void process(int last, int no, int length) {
		if (length == n) {
			list.add(no);
		} else {
			if (last - k >= 0)
				process(last - k, no * 10 + last - k, length + 1);
			if (k != 0 && last + k <= 9)
				process(last + k, no * 10 + last + k, length + 1);
		}
	}
}