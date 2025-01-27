package Hard.no2127;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {

	public int maximumInvitations(int[] favorite) {

		int n = favorite.length;
		List<List<Integer>> graph = new ArrayList<>(n);

		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int person = 0; person < n; person++) {
			graph.get(favorite[person]).add(person);
		}

		int longestCycle = 0;
		int twoCycleInvitations = 0;
		boolean[] visited = new boolean[n];

		for (int person = 0; person < n; person++) {
			if (!visited[person]) {
				Map<Integer, Integer> visitedPersons = new HashMap<>();
				int currentPerson = person;
				int distance = 0;
				while (true) {
					if (visited[currentPerson])
						break;
					visited[currentPerson] = true;
					visitedPersons.put(currentPerson, distance++);
					int nextPerson = favorite[currentPerson];

					if (visitedPersons.containsKey(nextPerson)) {
						int cycleLength = distance - visitedPersons.get(nextPerson);
						longestCycle = Math.max(longestCycle, cycleLength);

						if (cycleLength == 2) {
							Set<Integer> visitedNodes = new HashSet<>();
							visitedNodes.add(currentPerson);
							visitedNodes.add(nextPerson);
							twoCycleInvitations += 2 + bfs(nextPerson, visitedNodes, graph)
									+ bfs(currentPerson, visitedNodes, graph);
						}
						break;
					}
					currentPerson = nextPerson;
				}
			}
		}
		return Math.max(longestCycle, twoCycleInvitations);
	}

	private int bfs(int startNode, Set<Integer> visited, List<List<Integer>> graph) {

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { startNode, 0 });

		int maxDistance = 0;

		while (!queue.isEmpty()) {

			int[] current = queue.poll();
			int currNode = current[0], currDist = current[1];
			maxDistance = Math.max(maxDistance, currDist);

			for (int next : graph.get(currNode)) {

				if (visited.contains(next))
					continue;

				visited.add(next);
				queue.offer(new int[] { next, currDist + 1 });
			}
		}
		return maxDistance;
	}
}