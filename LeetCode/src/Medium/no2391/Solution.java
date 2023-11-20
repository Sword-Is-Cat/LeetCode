package Medium.no2391;

class Solution {
	public int garbageCollection(String[] garbage, int[] travel) {

		int ans = 0;

		for (int i = 0; i < travel.length; i++) {
			ans += travel[i];
		}
		ans *= 3;

		for (int i = 0; i < garbage.length; i++) {
			ans += garbage[i].length();
		}

		for (int i = garbage.length - 1; 0 < i; i--) {
			if (garbage[i].contains("M")) {
				break;
			} else {
				ans -= travel[i - 1];
			}
		}

		for (int i = garbage.length - 1; 0 < i; i--) {
			if (garbage[i].contains("P")) {
				break;
			} else {
				ans -= travel[i - 1];
			}
		}

		for (int i = garbage.length - 1; 0 < i; i--) {
			if (garbage[i].contains("G")) {
				break;
			} else {
				ans -= travel[i - 1];
			}
		}

		return ans;
	}
}