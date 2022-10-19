package Medium.no692;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
	public List<String> topKFrequent(String[] words, int k) {

		HashMap<String, WordVO> map = new HashMap<>();
		PriorityQueue<WordVO> que = new PriorityQueue<>();
		ArrayList<String> list = new ArrayList<>();

		for (String word : words) {

			if (!map.containsKey(word))
				map.put(word, new WordVO(word));

			map.get(word).cnt++;

		}

		for (String key : map.keySet())
			que.add(map.get(key));

		while (!que.isEmpty() && k-- > 0)
			list.add(que.poll().word);

		return list;
	}
}

class WordVO implements Comparable<WordVO> {

	String word;
	int cnt;

	WordVO(String word) {
		this.word = word;
		this.cnt = 0;
	}

	@Override
	public int compareTo(WordVO o) {
		return o.cnt - this.cnt == 0 ? this.word.compareTo(o.word) : o.cnt - this.cnt;
	}

}