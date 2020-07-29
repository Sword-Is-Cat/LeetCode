package Easy.no374;

public class Solution extends GuessGame {
	public int guessNumber(int n) {

		long i = 1;
		long j = n;
		long mid = (i+j)/2;

		while (guess((int)mid) != 0) {

			if (i == mid) {
				mid = j;
				break;
			} else if (j == mid) {
				mid = i;
				break;
			}

			if (guess((int)mid) == 1)
				i = mid;
			else
				j = mid;

			mid = (i + j) / 2;
		}

		return (int)mid;

	}
}

class GuessGame {
	int guess(int num) {
		return 0;
	}
}