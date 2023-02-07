package Medium.no904;

class Solution {
	public int totalFruit(int[] fruits) {

		int lastFruit = -1, lastTwoFruit = -2, cntLast = 0, cntLastTwo = 0, ans = 0;

		for (int fruit : fruits) {

			if (fruit == lastFruit) {
				cntLast++;
				cntLastTwo++;
			} else if (fruit == lastTwoFruit - lastFruit) {
				cntLast = 1;
				cntLastTwo++;
				lastFruit = fruit;
			} else {
				cntLastTwo = cntLast + 1;
				cntLast = 1;
				lastTwoFruit = lastFruit + fruit;
				lastFruit = fruit;
			}
			ans = Math.max(ans, cntLastTwo);
		}
		return ans;
	}
}