package Medium.no92;

import java.util.Stack;

class Solution {
	public ListNode reverseBetween(ListNode head, int left, int right) {

		ListNode root = new ListNode();
		root.next = head;
		ListNode temp = root;
		ListNode prev = root;
		Stack<ListNode> stack = new Stack<>();

		int idx = 0;

		while (idx++ < right) {

			temp = temp.next;

			if (idx == left - 1)
				prev = temp;

			if (left <= idx && idx <= right)
				stack.push(temp);

		}

		temp = temp.next;

		while (!stack.isEmpty()) {

			prev.next = stack.pop();
			prev = prev.next;
		}

		prev.next = temp;

		return root.next;
	}
}