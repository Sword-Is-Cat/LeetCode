package Medium.no1404;

class Solution {
	public int numSteps(String s) {

		return calc(s.toCharArray(), s.length() - 1);
	}

	private int calc(char[] arr, int idx) {
		if (idx == 0) {
			return arr[idx] == '1' ? 0 : 1;
		}
		int rst = 1;
		if (arr[idx] == '1') {
			add(arr, idx);
			rst++;
		}
		return rst + calc(arr, idx - 1);
	}

	private void add(char[] arr, int idx) {
		if (arr[idx] == '0') {
			arr[idx] = '1';
		} else if (idx == 0) {
			arr[idx] = '2';
		} else {
			arr[idx] = '0';
			add(arr, idx - 1);
		}
	}
}
