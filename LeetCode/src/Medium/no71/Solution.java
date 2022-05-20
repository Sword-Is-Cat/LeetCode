package Medium.no71;

import java.util.LinkedList;

class Solution {
	public String simplifyPath(String path) {

		String[] paths = path.split("/");
		LinkedList<String> list = new LinkedList<>();

		for (String directory : paths) {
			switch (directory) {
			case "":
			case ".":
				break;
			case "..":
				if (!list.isEmpty())
					list.pollLast();
				break;
			default:
				list.add(directory);

			}
		}

		StringBuilder sb = new StringBuilder();

		for (String directory : list)
			sb.append("/").append(directory);

		return sb.length() == 0 ? "/" : sb.toString();
	}
}