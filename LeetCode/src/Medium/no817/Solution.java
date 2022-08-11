package Medium.no817;

import java.util.HashSet;

class Solution {
	public int numComponents(ListNode head, int[] nums) {

		HashSet<Integer> set = new HashSet<>();
		int ans = 0;

		for (int no : nums)
			set.add(no);

		boolean flag = false;

		while (head != null) {

			if (set.contains(head.val)) {
				if (!flag)
					ans++;
				flag = true;
			} else
				flag = false;
			
			head = head.next;

		}

		return ans;

	}
}