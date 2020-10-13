package Challenge.October1st_4;

class Solution {
	public int bitwiseComplement(int N) {
		
		if(N==0)
			return 1;

		int temp = 1;

		while (temp <= N)
			temp *= 2;

		return temp - 1 - N;
		
	}
}