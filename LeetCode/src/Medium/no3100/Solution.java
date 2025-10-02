package Medium.no3100;

class Solution {
	public int maxBottlesDrunk(int numBottles, int numExchange) {
		int drunk = 0;
		while (numBottles >= numExchange) {
			numBottles -= numExchange - 1;
			drunk += numExchange++;
		}
		return drunk + numBottles;
	}
}