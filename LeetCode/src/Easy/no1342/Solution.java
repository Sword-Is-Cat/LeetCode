package Easy.no1342;

class Solution {
	public int numberOfSteps(int num) {

		int rst = 0;

		while (num > 0) {
			rst += num % 2 == 0 ? 1 : 2;
			num /= 2;
		}
		return rst > 0 ? rst - 1 : rst;
	}
}