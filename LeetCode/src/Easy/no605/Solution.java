package Easy.no605;

class Solution {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {

		int available = 0;

		int temp = -2;

		for (int i = 0; i < flowerbed.length; i++) {
			if (flowerbed[i] == 1) {
				if ((i - temp) / 2 > 1)
					available += (i - temp) / 2 - 1;
				temp = i;
			}
		}

		if ((flowerbed.length + 1 - temp) / 2 > 1)
			available += (flowerbed.length + 1 - temp) / 2 - 1;

		return available >= n;
	}
}