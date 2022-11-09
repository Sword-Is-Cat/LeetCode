package Medium.no901;

public class StockSpanner {

	StockNode prev;
	int idx;

	public StockSpanner() {
		idx = 0;
		prev = new StockNode(idx, Integer.MAX_VALUE, null);
	}

	public int next(int price) {
		StockNode node = new StockNode(++idx, price, prev);
		prev = node;
		return node.idx - node.biggerPT.idx;
	}
}

class StockNode {

	StockNode biggerPT;
	int idx;
	int price;

	StockNode(int idx, int price, StockNode prev) {

		this.idx = idx;
		this.price = price;

		while (prev != null && prev.price <= price) {
			prev = prev.biggerPT;
		}

		this.biggerPT = prev;

	}
}