package Hard.no834;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution_ {

	public int[] sumOfDistancesInTree(int n, int[][] edges) {

		Node[] nodes = new Node[n];

		for (int i = 0; i < n; i++)
			nodes[i] = new Node(i);

		for (int[] edge : edges) {
			nodes[edge[0]].addConn(nodes[edge[1]]);
		}

		return Arrays.stream(nodes).mapToInt(node -> node == null ? 0 : getInfo(node, null)[1]).toArray();

	}

	int[] getInfo(Node node, Node caller) {

		// 기존에 계산되어 캐싱된 결과가 있다면 그대로 return
		if (caller != null && node.cache.containsKey(caller.index))
			return node.cache.get(caller.index);

		int cntDesc = 0, sumDist = 0;

		// 연결된 하위노드(후손포함) 및 그 거리의 합을 계산
		for (Node child : node.conn) {
			if (child != caller) {
				int[] info = getInfo(child, node);
				cntDesc += info[0] + 1;
				sumDist += info[1] + info[0] + 1;
			}
		}

		// 계산결과 캐싱
		int[] result = new int[] { cntDesc, sumDist };
		if (caller != null)
			node.cache.put(caller.index, result);
		return result;

	}

}

/**
 * 각 노드간의 연결상태 및 연결노드수,거리합을 저장하는 VO
 * 
 * @author me
 */
class Node {

	final int index;
	ArrayList<Node> conn;
	HashMap<Integer, int[]> cache;

	Node(int i) {
		this.index = i;
		this.conn = new ArrayList<>();
		this.cache = new HashMap<>();
	}

	void addConn(Node node) {
		if (node != null) {
			this.conn.add(node);
			node.conn.add(this);
		}
	}
}