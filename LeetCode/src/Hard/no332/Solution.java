package Hard.no332;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class Solution {

	List<String> ans = null;
	int cntAll = 0;

	public List<String> findItinerary(List<List<String>> tickets) {

		Ticket[] tArr = new Ticket[tickets.size()];
		cntAll = tickets.size();

		Map<String, List<Ticket>> map = new HashMap<>();

		for (int i = 0; i < tArr.length; i++) {
			tArr[i] = new Ticket(tickets.get(i).get(0), tickets.get(i).get(1));
		}

		Arrays.sort(tArr, (a, b) -> a.compareTo(b));
		for (int i = 0; i < tArr.length; i++) {
			map.putIfAbsent(tArr[i].fromCity, new ArrayList<>());
			map.get(tArr[i].fromCity).add(tArr[i]);
		}

		Stack<String> container = new Stack<>();
		container.add("JFK");

		dfs(container, map);

		return ans;
	}

	void dfs(Stack<String> container, Map<String, List<Ticket>> map) {

		if (ans != null)
			return;

		if (cntAll < container.size()) {
			ans = new ArrayList<>(container);
		}

		String currentCity = container.peek();

		if (!map.containsKey(currentCity))
			return;

		for (Ticket ticket : map.get(currentCity)) {
			if (!ticket.visit) {
				ticket.visit = true;
				container.add(ticket.toCity);
				dfs(container, map);
				ticket.visit = false;
				container.pop();
			}
		}

	}
}

class Ticket {

	String fromCity, toCity;
	boolean visit;

	Ticket(String from, String to) {
		fromCity = from;
		toCity = to;
		visit = false;
	}

	public int compareTo(Object obj) {
		if (obj instanceof Ticket) {
			Ticket target = (Ticket) obj;
			int rst = this.fromCity.compareTo(target.fromCity);
			if (rst == 0)
				rst = this.toCity.compareTo(target.toCity);
			return rst;
		}
		return 0;
	}

}