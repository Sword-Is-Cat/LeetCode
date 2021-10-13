package Medium.no331;

class Solution {
	public boolean isValidSerialization(String preorder) {

		String[] arr = preorder.split(",");

		int require = 1;

		for (String str : arr) {

			if (require == 0)
				return false;

			if (str.equals("#"))
				require--;
			else
				require++;

		}

		return require == 0;

	}
}