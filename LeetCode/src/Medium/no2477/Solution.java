package Medium.no2477;

import java.util.ArrayList;

class Solution {
	Node[] cities;

	public long minimumFuelCost(int[][] roads, int seats) {
		int city = roads.length + 1;
		cities = new Node[city];
		for (int i = 0; i < city; i++)
			cities[i] = new Node(i);

		for (int[] road : roads) {
			Node c1 = cities[road[0]], c2 = cities[road[1]];
			c1.branchs.add(c2);
			c2.branchs.add(c1);
		}
		cities[0].removeParent(null);

		long ans = 0L;

		for (int i = 1; i < city; i++)
			ans += (cities[i].cntChilds() - 1) / seats + 1;

		return ans;
	}
}

class Node {
	int index, cnt;
	ArrayList<Node> branchs;

	Node(int index) {
		this.index = index;
		this.cnt = 0;
		branchs = new ArrayList<>();
	}

	void removeParent(Node parent) {
		if (parent != null)
			branchs.remove(parent);
		for (Node branch : branchs)
			branch.removeParent(this);
	}

	int cntChilds() {
		if (cnt == 0) {
			cnt = 1;
			for (Node branch : branchs)
				cnt += branch.cntChilds();
		}
		return cnt;
	}
}