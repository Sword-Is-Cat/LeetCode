package Medium.no12;

class Solution {
	public String intToRoman(int num) {

		StringBuilder sb = new StringBuilder();

		while (num > 0) {

			if (num > 999) {
				sb.append("M");
				num -= 1000;
			} else if (num > 899) {
				sb.append("CM");
				num -= 900;
			} else if (num > 499) {
				sb.append("D");
				num -= 500;
			} else if (num > 399) {
				sb.append("CD");
				num -= 400;
			} else if (num > 99) {
				sb.append("C");
				num -= 100;
			} else if (num > 89) {
				sb.append("XC");
				num -= 90;
			} else if (num > 49) {
				sb.append("L");
				num -= 50;
			} else if (num > 39) {
				sb.append("XL");
				num -= 40;
			} else if (num > 9) {
				sb.append("X");
				num -= 10;
			} else if (num > 8) {
				sb.append("IX");
				num -= 9;
			} else if (num > 4) {
				sb.append("V");
				num -= 5;
			} else if (num > 3) {
				sb.append("IV");
				num -= 4;
			} else {
				sb.append("I");
				num -= 1;
			}

		}

		return sb.toString();

	}
}