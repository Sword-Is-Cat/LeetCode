package Medium.no622;

import java.util.LinkedList;

class MyCircularQueue {

	LinkedList<Integer> list;
	int limit;

	public MyCircularQueue(int k) {

		list = new LinkedList<>();
		limit = k;

	}

	public boolean enQueue(int value) {

		if (list.size() == limit)
			return false;
		list.addLast(value);
		return true;

	}

	public boolean deQueue() {

		if (list.size() == 0)
			return false;
		list.removeFirst();
		return true;

	}

	public int Front() {

		if (list.size() == 0)
			return -1;
		return list.getFirst();

	}

	public int Rear() {
		if (list.size() == 0)
			return -1;
		return list.getLast();
	}

	public boolean isEmpty() {
		return list.size() == 0;
	}

	public boolean isFull() {
		return list.size() == limit;
	}
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k); boolean param_1 =
 * obj.enQueue(value); boolean param_2 = obj.deQueue(); int param_3 =
 * obj.Front(); int param_4 = obj.Rear(); boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */