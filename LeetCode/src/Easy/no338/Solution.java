package Easy.no338;

class Solution {
    public int[] countBits(int n) {
        
    	int[] answer = new int[n+1];
    	
    	for(int i = 0 ; i<=n ; i++) {
    		
    		answer[i] = Integer.toString(i, 2).replace("0", "").length();
    		
    	}
    	
    	return answer;
    	
    }
}