package Easy.no69;

class Solution {
	public int mySqrt(int x) {

		long lo;
		
		for(int i = 0 ; ;i++) {
			lo = (long) i * i;
			if(lo > x)
				return i-1;
		}

	}
	
}