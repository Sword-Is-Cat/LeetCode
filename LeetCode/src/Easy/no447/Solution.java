package Easy.no447;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfBoomerangs(int[][] points) {
    	
    	int answer = 0;
    	
    	for(int[] arr1 : points) {
    		
    		Map<Integer, Integer> map = new HashMap<>();
    		
    		for(int[] arr2: points) {
    			
    			int dist = dist(arr1, arr2);
    			
    			if(map.containsKey(dist))
    				map.put(dist, map.get(dist)+1);
    			else
    				map.put(dist,1);
    		}
    		
    		for(int i : map.keySet())
    			answer += combi(map.get(i));
    	}
    	
        return answer*2;
    }
    
    int dist(int[] arr1, int[]arr2) {
    	return (arr2[0]-arr1[0])*(arr2[0]-arr1[0])+(arr2[1]-arr1[1])*(arr2[1]-arr1[1]);
    }
    
    int combi(int i) {
    	return i*(i-1)/2;
    }
}