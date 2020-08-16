package Easy.no232;

import java.util.ArrayList;
import java.util.List;

class MyQueue {

	List<Integer> list;

	public MyQueue() {

		list = new ArrayList<>();
	}

	public void push(int x) {

		list.add(x);
	}

	public int pop() {

		int result = peek();
		list.remove(0);
		return result;
	}

	public int peek() {

		return list.get(0);
	}

	public boolean empty() {

		return list.size() == 0;
	}
}