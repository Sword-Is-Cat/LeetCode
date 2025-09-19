package Medium.no3484;

import java.util.HashMap;

class Spreadsheet {

	HashMap<String, Integer> map;
	int maxRow;

	public Spreadsheet(int rows) {
		map = new HashMap<>();
		maxRow = rows;
	}

	public void setCell(String cell, int value) {
		map.put(cell, value);
	}

	public void resetCell(String cell) {
		map.put(cell, 0);
	}

	public int getValue(String formula) {
		String[] arr = formula.substring(1).split("\\+");
		return getCellValue(arr[0]) + getCellValue(arr[1]);
	}

	private int getCellValue(String cell) {
		return isInteger(cell) ? Integer.parseInt(cell) : map.getOrDefault(cell, 0);
	}

	private boolean isInteger(String cell) {
		for (char ch : cell.toCharArray()) {
			if (!Character.isDigit(ch))
				return false;
		}
		return true;
	}
}