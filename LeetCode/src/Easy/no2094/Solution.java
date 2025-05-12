package Easy.no2094;

import java.util.Arrays;
import java.util.HashSet;

class Solution {
	public int[] findEvenNumbers(int[] digits) {
		
		int[] cnt = new int[10];
		for(int d:digits)
			cnt[d]++;
		
		HashSet<Integer> set = new HashSet<>();
		findProcess(cnt, 0, 0, set);
		
		int[] answer = new int[set.size()];
		int idx = 0;
		for(int item:set) {
			answer[idx++] = item;
		}
		Arrays.sort(answer);
		
		return answer;
	}

	private void findProcess(int[] cnt, int depth, int value, HashSet<Integer> set) {
		if(depth>2) {
			if(value>99 && value%2==0)
				set.add(value);
		}else {
			for(int i = 0;i<10;i++) {
				if(cnt[i]>0) {
					cnt[i]--;
					findProcess(cnt, depth+1, value*10+i, set);
					cnt[i]++;
				}
			}
		}
	}
}