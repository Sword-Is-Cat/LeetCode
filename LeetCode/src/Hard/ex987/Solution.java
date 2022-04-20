package Hard.ex987;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

	public List<List<Integer>> verticalTraversal(TreeNode root) {

		Map<Integer, Queue<VO>> map = new HashMap<>();
		dfs(map, root, 0, 0);

		List<List<Integer>> list = new ArrayList<>();
		Queue<Integer> que = new PriorityQueue<>(map.keySet());

		while (!que.isEmpty()) {
			
			List<Integer> myList = new ArrayList<>();
			Queue<VO> myQue = map.get(que.poll());
			
			while (!myQue.isEmpty())
				myList.add(myQue.poll().node.val);

			list.add(myList);
		}

		return list;

	}

	void dfs(Map<Integer, Queue<VO>> map, TreeNode node, int row, int col) {

		if (node != null) {

			dfs(map, node.left, row + 1, col - 1);

			if (!map.containsKey(col))
				map.put(col, new PriorityQueue<>((a, b) -> a.compareTo(b)));

			map.get(col).add(new VO(node, row, col));

			dfs(map, node.right, row + 1, col + 1);

		}
	}
}

class VO {
	TreeNode node;
	int row;
	int col;

	VO(TreeNode node, int row, int col) {
		this.node = node;
		this.row = row;
		this.col = col;
	}

	int compareTo(VO other) {
		return row - other.row != 0 ? row - other.row : node.val - other.node.val;
	}

}