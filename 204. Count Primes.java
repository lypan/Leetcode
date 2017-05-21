public class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for(int i = 2; i < n; i ++)isPrime[i] = true;

        // Sieve of Eratosthenes
        for(int i = 2; i * i < n; i ++) {
            if(!isPrime[i])continue;
            // delete multiple of the number
            for(int j = i * i; j < n; j += i)isPrime[j] = false;
        }

        // count prime number
        int count = 0;
        for(int i = 2; i < n; i ++) {
            if(isPrime[i])count ++;
        }
        return count;
    }
}
