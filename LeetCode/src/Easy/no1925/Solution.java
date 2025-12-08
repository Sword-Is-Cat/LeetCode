package Easy.no1925;

class Solution {
	public int countTriples(int n) {

		int[] values = new int[n];
		for (int i = 0; i < n; i++) {
			values[i] = (i + 1) * (i + 1);
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int sum = values[i] + values[j];
				int left = -1, right = n - 1;
				while (left + 1 < right) {
					int mid = (left + right) / 2;
					if (values[mid] < sum) {
						left = mid;
					} else {
						right = mid;
					}
				}
				if (values[right] == sum) {
					ans++;
				}
			}
		}

		return ans * 2;
	}
}