package Easy.no2138;

class Solution {
	public String[] divideString(String s, int k, char fill) {

		String[] result = new String[(s.length() - 1) / k + 1];

		for (int i = 0, j = 0; i < result.length; i++) {

			StringBuilder sb = new StringBuilder();
			while (sb.length() < k) {
				sb.append(j < s.length() ? s.charAt(j++) : fill);
			}
			result[i] = sb.toString();

		}

		return result;
	}
}