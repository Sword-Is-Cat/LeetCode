package Medium.no1352;

import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {

	List<Integer> prodList;
	int size;

	public ProductOfNumbers() {
		prodList = new ArrayList<>();
		prodList.add(1);
		size = 0;
	}

	public void add(int num) {
		if (num == 0) {
			prodList.clear();
			prodList.add(1);
			size = 0;
		} else {
			prodList.add(prodList.get(size) * num);
			size++;
		}
	}

	public int getProduct(int k) {
		if (k > size)
			return 0;
		return prodList.get(size) / prodList.get(size - k);
	}
}