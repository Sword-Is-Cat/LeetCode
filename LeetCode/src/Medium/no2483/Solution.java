package Medium.no2483;

class Solution {
	public int bestClosingTime(String customers) {

		int penalty = 0, minPenalty = penalty, time = customers.length(), close = time;

		while (time-- > 0) {
			penalty += customers.charAt(time) == 'Y' ? 1 : -1;
			if (penalty <= minPenalty) {
				minPenalty = penalty;
				close = time;
			}
		}

		return close;
	}
}