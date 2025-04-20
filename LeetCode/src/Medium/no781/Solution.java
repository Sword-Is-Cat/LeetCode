package Medium.no781;

class Solution {
	public int numRabbits(int[] answers) {

		int[] cnts = new int[1000];
		for (int ans : answers)
			cnts[ans]++;

		int result = 0;

		for (int i = 0; i < cnts.length; i++) {
			int mod = i + 1;
			result += cnts[i];
			if (cnts[i] % mod != 0)
				result += mod - (cnts[i] % mod);
		}

		return result;
	}
}