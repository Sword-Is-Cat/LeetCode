package Hard.no1203;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {

	Group[] groups;
	Item[] items;

	public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {

		Queue<Group> gQue = new ArrayDeque<>();

		groups = new Group[m];
		for (int i = 0; i < m; i++) {
			groups[i] = new Group();
			gQue.add(groups[i]);
		}

		items = new Item[n];
		for (int i = 0; i < n; i++) {
			Group myGroup;
			if (group[i] == -1) {
				myGroup = new Group();
				gQue.add(myGroup);
			} else {
				myGroup = groups[group[i]];
			}
			items[i] = new Item(i, myGroup, beforeItems.get(i));
		}

		boolean[] visit = new boolean[n];
		for (Group aGroup : gQue) {
			if (!groupSort(aGroup, visit)) {
				return new int[0];
			}
			Arrays.fill(visit, false);
		}

		int[] ans = new int[n];
		int index = 0;

		HashMap<Group, Integer> counter = new HashMap<>();

		while (!gQue.isEmpty()) {
			Group tGroup = gQue.poll();

			if (!counter.containsKey(tGroup))
				counter.put(tGroup, -1);

			if (counter.get(tGroup) == gQue.size())
				return new int[0];
			else
				counter.put(tGroup, gQue.size());

			boolean flag = true;
			for (int bf : tGroup.befores) {
				if (!visit[bf]) {
					flag = false;
					break;
				}
			}
			if (flag) {
				for (Item item : tGroup.sortedList) {
					ans[index++] = item.no;
					visit[item.no] = true;
				}

			} else {
				gQue.add(tGroup);
			}

		}

		return ans;
	}

	private boolean groupSort(Group group, boolean[] visit) {

		int head = -1, size = -1;

		while (!group.que.isEmpty()) {
			Item item = group.que.poll();
			if (head == -1)
				head = item.no;
			if (head == item.no) {
				if (size == group.que.size())
					return false;
				size = group.que.size();
			}

			boolean flag = true;
			for (int idx : item.before) {
				if (items[idx].group.equals(group)) {
					if (!visit[idx]) {
						flag = false;
						break;
					}
				} else {
					group.befores.add(idx);
				}
			}
			if (flag) {
				group.sortedList.add(item);
				visit[item.no] = true;
			} else {
				group.que.add(item);
			}
		}
		return true;

	}

}

class Group {

	Queue<Item> que;
	List<Item> sortedList;
	Set<Integer> befores;

	Group() {
		que = new ArrayDeque<>();
		sortedList = new ArrayList<>();
		befores = new HashSet<>();
	}
}

class Item {
	Group group;
	List<Integer> before;
	int no;

	Item(int no, Group group, List<Integer> before) {
		this.no = no;
		this.group = group;
		this.before = before;
		group.que.add(this);
	}
}