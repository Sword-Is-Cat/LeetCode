package Challenge.August1st_4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
    	
    	List<Integer> list = new ArrayList<>();
    	
    	Set<Integer> set = new HashSet<>();
    	
    	for(int i : nums) {
    		if(!set.add(i))
    			list.add(i);
    	}
    	
    	return list;
        
    }
}