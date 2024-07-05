package Medium.no2058;

class Solution {
	public int[] nodesBetweenCriticalPoints(ListNode head) {

		ListNode prev = head, curr = head.next;
		int firstCritical = -1, lastCritical = -1, idx = 0;
		int minDist = 100000;

		while (curr.next != null) {

			if ((prev.val < curr.val && curr.val > curr.next.val)
					|| (prev.val > curr.val && curr.val < curr.next.val)) {

				if (lastCritical != -1) {
					minDist = Math.min(minDist, idx - lastCritical);
				} else {
					firstCritical = idx;
				}

				lastCritical = idx;

			}

			prev = curr;
			curr = curr.next;
			idx++;

		}

		if (minDist == 100000)
			return new int[] { -1, -1 };

		return new int[] { minDist, lastCritical - firstCritical };
	}
}