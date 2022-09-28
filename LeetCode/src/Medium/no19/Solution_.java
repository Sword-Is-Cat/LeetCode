package Medium.no19;

import java.util.ArrayList;
import java.util.List;

class Solution_ {

	public ListNode removeNthFromEnd(ListNode head, int n) {

		List<ListNode> list = new ArrayList<>();
		ListNode originalHead = head;

		while (head != null) {
			list.add(head);
			head = head.next;
		}

		if(list.size() == n)
			return originalHead.next;
		
		ListNode prt = list.get(list.size() - n -1);
		prt.next = prt.next.next;

		return originalHead;
	}
}
