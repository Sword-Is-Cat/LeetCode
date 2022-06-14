package Medium.no92;

import java.util.Stack;

class Solution {
	public ListNode reverseBetween(ListNode head, int left, int right) {

		ListNode root = new ListNode();
		root.next = head;

		Stack<ListNode> stack = new Stack<>();
		ListNode temp = root, prev = root, next = null;

		int idx = 0;
		while (temp != null) {
			temp = temp.next;
			idx++;

			if (left <= idx && idx <= right)
				stack.add(temp);

			if (idx < left && temp != null)
				prev = temp;

			if (next == null && right < idx)
				next = temp;

		}

		while (!stack.isEmpty()) {
			prev.next = stack.pop();
			prev = prev.next;
		}

		prev.next = next;

		return root.next;
	}
}