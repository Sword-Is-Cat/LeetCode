package Easy.no1710;

import java.util.Arrays;

class Solution {
	public int maximumUnits(int[][] boxTypes, int truckSize) {

		Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

		int idx = 0;
		int sum = 0;

		while (idx < boxTypes.length && truckSize > 0) {

			int[] boxInfo = boxTypes[idx++];

			System.out.println("boxInfo:[" + boxInfo[0] + "," + boxInfo[1] + "]");
			System.out.println("truckSize:" + truckSize);

			int boxCnt = Math.min(truckSize, boxInfo[0]);

			truckSize -= boxCnt;
			sum += boxCnt * boxInfo[1];

			System.out.println("boxCnt:" + boxCnt + ", sum:" + sum);

		}
		return sum;
	}
}