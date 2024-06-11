package Easy.no1122;

class Solution {
	public int[] relativeSortArray(int[] arr1, int[] arr2) {

		int[] cnt = new int[1001];
		for (int num : arr1) {
			cnt[num]++;
		}

		int idx = 0;
		for (int num : arr2) {
			while (cnt[num] > 0) {
				arr1[idx++] = num;
				cnt[num]--;
			}
		}

		for (int i = 0; i < cnt.length; i++) {
			while (cnt[i] > 0) {
				arr1[idx++] = i;
				cnt[i]--;
			}
		}

		return arr1;
	}
}