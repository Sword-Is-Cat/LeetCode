package Medium.no752;

import java.util.ArrayDeque;
import java.util.Collection;

class Solution {
	public int openLock(String[] deadends, String target) {

		boolean[] visit = new boolean[10000];
		int targetNum = Integer.parseInt(target);
		for (String deadend : deadends) {
			visit[Integer.parseInt(deadend)] = true;
		}

		ArrayDeque<Integer> que = new ArrayDeque<>();
		que.add(0);
		int spin = 0;

		while (!que.isEmpty()) {
			int loop = que.size();
			while (loop-- > 0) {
				int num = que.poll();
				if (!visit[num]) {
					visit[num] = true;
					if (num == targetNum) {
						return spin;
					}
					addNextNums(num, que);
				}
			}
			spin++;
		}

		return -1;
	}

	private void addNextNums(int num, Collection<Integer> collection) {
		
		collection.add(num / 1000 == 9 ? num - 9000 : num + 1000);
		collection.add(num / 1000 == 0 ? num + 9000 : num - 1000);
		collection.add(num / 100 % 10 == 9 ? num - 900 : num + 100);
		collection.add(num / 100 % 10 == 0 ? num + 900 : num - 100);
		collection.add(num / 10 % 10 == 9 ? num - 90 : num + 10);
		collection.add(num / 10 % 10 == 0 ? num + 90 : num - 10);
		collection.add(num % 10 == 9 ? num - 9 : num + 1);
		collection.add(num % 10 == 0 ? num + 9 : num - 1);
		
	}
}