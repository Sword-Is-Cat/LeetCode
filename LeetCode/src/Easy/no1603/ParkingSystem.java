package Easy.no1603;

class ParkingSystem {

	int[] slot;

	public ParkingSystem(int big, int medium, int small) {
		slot = new int[] { big, medium, small };
	}

	public boolean addCar(int carType) {
		
		boolean rst = false;
		
		if(slot[carType - 1]>0) {
			slot[carType - 1]--;
			rst = true;
		}
		
		return rst;
	}
}