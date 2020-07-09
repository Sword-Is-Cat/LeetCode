package Medium.no2;

class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode answer = new ListNode();
		ListNode temp = answer;
		boolean isCarry = false;
		
		while(l1!=null || l2!=null) {
			
			temp.next = new ListNode();
			temp = temp.next;
			
			if(l1!=null) {
				temp.val += l1.val;
				l1 = l1.next;
			}
			
			if(l2!=null) {
				temp.val += l2.val;
				l2 = l2.next;
			}
			
			if(isCarry) {
				temp.val += 1;
				isCarry = false;
			}
			
			if(temp.val>9) {
				temp.val -=10;
				isCarry = true;
			}
						
		}
		
		if(isCarry) {
			temp.next = new ListNode(1);
		}
				
		return answer.next;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
