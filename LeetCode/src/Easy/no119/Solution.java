package Easy.no119;

import java.util.Arrays;
import java.util.List;

class Solution {
	public List<Integer> getRow(int rowIndex) {

		Integer[] answer = { 1 };

		answer = nextPascal(answer, rowIndex);

		return Arrays.asList(answer);

	}

	public Integer[] nextPascal(Integer[] arr, int index) {

		if (index == 0)
			return arr;

		Integer[] newArr = new Integer[arr.length + 1];

		for (int i = 0; i < newArr.length; i++) {

			if (i == 0 || i == arr.length)
				newArr[i] = 1;
			else
				newArr[i] = arr[i - 1] + arr[i];
		}

		return nextPascal(newArr, index - 1);
	}
}