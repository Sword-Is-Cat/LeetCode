package Medium.no729;

import java.util.ArrayList;

class MyCalendar_ {

	ArrayList<int[]> booklist;

	public MyCalendar_() {
		booklist = new ArrayList<>();
	}

	public boolean book(int start, int end) {

		for (int[] book : booklist) {
			if (end > book[0] && start < book[1])
				return false;
		}

		booklist.add(new int[] { start, end });

		return true;
	}
}