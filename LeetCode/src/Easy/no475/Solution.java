package Easy.no475;

import java.util.Arrays;

class Solution {
	public int findRadius(int[] houses, int[] heaters) {
		
		Arrays.sort(houses);
		Arrays.sort(heaters);

		int answer = 0;

		for (int house : houses) {

			for (int i = 0; i < heaters.length; i++) {
				if (heaters[i] - house > 0) {
					if (i > 0)
						answer = Math.max(answer, Math.min(house - heaters[i - 1], heaters[i] - house));
					else
						answer = Math.max(answer, heaters[i] - house);
					break;
				}else if(i==heaters.length-1) {
					answer = Math.max(answer, house-heaters[i]);
					break;
				}
			}
		}

		return answer;
	}
}
