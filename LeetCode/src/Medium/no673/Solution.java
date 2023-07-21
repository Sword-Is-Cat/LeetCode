package Medium.no673;

import java.util.ArrayList;

class Solution {

	ArrayList<ArrayList<int[]>> list = new ArrayList<>();

	public int findNumberOfLIS(int[] nums) {

		list.add(new ArrayList<>());
		list.get(0).add(new int[] { Integer.MIN_VALUE, 1 });
		
		for(int val : nums) {
			addNewValue(val);
		}

		return myFunc(list.get(list.size() - 1), Integer.MAX_VALUE);
	}

	private void addNewValue(int value) {
		for (int length = list.size() - 1; length >= 0; length--) {
			int cnt = myFunc(list.get(length), value);
			if (cnt > 0) {
				if (list.size() == length + 1)
					list.add(new ArrayList<>());
				list.get(length + 1).add(new int[] { value, cnt });
				return;
			}
		}

	}

	private int myFunc(ArrayList<int[]> myList, int value) {
		int sum = 0;
		for (int[] arr : myList) {
			if (arr[0] < value) {
				sum += arr[1];
			}
		}
		return sum;
	}

}