package Medium.no1482;

class Solution {
	public int minDays(int[] bloomDay, int m, int k) {

		if ((long) m * k > bloomDay.length) {
			return -1;
		}

		int left = 0, right = 0;

		for (int bloom : bloomDay) {
			right = Math.max(right, bloom);
		}

		while (left + 1 < right) {
			int mid = (left + right) / 2;
			if (isPossible(bloomDay, m, k, mid))
				right = mid;
			else
				left = mid;
		}

		return right;
	}

	private boolean isPossible(int[] bloomDay, int m, int k, int day) {

		int cntFlowers = 0, cntBouquets = 0;

		for (int bloom : bloomDay) {

			if (bloom <= day) {
				cntFlowers++;

				if (cntFlowers == k) {
					cntFlowers = 0;
					cntBouquets++;
					if (cntBouquets == m) {
						return true;
					}
				}
			} else {
				cntFlowers = 0;
			}

		}

		return false;
	}
}