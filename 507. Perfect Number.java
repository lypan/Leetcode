public class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num <= 1)return false;

        int sum = 1;
        for(int i = 2; i < Math.sqrt(num); i ++) {
            if(num % i == 0) {
                sum += (i + num / i);
            }
        }

        if(num % Math.sqrt(num) == 0)sum += Math.sqrt(num);

        return sum == num;
    }
}
