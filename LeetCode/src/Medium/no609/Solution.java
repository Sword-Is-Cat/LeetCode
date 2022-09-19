package Medium.no609;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
	public List<List<String>> findDuplicate(String[] paths) {

		ArrayList<List<String>> ans = new ArrayList<>();
		HashMap<String, HashSet<FileVO>> map = new HashMap<>();

		for (String path : paths) {

			String[] infos = path.split(" ");

			for (int idx = 1; idx < infos.length; idx++) {

				FileVO file = new FileVO(infos[0], infos[idx]);

				if (!map.containsKey(file.content))
					map.put(file.content, new HashSet<>());

				map.get(file.content).add(file);

			}

		}

		for (String key : map.keySet()) {

			if (map.get(key).size() > 1) {

				ArrayList<String> tempList = new ArrayList<>();

				ans.add(tempList);
				for (FileVO file : map.get(key))
					tempList.add(file.fullPath());

			}

		}

		return ans;
	}
}

class FileVO {

	String path;
	String fileName;
	String content;

	FileVO(String _path, String info) {

		int idx = info.indexOf("(");
		String _fileName = info.substring(0, idx);
		String _content = info.substring(idx + 1, info.length() - 1);

		path = _path;
		fileName = _fileName;
		content = _content;

	}

	FileVO(String _path, String _fileName, String _content) {

		path = _path;
		fileName = _fileName;
		content = _content;

	}

	String fullPath() {
		return path + "/" + fileName;
	}

}