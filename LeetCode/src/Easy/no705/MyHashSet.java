package Easy.no705;

class MyHashSet {

	boolean[] exist;

	public MyHashSet() {
		exist = new boolean[(int) 10e6 + 1];
	}

	public void add(int key) {
		exist[key] = true;
	}

	public void remove(int key) {
		exist[key] = false;
	}

	public boolean contains(int key) {
		return exist[key];
	}
}