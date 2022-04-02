package Easy.no1337;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
	public int[] kWeakestRows(int[][] mat, int k) {

		Queue<VO> que = new PriorityQueue<>((a, b) -> a.sum == b.sum ? a.index - b.index : a.sum - b.sum);
		for (int i = 0; i < mat.length; i++)
			que.add(new VO(i, mat[i]));

		int[] result = new int[k];
		int index = 0;

		while (!que.isEmpty() && index < k) {
			result[index++] = que.poll().index;
		}

		return result;

	}
}

class VO {

	int index;
	int sum;

	VO(int index, int[] arr) {
		this.index = index;
		this.sum = 0;
		for (int no : arr)
			sum += no;
	}

}