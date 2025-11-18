package Easy.no717;

class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        for(int i = 0;i<bits.length;i++){
            if(bits[i]==1){
                if(i+1 == bits.length){
                    return false;
                }
                i++;
            }else if(i+1 == bits.length){
                return true;
            }
        }
        return false;
    }
}