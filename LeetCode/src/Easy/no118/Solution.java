package Easy.no118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public List<List<Integer>> generate(int numRows) {
		
		List<List<Integer>> list = new ArrayList<>();
		
		if(numRows == 0)
			return list;
			
		int[] arr = new int[numRows];
		arr[0] = 1;
		Integer[] proc;

		for (int i = 0; i < numRows;) {
			proc = new Integer[++i];

			for (int j = 0; j < i; j++) {
				if(j == 0 || j == i-1)
					proc[j] = 1;
				else
					proc[j] = arr[j-1]+arr[j];
			}
			
			for (int j = 0; j < i; j++) {
				arr[j] = proc[j];
			}
			
			list.add(Arrays.asList(proc));
		}

		return list;
	}
}