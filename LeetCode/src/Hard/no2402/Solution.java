package Hard.no2402;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
	public int mostBooked(int n, int[][] meetings) {

		// room = [roomNo, endTime, useCount]
		PriorityQueue<long[]> roomUseable = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
		PriorityQueue<long[]> roomInUse = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
		long[][] rooms = new long[n][];

		for (int i = 0; i < n; i++) {
			rooms[i] = new long[] { i, 0, 0 };
			roomInUse.add(rooms[i]);
		}

		Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

		for (int[] meeting : meetings) {

			while (!roomInUse.isEmpty() && roomInUse.peek()[1] <= meeting[0]) {
				roomUseable.add(roomInUse.poll());
			}

			if (roomUseable.isEmpty()) {
				long waitTo = roomInUse.peek()[1];
				while (!roomInUse.isEmpty() && roomInUse.peek()[1] <= waitTo) {
					roomUseable.add(roomInUse.poll());
				}
			}

			long[] room = roomUseable.poll();
			room[1] = meeting[1] - meeting[0] + Math.max(room[1], meeting[0]);
			room[2]++;
			roomInUse.add(room);

		}

		int roomNo = -1;
		long cnt = 0;
		for (int i = 0; i < n; i++) {
			if (cnt < rooms[i][2]) {
				cnt = rooms[i][2];
				roomNo = i;
			}
		}
		return roomNo;
	}
}