package Medium.no227;

import java.util.Arrays;

class Solution {
	public int calculate(String s) {

		s = s.replaceAll(" ", "");

		String[] numbers = s.split("[^0-9]+");
		String[] calcs = s.split("[0-9]+");

		int[] vals = new int[numbers.length];
		int[] positions = new int[numbers.length];

		Arrays.fill(positions, -1);

		for (int i = 0; i < vals.length; i++)
			vals[i] = Integer.parseInt(numbers[i]);

		for (int i = 1; i < calcs.length; i++) {

			String calc = calcs[i];

			int prevIdx = findPosition(positions, i - 1);

			if ("*".equals(calc)) {

				vals[prevIdx] *= vals[i];
				setPosition(positions, i, prevIdx);

			} else if ("/".equals(calc)) {

				vals[prevIdx] /= vals[i];
				setPosition(positions, i, prevIdx);

			}

		}

		for (int i = 1; i < calcs.length; i++) {

			String calc = calcs[i];

			int prevIdx = findPosition(positions, i - 1);

			if ("+".equals(calc)) {

				vals[prevIdx] += vals[i];
				setPosition(positions, i, prevIdx);

			} else if ("-".equals(calc)) {

				vals[prevIdx] -= vals[i];
				setPosition(positions, i, prevIdx);

			}

		}

		return vals[0];

	}

	int findPosition(int[] positions, int idx) {
		return positions[idx] == -1 ? idx : findPosition(positions, positions[idx]);
	}

	void setPosition(int[] positions, int idx, int newIdx) {
		positions[idx] = findPosition(positions, newIdx);
	}

	public static void main(String[] args) {
		System.out.println(new Solution().calculate("222+15+879"));
	}
}