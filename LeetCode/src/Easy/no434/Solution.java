package Easy.no434;

class Solution {
    public int countSegments(String s) {
        
    	String[] arr = s.split(" ");
    	
    	int answer = arr.length;
    	
    	for(String str : arr)
    		if(str.equals(""))
    			answer--;
    	
    	return answer;
    }
}