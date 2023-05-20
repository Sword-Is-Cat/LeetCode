package Medium.no399;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Solution {
	Map<String, Map<String, Double>> map = new HashMap<>();
	Set<String> seen = new HashSet<>();

	private double dfs(String s, String target, double num) {
		if (!map.containsKey(s))
			return -1.0;
		if (s.equals(target))
			return num;
		seen.add(s);

		for (Entry<String, Double> div : map.get(s).entrySet()) {
			if (!seen.contains(div.getKey())) {
				double ans = dfs(div.getKey(), target, div.getValue());

				if (ans != -1)
					return num * ans;
			}
		}
		return -1.0;
	}

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		int n = queries.size();
		double[] ans = new double[n];

		for (int i = 0; i < equations.size(); i++) {
			map.putIfAbsent(equations.get(i).get(0), new HashMap<>());
			map.putIfAbsent(equations.get(i).get(1), new HashMap<>());

			map.get(equations.get(i).get(0)).put(equations.get(i).get(1), values[i]);
			map.get(equations.get(i).get(1)).put(equations.get(i).get(0), 1 / values[i]);
		}
		for (int i = 0; i < n; i++) {
			seen.clear();
			ans[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), 1.0);
		}
		return ans;
	}
}