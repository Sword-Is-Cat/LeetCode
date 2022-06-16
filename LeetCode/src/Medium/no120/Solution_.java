package Medium.no120;

import java.util.List;

class Solution_ {
	public int minimumTotal(List<List<Integer>> triangle) {

		for (int idx = 1; idx < triangle.size(); idx++) {

			List<Integer> list = triangle.get(idx);
			List<Integer> prelist = triangle.get(idx - 1);

			for (int i = 0; i < list.size(); i++) {

				if (i == 0) {
					list.set(i, list.get(i) + prelist.get(i));
				} else if (i == list.size() - 1) {
					list.set(i, list.get(i) + prelist.get(prelist.size() - 1));
				} else {
					list.set(i, list.get(i) + Math.min(prelist.get(i), prelist.get(i - 1)));
				}
			}
		}

		int result = Integer.MAX_VALUE;

		List<Integer> lastlist = triangle.get(triangle.size() - 1);

		for (int sum : lastlist)
			result = Math.min(result, sum);

		return result;
	}
}