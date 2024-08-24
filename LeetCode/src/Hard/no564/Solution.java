package Hard.no564;

import java.util.PriorityQueue;

class Solution {
	public String nearestPalindromic(String n) {

		int length = n.length();
		long halfNum = Long.parseLong(n.substring(0, (length + 1) / 2));
		long num = Long.parseLong(n);

		PriorityQueue<Long> que = new PriorityQueue<>((a, b) -> {
			int rst = Long.compare(Math.abs(a - num), Math.abs(b - num));
			return rst == 0 ? Long.compare(a, b) : rst;
		});

		long pow = 1;
		while (pow < num) {
			pow *= 10;
		}

		que.add(makePalindrome(halfNum - 1, (length & 1) == 1));
		que.add(makePalindrome(halfNum, (length & 1) == 1));
		que.add(makePalindrome(halfNum + 1, (length & 1) == 1));
		que.add(pow - 1);
		que.add(pow + 1);
		que.add(pow / 10 - 1);
		que.add(pow / 10 + 1);

		while (que.peek() == num)
			que.poll();

		return que.poll().toString();
	}

	private long makePalindrome(long num, boolean isOddLength) {

		StringBuilder sb = new StringBuilder();
		sb.append(num);

		if (isOddLength)
			sb.deleteCharAt(sb.length() - 1);

		sb.append(new StringBuilder().append(num).reverse().toString());

		return Long.parseLong(sb.toString());
	}
}