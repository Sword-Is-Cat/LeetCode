package Easy.no2037;

class Solution {
	public int minMovesToSeat(int[] seats, int[] students) {

		int[] diff = new int[101];

		for (int i = 0; i < seats.length; i++) {
			diff[seats[i]]++;
			diff[students[i]]--;
		}

		int ans = 0, temp = 0;
		for (int dif : diff) {
			ans += Math.abs(temp);
			temp += dif;
		}

		return ans;
	}
}