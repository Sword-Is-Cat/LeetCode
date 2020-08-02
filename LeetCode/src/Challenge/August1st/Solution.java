package Challenge.August1st;

class Solution {
    public boolean detectCapitalUse(String word) {
    	
    	boolean answer = false;
    	
    	if(word.equals(word.toUpperCase()))
    		answer = true;
    	else if(word.substring(1).equals(word.substring(1).toLowerCase()))
    		answer = true;
    	
    	return answer;
        
    }
}