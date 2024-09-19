package Medium.no241;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

	HashMap<String, List<Integer>> cache = new HashMap<>();

	public List<Integer> diffWaysToCompute(String expression) {

		if (!cache.containsKey(expression)) {

			List<Integer> answer = new ArrayList<>();

			for (int i = 0; i < expression.length(); i++) {
				char op = expression.charAt(i);

				if (op == '+' || op == '-' || op == '*') {
					List<Integer> listL = diffWaysToCompute(expression.substring(0, i));
					List<Integer> listR = diffWaysToCompute(expression.substring(i + 1));

					for (int numL : listL) {
						for (int numR : listR) {
							switch (op) {
							case '+':
								answer.add(numL + numR);
								break;
							case '-':
								answer.add(numL - numR);
								break;
							case '*':
								answer.add(numL * numR);
								break;
							}
						}
					}
				}
			}

			if (answer.isEmpty())
				answer.add(Integer.parseInt(expression));
			cache.put(expression, answer);
		}
		return cache.get(expression);
	}
}