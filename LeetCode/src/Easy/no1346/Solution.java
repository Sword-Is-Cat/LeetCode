package Easy.no1346;

import java.util.HashSet;
import java.util.Set;

class Solution {
	public boolean checkIfExist(int[] arr) {

		Set<Integer> oriNo = new HashSet<>();
		Set<Integer> twiceNo = new HashSet<>();

		for (int no : arr) {

			if (oriNo.contains(no * 2) || twiceNo.contains(no))
				return true;
			else {
				oriNo.add(no);
				twiceNo.add(no * 2);
			}

		}

		return false;

	}
}