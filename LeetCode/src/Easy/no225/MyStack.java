package Easy.no225;

import java.util.ArrayList;
import java.util.List;

class MyStack {

	List<Integer> list;

	public MyStack() {

		list = new ArrayList<>();
	}

	public void push(int x) {

		list.add(x);
	}

	public int pop() {

		int result = top();
		list.remove(list.size() - 1);
		return result;
	}

	public int top() {

		return list.get(list.size() - 1);
	}

	public boolean empty() {

		return list.size() == 0;
	}
}