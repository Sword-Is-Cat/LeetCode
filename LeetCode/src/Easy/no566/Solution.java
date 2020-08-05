package Easy.no566;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public int[][] matrixReshape(int[][] nums, int r, int c) {

		int[][] answer = new int[r][c];

		List<Integer> list = new ArrayList<>();
		
		for (int[] arr : nums)
			for (int i : arr)
				list.add(i);

		if (list.size() != r * c)
			return nums;

		int index = 0;
		
		for(int i = 0 ; i<r ; i++) {
			for(int j = 0 ; j<c ; j++) {
				answer[i][j] = list.get(index++);
			}
		}
		
		return answer;
	}
}