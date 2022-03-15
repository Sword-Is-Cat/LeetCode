package Hard.no25;

class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {

		ListNode[] arr = new ListNode[k];

		arr[0] = head;
		for (int i = 1; i < arr.length; i++) {
			arr[i] = arr[i - 1] == null ? null : arr[i - 1].next;
		}

		if (arr[k - 1] != null) {
			ListNode node = arr[k - 1].next;
			for (int i = 1; i < arr.length; i++) {
				arr[i].next = arr[i - 1];
			}
			arr[0].next = reverseKGroup(node, k);
			head = arr[k - 1];
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