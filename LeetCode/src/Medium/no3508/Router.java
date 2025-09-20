package Medium.no3508;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

class Router {

	Queue<Packet> queue;
	Set<Packet> duplCheck;
	Map<Integer, List<Packet>> destToTime;
	int availSlot;

	public Router(int memoryLimit) {
		queue = new LinkedList<>();
		duplCheck = new HashSet<>();
		destToTime = new HashMap<>();
		this.availSlot = memoryLimit;
	}

	public boolean addPacket(int source, int destination, int timestamp) {

		Packet packet = new Packet(source, destination, timestamp);

		// 중복 체크
		if (!duplCheck.add(packet)) {
			return false;
		}

		// 추가 로직
		queue.offer(packet);
		if (!destToTime.containsKey(packet.destination))
			destToTime.put(packet.destination, new ArrayList<>());
		destToTime.get(packet.destination).add(packet);
		availSlot--;

		// 메모리제한 체크
		if (availSlot < 0) {
			forwardPacket();
		}
		return true;
	}

	public int[] forwardPacket() {
		Packet packet = queue.poll();
		if (packet == null)
			return new int[] {};
		duplCheck.remove(packet);
		destToTime.get(packet.destination).remove(0);
		availSlot++;
		return packet.value();
	}

	public int getCount(int destination, int startTime, int endTime) {
		List<Packet> packets = destToTime.get(destination);
		if (packets == null)
			return 0;
		return biSrch(packets, endTime, true) - biSrch(packets, startTime, false);
	}

	private int biSrch(List<Packet> packets, int target, boolean include) {

		int left = -1, right = packets.size();

		while (left + 1 < right) {
			int mid = (left + right) / 2;
			int time = packets.get(mid).timestamp;
			if (time < target || (include && time == target)) {
				left = mid;
			} else {
				right = mid;
			}
		}

		return left;
	}

	class Packet {
		int source, destination, timestamp;

		Packet(int source, int destination, int timestamp) {
			this.source = source;
			this.destination = destination;
			this.timestamp = timestamp;
		}

		int[] value() {
			return new int[] { source, destination, timestamp };
		}

		@Override
		public int hashCode() {
			return Objects.hash(source, destination, timestamp);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Packet) {
				Packet target = (Packet) obj;
				return this.source == target.source && this.destination == target.destination
						&& this.timestamp == target.timestamp;
			}
			return false;
		}
	}

}
