package Medium.no341;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

	List<Integer> list;
	int idx = 0;

	public NestedIterator(List<NestedInteger> nestedList) {

		list = new ArrayList<>();
		append(list, nestedList);

	}

	void append(List<Integer> list, List<NestedInteger> nList) {

		for (NestedInteger nInt : nList) {

			if (nInt.isInteger())
				list.add(nInt.getInteger());
			else
				append(list, nInt.getList());
		}
	}

	@Override
	public Integer next() {
		return list.get(idx++);
	}

	@Override
	public boolean hasNext() {
		return idx < list.size();
	}
}