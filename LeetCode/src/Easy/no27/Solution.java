package Easy.no27;

class Solution {
    public int removeElement(int[] nums, int val) {
        
        int readNode = 0;
        int writeNode = 0;
        
        while(readNode<nums.length){
            
            if(nums[readNode]==val){
                readNode++;
            }else{
                nums[writeNode] = nums[readNode];
                writeNode++;
                readNode++;
            }
        }
        
        return writeNode;
    }
}
