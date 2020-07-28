package Easy.no278;

class VersionControl {
	boolean isBadVersion(int version) {

		return true;
	}
}

public class Solution extends VersionControl {
	public int firstBadVersion(int n) {

		if (isBadVersion(1))
			return 1;

		int i = 1;
		int j = n;

		while (i + 1 != j) {

			int mid = 0;

			if (i % 2 == 1 && j % 2 == 1)
				mid = i / 2 + j / 2 + 1;
			else
				mid = i / 2 + j / 2;

			if (isBadVersion(mid))
				j = mid;
			else
				i = mid;

		}

		return j;

	}

}