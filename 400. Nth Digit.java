public class Solution {
    public int findNthDigit(int n) {
        int digitsPerNumber = 1;
        long totalNumbersInInterval = 9;
        int tensMultiplication = 1;
        while(n > digitsPerNumber * totalNumbersInInterval) {
            // to avoid overflow, use minus instead of addition
            n -= digitsPerNumber * totalNumbersInInterval;
            digitsPerNumber ++;
            totalNumbersInInterval *= 10;
            tensMultiplication *= 10;
        }

        // n - 1 so start from 0
        int NthNumber = tensMultiplication + (n - 1) / digitsPerNumber;
        int NthIndex = (n - 1) % digitsPerNumber;
        String num = Integer.toString(NthNumber);
        int digit = Character.getNumericValue(num.charAt((n - 1) % digitsPerNumber));

        return digit;
    }
}

// reference:http://blog.csdn.net/styshoo/article/details/52908420
