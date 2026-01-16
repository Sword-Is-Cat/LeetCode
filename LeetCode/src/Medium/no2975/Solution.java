package Medium.no2975;

import java.util.Arrays;
import java.util.HashSet;

class Solution {
	public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {

		Arrays.sort(hFences);
		Arrays.sort(vFences);

		int[] hLength = new int[hFences.length + 1];
		int[] vLength = new int[vFences.length + 1];

		for (int i = 1; i < hFences.length; i++) {
			hLength[i] = hFences[i] - hFences[i - 1];
		}
		hLength[0] = hFences[0] - 1;
		hLength[hFences.length] = m - hFences[hFences.length - 1];
		for (int i = 1; i < vFences.length; i++) {
			vLength[i] = vFences[i] - vFences[i - 1];
		}
		vLength[0] = vFences[0] - 1;
		vLength[vFences.length] = n - vFences[vFences.length - 1];

		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < hLength.length; i++) {
			int temp = 0;
			for (int j = i; j < hLength.length; j++) {
				temp += hLength[j];
				set.add(temp);
			}
		}

		long length = 0;
		for (int i = 0; i < vLength.length; i++) {
			int temp = 0;
			for (int j = i; j < vLength.length; j++) {
				temp += vLength[j];
				if (set.contains(temp)) {
					length = Math.max(length, temp);
				}
			}
		}

		if (length == 0)
			return -1;

		int MOD = 1_000_000_007;
		return (int) ((length * length) % MOD);
	}
}