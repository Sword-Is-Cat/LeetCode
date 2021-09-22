package Easy.no690;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	
	Map<Integer, Employee> EmpIdMap = new HashMap<>();
	
    public int getImportance(List<Employee> employees, int id) {
    	
    	for(Employee emp : employees) {
    		EmpIdMap.put(emp.id, emp);
    	}
    	
    	return sumOfImportance(id);
        
    }
    
    public int sumOfImportance(int empId) {
    	
    	Employee emp = EmpIdMap.get(empId);
    	
    	int importance = emp.importance;
    	
    	for(int subId : emp.subordinates) {
    		importance += sumOfImportance(subId);
    	}
    	
    	return importance;
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}