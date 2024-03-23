package Medium.no143;

import java.util.ArrayList;

class Solution {
	public void reorderList(ListNode head) {

		ListNode node = head;
		ArrayList<ListNode> list = new ArrayList<>();

		while (node != null) {
			list.add(node);
			node = node.next;
		}

		int left = 0, right = list.size() - 1;

		while (left < right) {
			list.get(left++).next = list.get(right);
			list.get(right--).next = list.get(left);
		}

		list.get(left).next = null;

	}
}