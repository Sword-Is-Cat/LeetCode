package Easy.no2485;

class Solution {
	public int pivotInteger(int n) {

		int square = n * (n + 1) / 2;
		int route = (int) Math.sqrt(square);

		return route * route == square ? route : -1;
	}
}
