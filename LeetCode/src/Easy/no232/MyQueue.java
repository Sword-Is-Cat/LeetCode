package Easy.no232;

class MyQueue {

	MyNode head, tail;

	public MyQueue() {

	}

	public void push(int x) {
		tail = new MyNode(x, tail);
		if (head == null)
			head = tail;
	}

	public int pop() {
		int result = peek();
		head = head.next;
		return result;
	}

	public int peek() {
		return head.value;
	}

	public boolean empty() {
		return head == null;
	}
}

class MyNode {
	int value;
	MyNode next;

	public MyNode(int value) {
		this(value, null);
	}

	public MyNode(int value, MyNode prev) {
		this.value = value;
		if (prev != null) {
			prev.next = this;
		}
	}

}