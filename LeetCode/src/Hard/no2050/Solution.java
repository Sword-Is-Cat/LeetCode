package Hard.no2050;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public int minimumTime(int n, int[][] relations, int[] time) {

		Course[] courses = new Course[n + 1];
		while (n > 0) {
			courses[n--] = new Course(time[n]);
		}

		for (int[] rel : relations) {
			courses[rel[1]].prevCourses.add(courses[rel[0]]);
		}

		int ans = 0;

		for (int i = 1; i < courses.length; i++) {
			ans = Math.max(ans, courses[i].getTotalTake());
		}

		return ans;
	}
}

class Course {

	int take, totalTake;
	List<Course> prevCourses;

	Course(int take) {
		this.take = take;
		this.totalTake = 0;
		prevCourses = new ArrayList<>();
	}

	int getTotalTake() {
		if (totalTake == 0) {
			int maxTake = 0;
			for (Course course : prevCourses) {
				maxTake = Math.max(maxTake, course.getTotalTake());
			}
			totalTake = take + maxTake;
		}
		return totalTake;
	}

}