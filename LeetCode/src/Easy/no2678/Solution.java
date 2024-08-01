package Easy.no2678;

class Solution {
	public int countSeniors(String[] details) {
		int ans = 0;
		for (String info : details) {
//			if (Integer.parseInt(info.substring(11, 13)) > 60)
			if (((info.charAt(11) - '0') * 10 + info.charAt(12) - '0') > 60)
				ans++;
		}
		return ans;
	}
}