package Medium.no592;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
	public String fractionAddition(String expression) {
		int numer = 0, denom = 1;
		Pattern ptrn = Pattern.compile("([+-]?[0-9]+)/([0-9]+)");
		Matcher match = ptrn.matcher(expression);

		while (match.find()) {

			int num = Integer.parseInt(match.group(1));
			int den = Integer.parseInt(match.group(2));

			numer = numer * den + num * denom;
			denom = denom * den;
			int gcd = gcd(Math.abs(numer), denom);
			numer /= gcd;
			denom /= gcd;

		}
		return numer + "/" + denom;
	}

	private int gcd(int a, int b) {
		return a % b == 0 ? b : gcd(b, a % b);
	}
}