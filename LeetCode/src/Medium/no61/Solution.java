package Medium.no61;

class Solution {
	public ListNode rotateRight(ListNode head, int k) {

		if (head == null)
			return head;
		ListNode node = head;

		int cnt = 1;
		while (node.next != null) {
			node = node.next;
			cnt++;
		}
		node.next = head;

		cnt -= k % cnt;

		while (cnt > 0) {
			node = head;
			head = head.next;
			cnt--;
		}
		node.next = null;

		return head;

	}

	public static void main(String[] args) {
		ListNode node = new ListNode(0, new ListNode(1, new ListNode(2)));
		System.out.println(new Solution().rotateRight(node, 4).val);
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