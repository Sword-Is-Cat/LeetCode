package Medium.no725;

class Solution {
	public ListNode[] splitListToParts(ListNode head, int k) {

		ListNode[] ans = new ListNode[k];

		int length = 0, index = 0;
		ListNode temp = head, prev = null;

		while (temp != null) {
			length++;
			temp = temp.next;
		}

		length += k;
		while (index < k) {
			ans[index++] = head;
			length--;
			for (int i = 0; i < length / k; i++) {
				prev = head;
				head = head.next;
			}
			if (prev != null)
				prev.next = null;
		}

		return ans;
	}
}