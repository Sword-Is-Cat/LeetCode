package Easy.no492;

class Solution {
	public int[] constructRectangle(int area) {

		int temp = 0;

		for (int i = 1; i * i <= area; i++) {
			if (area % i == 0)
				temp = i;
		}

		int[] answer = { area / temp, temp };
		return answer;
	}
}