package Medium.no729;

class MyCalendar {

	MySchedule root;

	public MyCalendar() {
		root = new MySchedule(0, 0, null, null);
	}

	public boolean book(int start, int end) {

		MySchedule node = root;
		while (node.next != null && node.next.end <= start) {
			node = node.next;
		}

		if (node.next == null || end <= node.next.start) {
			node.next = new MySchedule(start, end, node, node.next);
			return true;
		}

		return false;
	}
}

class MySchedule {

	int start, end;
	MySchedule prev, next;

	MySchedule(int start, int end, MySchedule prev, MySchedule next) {
		this.start = start;
		this.end = end;
		this.prev = prev;
		this.next = next;
	}

}