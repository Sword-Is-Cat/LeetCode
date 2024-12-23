package Medium.no2471;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

class Solution {
	public int minimumOperations(TreeNode root) {

		Queue<TreeNode> que = new ArrayDeque<>();
		que.offer(root);

		int ans = 0;

		while (!que.isEmpty()) {
			int loop = que.size();
			int[] arr = new int[loop];
			for (int i = 0; i < loop; i++) {
				TreeNode item = que.poll();
				arr[i] = item.val;
				if (item.left != null)
					que.offer(item.left);
				if (item.right != null)
					que.offer(item.right);
			}

			ans += chngCnt(arr);
		}

		return ans;

	}

	private int chngCnt(int[] arr) {

		int cnt = 0;
		int[] sorted = arr.clone();
		Arrays.sort(sorted);

		Map<Integer, Integer> idxMap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			idxMap.put(arr[i], i);
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != sorted[i]) {
				cnt++;
				int j = idxMap.get(sorted[i]);
				arr[j] = arr[i];
				idxMap.put(arr[j], j);
			}
		}

		return cnt;
	}
}