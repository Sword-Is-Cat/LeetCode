package Medium.no86;

import java.util.ArrayList;

class Solution_ {
	public ListNode partition(ListNode head, int x) {

		ArrayList<ListNode> ltList = new ArrayList<>();
		ArrayList<ListNode> gtList = new ArrayList<>();

		while (head != null) {
			if (head.val < x)
				ltList.add(head);
			else
				gtList.add(head);
			head = head.next;
		}

		ListNode root = new ListNode();
		ListNode temp = root;

		for (ListNode node : ltList) {
			temp.next = node;
			temp = temp.next;
		}

		for (ListNode node : gtList) {
			temp.next = node;
			temp = temp.next;
		}

		temp.next = null;
		return root.next;
	}
}