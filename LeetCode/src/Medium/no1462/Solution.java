package Medium.no1462;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

		List<Boolean> ans = new ArrayList<>();
		Node[] nodes = new Node[numCourses];
		for (int i = 0; i < numCourses; i++) {
			nodes[i] = new Node(i, numCourses);
		}

		for (int[] preReq : prerequisites) {
			nodes[preReq[1]].directReq.add(nodes[preReq[0]]);
		}

		for (int[] query : queries) {
			ans.add(nodes[query[1]].calc()[query[0]]);
		}

		return ans;
	}
}

class Node {

	int idx, size;
	List<Node> directReq;
	boolean[] reqArr = null;

	Node(int idx, int size) {
		this.idx = idx;
		this.size = size;
		directReq = new ArrayList<>();
	}

	protected boolean[] calc() {
		if (reqArr == null) {
			reqArr = new boolean[size];
			for (Node req : directReq) {
				reqArr[req.idx] = true;
				boolean[] reqs = req.calc();
				for (int i = 0; i < size; i++) {
					reqArr[i] |= reqs[i];
				}
			}
		}
		return reqArr;
	}
}