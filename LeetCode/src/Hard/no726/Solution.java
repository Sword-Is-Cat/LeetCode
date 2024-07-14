package Hard.no726;

import java.util.Map;
import java.util.TreeMap;

class Solution {
	public String countOfAtoms(String formula) {

		AtomCounter root = new AtomCounter(), node = root;
		String digit = "";

		for (int i = 0; i < formula.length(); i++) {
			char ch = formula.charAt(i);
			if (Character.isDigit(ch)) {
				digit += ch;
			} else {

				if (!digit.isEmpty()) {
					node.multiply(Integer.parseInt(digit));
					digit = "";
				}

				if (Character.isUpperCase(ch)) {
					node = new AtomCounter(ch, node);
				} else if (Character.isLowerCase(ch)) {
					node.name += ch;
				} else if (ch == '(') {
					node = new AtomCounter(ch, node);
				} else if (ch == ')') {
					node = node.parent;
				}

			}
		}

		if (!digit.isEmpty()) {
			node.multiply(Integer.parseInt(digit));
			digit = "";
		}

		Map<String, Integer> map = new TreeMap<>();
		countingNodes(map, root.next);

		StringBuilder sb = new StringBuilder();
		for (String key : map.keySet()) {
			sb.append(key);
			if (map.get(key) > 1) {
				sb.append(map.get(key));
			}
		}

		return sb.toString();
	}

	private void countingNodes(Map<String, Integer> map, AtomCounter node) {
		if (node == null) {
			return;
		}
		if (!node.isGroup) {
			map.put(node.name, map.getOrDefault(node.name, 0) + node.cnt);
		}
		countingNodes(map, node.child);
		countingNodes(map, node.next);
	}
}

class AtomCounter {

	String name;
	int cnt;
	boolean isGroup;
	AtomCounter prev, next, child, parent;

	AtomCounter() {
		this(false, ' ', null);
	}

	AtomCounter(char atom) {
		this(atom == '(', atom == '(' ? ' ' : atom, null);
	}

	AtomCounter(AtomCounter prev) {
		this(false, ' ', prev);
	}

	AtomCounter(char atom, AtomCounter prev) {
		this(atom == '(', atom == '(' ? ' ' : atom, prev);
	}

	AtomCounter(boolean isGroup, char atom, AtomCounter prev) {
		this.name = String.valueOf(atom);
		this.cnt = 1;
		this.isGroup = isGroup;
		if (prev != null && prev.isGroup && prev.child == null) {
			prev.child = this;
			this.prev = prev;
			this.parent = prev;
		} else {
			if (prev != null) {
				prev.next = this;
				this.parent = prev.parent;
			}
			this.prev = prev;
		}
	}

	void multiply(int c) {
		this.cnt *= c;
		if (child != null) {
			child.multiply(c);
		}
		if (next != null) {
			next.multiply(c);
		}
	}

}