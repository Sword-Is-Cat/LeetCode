package Easy.no107;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

class Solution {
    
    List<List<Integer>> dummy = new ArrayList<>();
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        process(root, 0);
        
        List<List<Integer>> answer = new ArrayList<>();
        
        for(int i = 0 ; i<dummy.size() ; i++){
            answer.add(dummy.get(dummy.size()-1-i));
        }
        
        return answer;
        
    }
    
    public void process (TreeNode node, int i){
        if(node==null)
            return;
        
        if(dummy.size() = i)
            dummy.add(new ArrayList<Integer>());
      
        dummy.get(i).add(node.val);
                
        process(node.left, i+1);
        process(node.right, i+1);
    }
}
