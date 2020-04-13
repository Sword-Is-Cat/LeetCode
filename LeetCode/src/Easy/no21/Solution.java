package Easy.no21;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
//class Solution {
//	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//
//		ListNode process = new ListNode(0);
//		ListNode answer = process;
//		
//		while(l1!=null && l2!=null) {
//			if(l1.val<=l2.val) {
//				process.next = l1;
//				l1 = l1.next;
//				process = process.next;
//			} else {
//				process.next = l2;
//				l2 = l2.next;
//				process = process.next;
//			}
//		}
//		
//		if(l1 == null)
//			process.next = l2;
//		else
//			process.next = l1;
//		
//		return answer.next;
//	}
//}