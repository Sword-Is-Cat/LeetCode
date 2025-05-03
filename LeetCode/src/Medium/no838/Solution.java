package Medium.no838;

import java.util.Arrays;

class Solution {
	public String pushDominoes(String dominoes) {

		int length = dominoes.length();
		char[] arr = dominoes.toCharArray();
		int[] distFromR = new int[length], distFromL = new int[length];
		Arrays.fill(distFromR, length);
		Arrays.fill(distFromL, length);

		for (int i = 0; i < length; i++) {
			switch (arr[i]) {
			case 'L':
				break;
			case 'R':
				distFromR[i] = 0;
				break;
			default:
				if (i > 0 && distFromR[i - 1] < length)
					distFromR[i] = distFromR[i - 1] + 1;
			}
		}

		for (int i = distFromL.length - 1; i >= 0; i--) {
			switch (arr[i]) {
			case 'L':
				distFromL[i] = 0;
				break;
			case 'R':
				break;
			default:
				if (i < length - 1 && distFromL[i + 1] < length)
					distFromL[i] = distFromL[i + 1] + 1;
			}
		}

		for (int i = 0; i < length; i++) {
			if (arr[i] == '.') {
				if (distFromL[i] < distFromR[i])
					arr[i] = 'L';
				else if (distFromL[i] > distFromR[i])
					arr[i] = 'R';
			}
		}

		return new String(arr);

	}

}