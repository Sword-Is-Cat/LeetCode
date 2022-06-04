package Medium.no102;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	
    	List<List<Integer>> result = new ArrayList<>();
    	if(root==null) return result;
    	
    	List<List<TreeNode>> bigList = new ArrayList<>();
    	List<TreeNode> list = new ArrayList<>();
    	List<TreeNode> newList = null;
    	list.add(root);
    	
    	while(list.size()>0) {
    		
    		bigList.add(list);
    		newList = new ArrayList<>();
    		
    		for(TreeNode node : list) {
    			if(node.left!=null)
    				newList.add(node.left);
    			if(node.right!=null)
    				newList.add(node.right);
    		}
    		
    		list = newList;
    	}
    	
    	for(int i = 0 ; i<bigList.size() ; i++) {
    		
    		result.add(new ArrayList<>());
    		
    		for(TreeNode node : bigList.get(i))
    			result.get(i).add(node.val);
    	}
        
    	return result;
    }
}