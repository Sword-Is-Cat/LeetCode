package Easy.no141;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public boolean hasCycle(ListNode head) {

		Set<ListNode> set = new HashSet<>();
		boolean flag = true;
		boolean answer = false;

		while (flag) {

			if (head == null)
				break;
			else if (set.contains(head)) {
				answer = true;
				break;
			} else {
				set.add(head);
				head = head.next;
			}

		}

		return answer;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}