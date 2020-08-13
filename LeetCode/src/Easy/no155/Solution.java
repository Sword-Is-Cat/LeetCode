package Easy.no155;

import java.util.ArrayList;
import java.util.List;

class MinStack {
	
	List<Integer> list;
	int size;
	
    public MinStack() {
    	
    	list = new ArrayList<>();
    	size = 0;
        
    }
    
    public void push(int x) {
    	
    	list.add(x);
    	size++;
        
    }
    
    public void pop() {
    	
    	if(size!=0)
    		list.remove(--size);
    	
    }
    
    public int top() {
    	
    	return list.get(size-1);
        
    }
    
    public int getMin() {
    	
    	int min = list.get(0);
    	
    	for(int i : list)
    		min = Math.min(min, i);
    	
    	return min;
        
    }
}