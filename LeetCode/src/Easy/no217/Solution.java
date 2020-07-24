package Easy.no217;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
    	
    	Set<Integer> set = new HashSet<>();
    	
    	for(int i : nums)
    		if(!set.add(i))
    			return true;
    	
    	return false;
        
    }
}