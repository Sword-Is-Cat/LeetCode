package Medium.no179;

import java.util.PriorityQueue;

class Solution {
	public String largestNumber(int[] nums) {

		PriorityQueue<String> que = new PriorityQueue<>((a, b) -> (b + a).compareTo(a + b));

		for (int no : nums)
			que.add(Integer.toString(no));

		StringBuilder sb = new StringBuilder();

		while (!que.isEmpty())
			sb.append(que.poll());

		while (sb.length() > 0 && sb.charAt(0) == '0')
			sb.deleteCharAt(0);

		if (sb.length() == 0)
			sb.append('0');

		return sb.toString();
	}
}