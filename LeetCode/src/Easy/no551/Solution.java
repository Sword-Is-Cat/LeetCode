package Easy.no551;

class Solution {
    public boolean checkRecord(String s) {
        
    	char[] arr = s.toCharArray();
    	
    	int late = 0;
    	int absent = 0;
    	
    	boolean answer = true;
    	
    	for(char ch : arr) {
    		if(ch=='L')
    			late++;
    		else
    			late = 0;
    		
    		if(ch=='A')
    			absent++;
    		
    		if(late>2 || absent>1) {
    			answer = false;
    			break;
    		}
    	}
    	
    	return answer;
    	
    }
}