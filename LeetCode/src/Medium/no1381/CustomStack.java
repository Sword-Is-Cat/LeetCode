package Medium.no1381;

class CustomStack {

	int[] arr;
	int idx;

	public CustomStack(int maxSize) {
		arr = new int[maxSize];
		idx = 0;
	}

	public void push(int x) {
		if (idx < arr.length)
			arr[idx++] = x;
	}

	public int pop() {
		return idx > 0 ? arr[--idx] : -1;
	}

	public void increment(int k, int val) {
		for (int i = 0; i < Math.min(k, idx); i++) {
			arr[i] += val;
		}
	}
}