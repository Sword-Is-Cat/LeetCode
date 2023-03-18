package Medium.no1472;

class BrowserHistory {

	HistoryNode curr;

	public BrowserHistory(String homepage) {
		curr = new HistoryNode(homepage);
	}

	public void visit(String url) {
		curr = new HistoryNode(url, curr);
	}

	public String back(int steps) {
		while (steps-- > 0 && curr.prev != null)
			curr = curr.prev;
		return curr.url;
	}

	public String forward(int steps) {
		while (steps-- > 0 && curr.next != null)
			curr = curr.next;
		return curr.url;
	}
}

class HistoryNode {

	HistoryNode prev, next;
	String url;

	HistoryNode(String url) {
		this.url = url;
	}

	HistoryNode(String url, HistoryNode prev) {
		this(url);
		this.prev = prev;
		prev.next = this;
	}

}