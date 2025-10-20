package Easy.no2011;

class Solution {
	public int finalValueAfterOperations(String[] operations) {

		int result = 0;

		for (String oper : operations) {
			if (oper.charAt(1) == '+')
				result++;
			else
				result--;
		}
		return result;

	}
}