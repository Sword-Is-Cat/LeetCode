package Challenge.August3rd_4;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public void reorderList(ListNode head) {

		List<ListNode> list = new ArrayList<>();

		ListNode temp = head;

		while (temp != null) {
			list.add(temp);
			temp = temp.next;
		}

		int index = 0;
		int size = list.size();

		while (index < (size - 1) / 2) {
			list.get(index++).next = list.get(size - index);
			list.get(size - index).next = list.get(index);
			list.get(size - index - 1).next = null;
		}
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