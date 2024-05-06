package Medium.no2487;

import java.util.Stack;

class Solution {
	public ListNode removeNodes(ListNode head) {

		ListNode root = new ListNode(100000, head);
		Stack<ListNode> stack = new Stack<>();
		stack.add(root);

		while (head != null) {

			while (stack.peek().val < head.val) {
				stack.pop();
				stack.peek().next = head;
			}

			stack.add(head);
			head = head.next;

		}

		return root.next;

	}
}