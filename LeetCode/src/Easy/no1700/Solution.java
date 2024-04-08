package Easy.no1700;

class Solution {
	public int countStudents(int[] students, int[] sandwiches) {

		int circle = 0, rectangle = 0;

		for (int student : students) {
			if (student == 1) {
				rectangle++;
			} else {
				circle++;
			}
		}

		for (int sandwich : sandwiches) {
			if (sandwich == 1) {
				if (rectangle-- == 0)
					return circle;
			} else {
				if (circle-- == 0)
					return rectangle;
			}
		}

		return 0;
	}
}