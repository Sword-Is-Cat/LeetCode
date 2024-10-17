package Medium.no670;

class Solution {
	public int maximumSwap(int num) {

		char[] arr = Integer.toString(num).toCharArray();
		boolean isSwap = false;

		for (int i = 0; !isSwap && i < arr.length; i++) {
			int idx = -1, value = arr[i] + 1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] >= value) {
					value = arr[j];
					idx = j;
				}
			}
			if (idx > -1) {
				char temp = arr[i];
				arr[i] = arr[idx];
				arr[idx] = temp;
				isSwap = true;
			}
		}

		return Integer.parseInt(new String(arr));
	}
}