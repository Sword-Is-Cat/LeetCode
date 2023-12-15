package Easy.no1436;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution_ {
	public String destCity(List<List<String>> paths) {

		Set<String> cityS = new HashSet<>(), cityE = new HashSet<>();

		for (List<String> path : paths) {
			cityS.add(path.get(0));
			cityE.add(path.get(1));
		}
		
		cityE.removeAll(cityS);

		return cityE.iterator().next();
	}
}