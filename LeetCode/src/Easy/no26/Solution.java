package Easy.no26;

class Solution {
    public int removeDuplicates(int[] nums) {
    	
    	if(nums.length ==0)
    		return 0;
    	
    	int temp = nums[0];
    	int node = 0;
    	for(int i = 0;i<nums.length ; i++) {
    		if(temp!=nums[i]) {
    			nums[++node] = nums[i];
    			temp = nums[i];
    		}
    	}
        
    	return node+1;
    }
}