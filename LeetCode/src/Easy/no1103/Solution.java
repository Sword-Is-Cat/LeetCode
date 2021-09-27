package Easy.no1103;

class Solution {
	public int[] distributeCandies(int candies, int num_people) {
        
    	int[] arr = new int[num_people];
    	int i = 0;
    	int cnt = 1;
    	
    	while(candies>=cnt) {
    		arr[i]+=cnt;
    		candies-=cnt;
    		
    		i++;
    		cnt++;
    		
    		if(i==num_people)i=0;
    	}
    	
    	arr[i]+=candies;
    	
    	return arr;
    	
    }
}