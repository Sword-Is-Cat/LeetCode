package Easy.no1460;

class Solution {
	public boolean canBeEqual(int[] target, int[] arr) {

		int[] cnt = new int[1001];
		for (int t : target) {
			cnt[t]++;
		}
		for (int n : arr) {
			cnt[n]--;
		}
		boolean ans = true;
		for (int c : cnt) {
			ans &= c == 0;
		}
		return ans;

	}
}