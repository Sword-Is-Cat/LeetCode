package Medium.no264;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {

	public int nthUglyNumber(int n) {

		PriorityQueue<Long> que = new PriorityQueue<>();
		Set<Long> set = new HashSet<>();

		que.add(1L);

		int index = 1;

		while (index < n) {

			long no = que.poll();

			long no1 = no * 2;
			long no2 = no * 3;
			long no3 = no * 5;

			if (no1 > 0 && set.add(no1))
				que.add(no1);
			if (no2 > 0 && set.add(no2))
				que.add(no2);
			if (no3 > 0 && set.add(no3))
				que.add(no3);
			index++;

		}
		
		long answer = que.poll();

		return (int)answer;
	}

}