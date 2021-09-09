package Easy.no171;

class Solution {
    public int titleToNumber(String s) {
    	
    	char[] arr = s.toCharArray();
    	
    	int answer = 0;
    	
    	for(char ch : arr) {
    		answer *=26;
    		answer += ch-64;
    	}
    	
    	return answer;
        
    }
}