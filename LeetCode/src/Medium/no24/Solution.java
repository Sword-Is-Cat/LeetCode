package Medium.no24;

class Solution {
	public ListNode swapPairs(ListNode head) {

		ListNode root = new ListNode(0, head);
		ListNode node = root;

		while (node.next != null && node.next.next != null) {
			
			ListNode after = node.next.next.next;
			ListNode temp = node.next.next;
			
			temp.next = node.next;
			temp.next.next = after;
			node.next = temp;
			
			node = node.next.next;
			
		}

		return root.next;
	}
}