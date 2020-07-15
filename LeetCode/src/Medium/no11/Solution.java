package Medium.no11;

class Solution {
    public int maxArea(int[] height) {
    	
    	int answer = 0;
    	
    	int i = 0;
    	int j = height.length-1;
    	
    	while(i<j) {
    		int area = (j-i) * (Math.min(height[i], height[j]));
    		answer = (answer<area)?area:answer;
    		
    		if(height[i]<height[j])
    			i++;
    		else
    			j--;
    	}
    	
    	return answer;
        
    }
}