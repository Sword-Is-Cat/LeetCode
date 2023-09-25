package Easy.no389;

class Solution_ {
    public char findTheDifference(String s, String t) {
    	
    	char[] sArr = s.toCharArray();
    	char[] tArr = t.toCharArray();
    	
    	char answer = 0;
    	
    	for(char ch : sArr)
    		answer ^= ch;
    	
    	for(char ch : tArr)
    		answer ^= ch;
    	
    	return answer;
        
    }
}