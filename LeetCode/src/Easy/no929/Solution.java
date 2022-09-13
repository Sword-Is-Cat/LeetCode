package Easy.no929;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numUniqueEmails(String[] emails) {
    	
    	Set<String> set = new HashSet<>();
    	
    	for(String email : emails) {
    		
    		String[] mail = email.split("@");
    		
    		set.add(mail[0].split("\\+")[0].replace(".", "").concat("@").concat(mail[1]));
    		
    	}
    	
    	return set.size();
        
    }
}