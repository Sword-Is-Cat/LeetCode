package Medium.no328;

class Solution {
	public ListNode oddEvenList(ListNode head) {

		ListNode oddRoot = new ListNode(), evenRoot = new ListNode();
		ListNode odd = oddRoot, even = evenRoot, node = head;
		int index = 0;

		while (node != null) {
			if (index++ % 2 == 0) {
				odd.next = node;
				odd = odd.next;
			} else {
				even.next = node;
				even = even.next;
			}
			node = node.next;
		}
		
		even.next = null;
		odd.next = evenRoot.next;

		return oddRoot.next;
	}
}