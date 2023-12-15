package Easy.no1436;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	public String destCity(List<List<String>> paths) {

		Map<String, String> graph = new HashMap<>();

		for (List<String> path : paths) {
			String st = path.get(0), ed = path.get(1);
			graph.put(st, ed);
		}

		String city = paths.get(0).get(0);

		while (graph.containsKey(city)) {
			city = graph.get(city);
		}

		return city;
	}
}