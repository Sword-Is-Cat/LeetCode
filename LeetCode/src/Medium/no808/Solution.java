package Medium.no808;

import java.util.HashMap;

class Solution {

	HashMap<Pair, Double> dpMap = new HashMap<>();

	public double soupServings(int n) {
		if (n > 5000)
			return 1D;
		return calcDP(n, n);
	}

	private double calcDP(int a, int b) {

		if (a <= 0 && b <= 0)
			return 0.5D;
		if (a <= 0)
			return 1D;
		if (b <= 0)
			return 0D;

		Pair myPair = new Pair(a, b);

		if (!dpMap.containsKey(myPair)) {
			double rst = 0D;
			rst += calcDP(a - 100, b);
			rst += calcDP(a - 75, b - 25);
			rst += calcDP(a - 50, b - 50);
			rst += calcDP(a - 25, b - 75);
			dpMap.put(myPair, rst / 4D);
		}
		return dpMap.get(myPair);
	}

	class Pair {
		int a, b;

		Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int hashCode() {
			return a + b;
		}

		@Override
		public boolean equals(Object obj) {
			return obj instanceof Pair && ((Pair) obj).a == a && ((Pair) obj).b == b;
		}
	}

}