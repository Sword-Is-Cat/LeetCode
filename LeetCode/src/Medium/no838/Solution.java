package Medium.no838;

class Solution {
	public String pushDominoes(String dominoes) {

		boolean doit = true;

		while (doit) {

			doit = false;

			dominoes = dominoes.replaceAll("R\\.L", "MMM");

			if (dominoes.contains(".L")) {
				doit = true;
				dominoes = dominoes.replaceAll("\\.L", "LL");
			}

			if (dominoes.contains("R.")) {
				doit = true;
				dominoes = dominoes.replaceAll("R\\.", "RR");
			}

		}

		return dominoes.replaceAll("MMM", "R.L");

	}

}