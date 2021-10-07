package Easy.no1295;

class Solution {
    public int findNumbers(int[] nums) {
    	
    	int answer = 0;
    	
    	for(int num : nums) {
    		int length = 0;
    		while(num>0) {
    			num /= 10;
    			length++;
    		}
    		
    		if(length%2==0) answer++;
    	}
    	
    	return answer;
    }
}