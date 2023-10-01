package Easy.no557;

class Solution_ {
    public String reverseWords(String s) {
    	
    	String[] arr = s.split(" ");
    	
    	StringBuilder answer = new StringBuilder();
    	
    	for(int i = 0 ; i<arr.length ; i++) {
    		
    		StringBuilder temp = new StringBuilder(arr[i]);
    		
    		if(i!=0)
    			answer.append(' ');
    		
    		answer.append(temp.reverse().toString());
    	}
    	
    	return answer.toString();
        
    }
}