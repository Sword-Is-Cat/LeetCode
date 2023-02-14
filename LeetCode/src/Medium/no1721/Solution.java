package Medium.no1721;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public ListNode swapNodes(ListNode head, int k) {

		List<ListNode> list = new ArrayList<>();

		while (head != null) {
			list.add(head);
			head = head.next;
		}

		int in1 = k - 1;
		int in2 = list.size() - k;
		ListNode temp = list.get(in1);

		list.set(in1, list.get(in2));
		list.set(in2, temp);

		for (int i = 0; i < list.size() - 1; i++)
			list.get(i).next = list.get(i + 1);

		list.get(list.size() - 1).next = null;

		return list.get(0);
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}