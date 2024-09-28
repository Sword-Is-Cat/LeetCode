package Medium.no641;

class MyCircularDeque {

	int currSize, maxSize;
	MyNode head, tail;

	public MyCircularDeque(int k) {
		currSize = 0;
		maxSize = k;
		head = tail = null;
	}

	public boolean insertFront(int value) {
		if (isFull())
			return false;
		if (isEmpty())
			head = tail = new MyNode(value);
		else
			head = new MyNode(value, null, head);
		currSize++;
		return true;
	}

	public boolean insertLast(int value) {
		if (isFull())
			return false;
		if (isEmpty())
			head = tail = new MyNode(value);
		else
			tail = new MyNode(value, tail, null);
		currSize++;
		return true;
	}

	public boolean deleteFront() {
		if (isEmpty())
			return false;
		head = head.next;
		head.prev = null;
		currSize--;
		return true;
	}

	public boolean deleteLast() {
		if (isEmpty())
			return false;
		tail = tail.prev;
		tail.next = null;
		currSize--;
		return true;
	}

	public int getFront() {
		return isEmpty() ? -1 : head.value;
	}

	public int getRear() {
		return isEmpty() ? -1 : tail.value;
	}

	public boolean isEmpty() {
		return currSize == 0;
	}

	public boolean isFull() {
		return currSize == maxSize;
	}
}

class MyNode {
	int value;
	MyNode prev, next;

	MyNode(int value) {
		this.value = value;
		prev = next = null;
	}

	MyNode(int value, MyNode prev, MyNode next) {
		this(value);
		this.prev = prev;
		this.next = next;
		if(prev!=null)
			prev.next = this;
		if(next!=null)
			next.prev = this;
	}
}