package Medium.no86;

class Solution {
	
	public ListNode partition(ListNode head, int x) {

		ListNode lRoot = new ListNode(), lTemp = lRoot;
		ListNode gRoot = new ListNode(), gTemp = gRoot;

		while (head != null) {

			if (head.val < x) {
				lTemp.next = head;
				lTemp = lTemp.next;
			} else {
				gTemp.next = head;
				gTemp = gTemp.next;
			}

			head = head.next;
		}

		lTemp.next = gRoot.next;
		gTemp.next = null;

		return lRoot.next;
	}
}