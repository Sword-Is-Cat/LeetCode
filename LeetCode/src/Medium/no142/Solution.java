package Medium.no142;

import java.util.HashSet;

public class Solution {

	public ListNode detectCycle(ListNode head) {

		HashSet<ListNode> set = new HashSet<>();

		while (head != null) {
			if (set.add(head))
				head = head.next;
			else
				return head;
		}
		return null;
	}
}