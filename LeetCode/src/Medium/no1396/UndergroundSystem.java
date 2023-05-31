package Medium.no1396;

import java.util.HashMap;

class UndergroundSystem {

	HashMap<Integer, Object[]> checkInMap;
	HashMap<String, HashMap<String, double[]>> historyMap;

	public UndergroundSystem() {
		checkInMap = new HashMap<>();
		historyMap = new HashMap<>();
	}

	public void checkIn(int id, String stationName, int t) {
		checkInMap.put(id, new Object[] { stationName, t });
	}

	public void checkOut(int id, String stationName, int t) {
		Object[] checkInLog = checkInMap.remove(id);
		String start = checkInLog[0].toString();
		int startTime = (int) checkInLog[1];
		double[] log = historyMap 
				.computeIfAbsent(start, v -> new HashMap<>())
				.computeIfAbsent(stationName, v -> new double[2]);
		log[0] += t - startTime;
		log[1]++;
	}

	public double getAverageTime(String startStation, String endStation) {
		double[] log = historyMap.get(startStation).get(endStation);
		return log[0] / log[1];
	}
}