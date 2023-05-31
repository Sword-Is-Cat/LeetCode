package Medium.no1396;

import java.util.HashMap;
import java.util.Map;

class UndergroundSystem_ {

	Map<Integer, CheckInVO> checkInMap;
	Map<String, AverageTimeVO> avrTimeMap;

	public UndergroundSystem_() {
		checkInMap = new HashMap<>();
		avrTimeMap = new HashMap<>();
	}

	public void checkIn(int id, String stationName, int t) {
		checkInMap.put(id, new CheckInVO(stationName, t));
	}

	public void checkOut(int id, String stationName, int t) {
		if (checkInMap.containsKey(id)) {

			CheckInVO temp = checkInMap.get(id);
			checkInMap.remove(id, temp);

			String moveKey = temp.stationName + "|" + stationName;
			int moveTime = t - temp.time;

			if (!avrTimeMap.containsKey(moveKey))
				avrTimeMap.put(moveKey, new AverageTimeVO());

			avrTimeMap.get(moveKey).addTime(moveTime);

		}
	}

	public double getAverageTime(String startStation, String endStation) {
		String moveKey = startStation + "|" + endStation;
		return avrTimeMap.get(moveKey).getAverage();
	}
}

class CheckInVO {
	String stationName;
	int time;

	CheckInVO(String stationName, int time) {
		this.stationName = stationName;
		this.time = time;
	}
}

class AverageTimeVO {

	int cnt;
	int time;

	AverageTimeVO() {
		cnt = 0;
		time = 0;
	}

	void addTime(int t) {
		cnt++;
		time += t;
	}

	double getAverage() {
		return (double) time / cnt;
	}

}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t); obj.checkOut(id,stationName,t); double param_3
 * = obj.getAverageTime(startStation,endStation);
 */