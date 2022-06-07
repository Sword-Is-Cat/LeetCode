package Medium.no134;

class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {

		for (int i = 0; i < gas.length; i++)
			gas[i] -= cost[i];

		int min = Integer.MAX_VALUE;
		int idx = -1;
		int temp = 0;

		for (int i = 0; i < gas.length; i++) {
			temp += gas[i];
			if (temp < min) {
				min = temp;
				idx = i;
			}
		}

		idx++;
		int tank = 0;

		for (int i = 0; i < gas.length; i++) {
			tank += gas[(idx + i) % gas.length];
			if (tank < 0)
				return -1;
		}

		return idx % gas.length;
	}
}