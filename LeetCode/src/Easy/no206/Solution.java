package Easy.no206;

class Solution {
	public ListNode reverseList(ListNode head) {

		ListNode answer = null;
		
		while(head!=null) {
			answer = new ListNode(head.val, answer);
			head = head.next;
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