package Easy.no225;

import java.util.ArrayDeque;

class MyStack {

	ArrayDeque<Integer> instance;

	public MyStack() {
		instance = new ArrayDeque<>();
	}

	public void push(int x) {
		instance.addLast(x);
	}

	public int pop() {
		return instance.pollLast();
	}

	public int top() {
		return instance.peekLast();
	}

	public boolean empty() {
		return instance.isEmpty();
	}
}