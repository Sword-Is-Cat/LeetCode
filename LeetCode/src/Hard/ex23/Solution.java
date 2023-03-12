package Hard.ex23;

import java.util.PriorityQueue;

class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
		for (ListNode node : lists) {
			if (node != null)
				queue.add(node);
		}
		ListNode root = new ListNode(), head = root;
		while (!queue.isEmpty()) {
			head.next = queue.poll();
			head = head.next;
			if (head.next != null)
				queue.add(head.next);
		}
		return root.next;
	}
}