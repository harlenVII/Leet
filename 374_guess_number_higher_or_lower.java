/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int i = 1, j = n;
        while (i + 1 < j) {
            int mid = i + (j - i) / 2;
            int val = guess(mid);
            if (val == 0)
                return mid;
            if (val == -1)
                j = mid;
            else
                i = mid;
        }
        if (guess(j) == 0)
            return j;
        return i;
    }
}
