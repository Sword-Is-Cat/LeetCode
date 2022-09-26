package Medium.no990;

class Solution {

	int[] value = new int[26];
	boolean isPrint = false;

	public boolean equationsPossible(String[] equations) {

		for (int i = 0; i < value.length; i++)
			value[i] = i;

		for (String equation : equations) {

			if (equation.charAt(1) == '=') {
				if (isPrint)
					System.out.println(equation);
				setValue((int) (equation.charAt(0) - 'a'), (int) (equation.charAt(3) - 'a'));
			}

		}

		for (String equation : equations) {
			if (equation.charAt(1) == '!') {
				if (isPrint)
					System.out.println(equation);
				int aVal = getValue((int) (equation.charAt(0) - 'a')),
						bVal = getValue((int) (equation.charAt(3) - 'a'));
				if (aVal == bVal)
					return false;
			}
		}

		return true;
	}

	void setValue(int a, int b) {

		int aVal = getValue(a), bVal = getValue(b);

		int mVal = Math.min(aVal, bVal);

		value[a] = mVal;
		value[aVal] = mVal;
		value[b] = mVal;
		value[bVal] = mVal;

		if (isPrint)
			System.out.println("set Value : " + a + "," + aVal + "," + b + "," + bVal + " => " + mVal);

	}

	int getValue(int i) {

		if (value[i] != i)
			value[i] = getValue(value[i]);

		if (isPrint)
			System.out.println("get Value : " + i + " => " + value[i]);

		return value[i];
	}

	public static void main(String[] args) {

		Solution solution = new Solution();
		solution.isPrint = true;
		boolean rst = solution.equationsPossible(new String[] { "b!=f", "c!=e", "f==f", "d==f", "b==f", "a==f" });
		System.out.println(rst);

	}
}