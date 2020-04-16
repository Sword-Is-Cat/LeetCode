package Easy.no88;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	
    	int[] nums3 = new int[m];
    	
    	for(int i = 0 ; i<m ; i++) {
    		nums3[i] = nums1[i];
    	}
    	
    	int i = 0,j = 0;
    	
    	while(i<m && j<n) {
    		nums1[i+j] = (nums3[i] > nums2[j])? nums2[j++]:nums3[i++];
    	}
    	
    	if(i<m)
    		while(i<m)
    			nums1[i+j] = nums3[i++];
    	else
    		while(j<n)
    			nums1[i+j] = nums2[j++];
    }
}