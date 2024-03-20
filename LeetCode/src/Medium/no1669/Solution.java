package Medium.no1669;

class Solution {
	public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

		ListNode header = list1, tailer = list2;
		while (b-- > 0) {
			header = header.next;
		}
		while (tailer.next != null) {
			tailer = tailer.next;
		}
		tailer.next = header.next;

		header = list1;
		while (--a > 0) {
			header = header.next;
		}
		header.next = list2;

		return list1;
	}
}