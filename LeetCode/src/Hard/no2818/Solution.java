package Hard.no2818;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

	List<Integer> primes;
	final int MOD = (int) 1e9 + 7;

	public int maximumScore(List<Integer> nums, int k) {

		primes = buildPrimeList(320);

		int length = nums.size();
		long answer = 1;

		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
		int[][] infos = new int[length][];
		for (int index = 0; index < length; index++) {
			int value = nums.get(index);
			infos[index] = new int[] { value, index, getPrimeScore(value) };
			queue.offer(infos[index]);
		}

		while (k > 0) {
			int[] info = queue.poll();
			int index = info[1], value = info[0], pScore = info[2];
			int left = index, right = index;
			while (left > 0 && infos[left - 1][2] < pScore) {
				left--;
			}
			while (right < length - 1 && infos[right + 1][2] <= pScore) {
				right++;
			}
			long size = Math.min((index - left + 1L) * (right - index + 1L), k);
			k -= size;
			answer = (answer * customPow(value, (int) size)) % MOD;
		}

		return (int) answer;
	}

	private long customPow(long value, int pow) {
		if (pow == 1)
			return value;
		long result = pow % 2 == 1 ? value : 1;
		long powed = customPow(value, pow / 2);
		powed = (powed * powed) % MOD;
		return (powed * result) % MOD;
	}

	private int getPrimeScore(int value) {

		int primeScore = 0;
		for (int i = 0; value > 1 && i < primes.size(); i++) {
			int prime = primes.get(i);
			if (value % prime == 0) {
				primeScore++;
				while (value % prime == 0)
					value /= prime;
			}
		}
		if (value > 1)
			primeScore++;

		return primeScore;
	}

	private List<Integer> buildPrimeList(int maxNum) {
		List<Integer> list = new ArrayList<>();
		boolean[] visit = new boolean[maxNum + 1];
		for (int prime = 2; prime <= maxNum; prime++) {
			if (!visit[prime]) {
				list.add(prime);
				for (int i = 1; i * prime < visit.length; i++) {
					visit[i * prime] = true;
				}
			}
		}
		return list;
	}

}