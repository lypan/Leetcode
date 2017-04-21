/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        return binarySearchGuess(1, n);
    }
    int binarySearchGuess(int low, int high) {

        while(low <= high) {
            // avoid overflow
            int middle = low + (high - low) / 2;
            int result = guess(middle);

            if(result == 0) return middle;
            else if(result == -1) high = middle - 1;
            else if(result == 1) low = middle + 1;
        }
        return -1;
    }
}
