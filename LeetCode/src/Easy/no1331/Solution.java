package Easy.no1331;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
	public int[] arrayRankTransform(int[] arr) {

		int[] clone = arr.clone();
		Arrays.sort(clone);

		HashMap<Integer, Integer> map = new HashMap<>();
		int rank = 1;
		for (int i = 0; i < clone.length; i++) {
			if (!map.containsKey(clone[i]))
				map.put(clone[i], rank++);
		}
		
		for(int i = 0;i<arr.length;i++)
			arr[i] = map.get(arr[i]);

		return arr;

	}
}