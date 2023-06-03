package Medium.no1376;

import java.util.ArrayList;

class Solution {
	public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

		Employee[] arr = new Employee[n];
		for (int i = 0; i < n; i++)
			arr[i] = new Employee(informTime[i]);

		for (int i = 0; i < n; i++) {
			if (i == headID)
				continue;
			addUnderling(arr[manager[i]], arr[i]);
		}

		return getInformTime(arr[headID]);

	}

	private void addUnderling(Employee head, Employee underling) {
		if (head == null || underling == null)
			return;
		if (head.underlings == null)
			head.underlings = new ArrayList<>();
		head.underlings.add(underling);
	}

	private int getInformTime(Employee e) {
		if (e.underlings == null || e.underlings.size() == 0)
			return 0;
		int max = 0;
		for (Employee u : e.underlings)
			max = Math.max(max, getInformTime(u));
		return e.informTime + max;
	}

}

class Employee {
	int informTime;
	ArrayList<Employee> underlings;

	Employee(int time) {
		informTime = time;
	}

}