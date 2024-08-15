package Easy.no860;

class Solution {
	public boolean lemonadeChange(int[] bills) {

		int[] change = { 0, 0 };

		for (int bill : bills) {
			switch (bill) {
			case 5:
				change[0]++;
				break;
			case 10:
				if (change[0] == 0)
					return false;
				change[0]--;
				change[1]++;
				break;
			case 20:
				if (change[0] < 3 && Math.min(change[0], change[1]) == 0)
					return false;
				if (change[1] > 0) {
					change[1]--;
					change[0]--;
				} else {
					change[0] -= 3;
				}
				break;
			}
		}

		return true;

	}
}