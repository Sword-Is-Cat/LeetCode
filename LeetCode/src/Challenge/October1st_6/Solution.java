package Challenge.October1st_6;

class Solution {
	public ListNode rotateRight(ListNode head, int k) {

		if (head != null) {

			ListNode temp = head;
			ListNode last = null;
			int count = 0;

			while (temp != null) {
				count++;
				last = temp;
				temp = temp.next;
			}

			last.next = head;
			temp = head;
			int no = count - (k % count);

			while (no > 1) {
				no--;
				temp = temp.next;
			}

			head = temp.next;
			temp.next = null;
		}
		
		return head;
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