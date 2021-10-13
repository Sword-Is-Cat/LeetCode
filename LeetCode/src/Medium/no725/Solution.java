package Medium.no725;

class Solution {
	public ListNode[] splitListToParts(ListNode head, int k) {

		ListNode[] answer = new ListNode[k];

		ListNode node = head;
		int cnt = 0;

		while (node != null) {
			node = node.next;
			cnt++;
		}

		for (int i = 0; i < k; i++) {

			answer[i] = head;

			int no = i < cnt % k ? cnt / k + 1 : cnt / k;

			while (no > 1) {
				no--;
				head = head.next;
			}
			if (head != null) {

				ListNode temp = head.next;
				head.next = null;
				head = temp;
			}

		}

		return answer;
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
