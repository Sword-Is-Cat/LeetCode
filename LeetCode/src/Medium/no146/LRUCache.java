package Medium.no146;

import java.util.HashMap;

class LRUCache {

	int cap;
	LRUNode root, last;
	HashMap<Integer, LRUNode> map;

	public LRUCache(int capacity) {
		cap = capacity;
		root = last = new LRUNode(0, 0);
		map = new HashMap<>();
	}

	public int get(int key) {
		int rst = -1;
		if (map.containsKey(key)) {
			LRUNode node = map.get(key);
			removeNode(node);
			addNode(node);
			rst = node.val;
		}
		return rst;
	}

	public void put(int key, int value) {

		removeNode(map.get(key));

		LRUNode node = new LRUNode(key, value);
		addNode(node);

		if (map.size() > cap) {
			removeNode(root.next);
		}
	}

	private void connectNode(LRUNode prev, LRUNode next) {
		if (prev == null)
			return;
		prev.next = next;
		if (next != null)
			next.prev = prev;
	}

	private void removeNode(LRUNode node) {
		if (node == null)
			return;
		connectNode(node.prev, node.next);
		if(node.next == null)
			last = node.prev;
		map.remove(node.key, node);
	}

	private void addNode(LRUNode node) {
		if (node == null)
			return;
		node.prev = null;
		node.next = null;
		connectNode(last, node);
		map.put(node.key, node);
		last = node;
	}

	class LRUNode {
		int key, val;
		LRUNode prev, next;

		LRUNode(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}
}