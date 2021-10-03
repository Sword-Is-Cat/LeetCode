package Medium.no36;

import java.util.HashSet;
import java.util.Set;

class Solution {
	public boolean isValidSudoku(char[][] board) {

		for (int i = 0; i < 9; i++) {

			char[] arr1 = new char[9];
			char[] arr2 = new char[9];

			for (int j = 0; j < 9; j++) {

				arr1[j] = board[i][j];
				arr2[j] = board[j][i];

			}

			if (!checkValid(arr1) || !checkValid(arr2))
				return false;

		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				
				char[] arr = new char[9];
				
				int x = i*3;
				int y = j*3;
				
				arr[0] = board[x][y];
				arr[1] = board[x][y+1];
				arr[2] = board[x][y+2];
				arr[3] = board[x+1][y];
				arr[4] = board[x+1][y+1];
				arr[5] = board[x+1][y+2];
				arr[6] = board[x+2][y];
				arr[7] = board[x+2][y+1];
				arr[8] = board[x+2][y+2];
				
				if(!checkValid(arr))
					return false;
				
			}
		}

		return true;

	}

	public boolean checkValid(char[] arr) {

		Set<Character> set = new HashSet<>();

		for (char ch : arr) {
			if (ch == 46)
				continue;
			else {
				if (!set.add(ch)) {
					
					return false;
				}
			}
		}

		return true;

	}
	
	public static void main(String[] args) {
		char[][] arr = {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}};
		System.out.println(new Solution().isValidSudoku(arr));
	}
}