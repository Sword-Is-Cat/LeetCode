package Easy.no605;

class Solution {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {

		int available = 0, lastFlower = -2;

		for (int i = 0; i < flowerbed.length; i++) {
			if (flowerbed[i] == 1) {
				available += (i - lastFlower - 2) / 2;
				lastFlower = i;
			}
		}

		available += (flowerbed.length - lastFlower - 1) / 2;

		return available >= n;
	}
}