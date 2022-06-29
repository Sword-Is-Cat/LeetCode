package Medium.no89;

import java.util.ArrayList;
import java.util.List;

class Solution {

	List<Integer> list;
	int[] numArr;
	boolean[] arr;

	public List<Integer> grayCode(int n) {

		list = new ArrayList<>();

		numArr = new int[n];
		arr = new boolean[n];

		numArr[0] = 1;
		for (int i = 1; i < n; i++)
			numArr[i] = 2 * numArr[i - 1];

		list.add(0);
		process(n - 1, 0);

		return list;
	}

	int process(int idx, int no) {

		if (idx > 0)
			no = process(idx - 1, no);

		if (arr[idx])
			no -= numArr[idx];
		else
			no += numArr[idx];

		arr[idx] = !arr[idx];
		list.add(no);

		if (idx > 0)
			no = process(idx - 1, no);

		return no;

	}
}