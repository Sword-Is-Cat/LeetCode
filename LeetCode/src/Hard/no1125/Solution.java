package Hard.no1125;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

	boolean[] ans;
	int cnt = Integer.MAX_VALUE;

	public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {

		HashMap<String, ArrayList<Integer>> skill_map = new HashMap<>();
		List<List<Integer>> skill_owner = new ArrayList<>();

		for (int i = 0; i < req_skills.length; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			skill_map.put(req_skills[i], list);
			skill_owner.add(list);
		}

		for (int worker = 0; worker < people.size(); worker++) {
			for (String skill : people.get(worker)) {
				skill_map.get(skill).add(worker);
			}
		}

		skill_owner.sort((a, b) -> a.size() - b.size());

		boolean[] visit = new boolean[people.size()];

		dfs(skill_owner, visit, 0);

		return getAnswer();
	}

	private void dfs(List<List<Integer>> skill_owners, boolean[] visit, int index) {

		if (index == skill_owners.size()) {
			int myCnt = cntTrue(visit);
			if (cnt > myCnt) {
				ans = visit.clone();
				cnt = myCnt;
			}
			return;
		}

		List<Integer> owners = skill_owners.get(index);
		boolean exist = false;
		for (int owner : owners) {
			exist |= visit[owner];
		}

		if (exist) {
			dfs(skill_owners, visit, index + 1);
		} else {
			for (int owner : owners) {
				visit[owner] = true;
				dfs(skill_owners, visit, index + 1);
				visit[owner] = false;
			}
		}

	}

	private int cntTrue(boolean[] array) {
		int cnt = 0;
		for (boolean flag : array)
			cnt += flag ? 1 : 0;
		return cnt;
	}

	private int[] getAnswer() {
		int[] result = new int[cnt];
		for (int idx = 0, worker = 0; worker < ans.length; worker++) {
			if (ans[worker]) {
				result[idx++] = worker;
			}
		}
		return result;
	}
}