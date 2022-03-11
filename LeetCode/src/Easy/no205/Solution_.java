package Easy.no205;

import java.util.ArrayList;
import java.util.List;

class Solution_ {
	public boolean isIsomorphic(String s, String t) {

		char[] arrS = s.toCharArray();
		int[] noArrS = new int[arrS.length];
		List<Character> listS = new ArrayList<>();

		for (int i = 0; i < arrS.length; i++) {
			if (listS.contains(arrS[i]))
				noArrS[i] = listS.indexOf(arrS[i]);
			else {
				listS.add(arrS[i]);
				noArrS[i] = listS.size() - 1;
			}
		}

		char[] arrT = t.toCharArray();
		int[] noArrT = new int[arrT.length];
		List<Character> listT = new ArrayList<>();

		for (int i = 0; i < arrT.length; i++) {
			if (listT.contains(arrT[i]))
				noArrT[i] = listT.indexOf(arrT[i]);
			else {
				listT.add(arrT[i]);
				noArrT[i] = listT.size() - 1;
			}
		}

		boolean answer = true;
		
		if (noArrS.length == noArrT.length) {
			for (int i = 0; i < noArrS.length; i++) {
				if(noArrS[i]!=noArrT[i]) {
					answer = false;
					break;
				}
			}
		} else
			answer = false;

		return answer;
	}
}