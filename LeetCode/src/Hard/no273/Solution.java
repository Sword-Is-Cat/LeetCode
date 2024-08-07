package Hard.no273;

class Solution {

	String[] nums = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
			"Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
	String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

	public String numberToWords(int num) {
		StringBuilder sb = new StringBuilder();
		if (num > 999999999) {
			if (sb.length() != 0)
				sb.append(" ");
			sb.append(numberToWords(num / 1000000000)).append(" Billion");
			num %= 1000000000;
		}

		if (num > 999999) {
			if (sb.length() != 0)
				sb.append(" ");
			sb.append(numberToWords(num / 1000000)).append(" Million");
			num %= 1000000;
		}
		if (num > 999) {
			if (sb.length() != 0)
				sb.append(" ");
			sb.append(numberToWords(num / 1000)).append(" Thousand");
			num %= 1000;
		}

		if (num > 99) {
			if (sb.length() != 0)
				sb.append(" ");
			sb.append(nums[num / 100]).append(" Hundred");
			num %= 100;
		}

		if (num > 19) {
			if (sb.length() != 0)
				sb.append(" ");
			sb.append(tens[num / 10]);
			num %= 10;
		}

		if (num > 0) {
			if (sb.length() != 0)
				sb.append(" ");
			sb.append(nums[num]);
		}

		if (sb.length() == 0)
			sb.append("Zero");

		return sb.toString();
	}
}