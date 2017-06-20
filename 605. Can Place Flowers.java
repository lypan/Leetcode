public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // head
        boolean prevIsZero = true;
        int zero_count = 1;

        // middle
        for(int i = 0; i < flowerbed.length; i ++) {
            int val = flowerbed[i];

            if(val == 1) {
                zero_count = 0;
                prevIsZero = false;
            }
            else if(val == 0) {
                zero_count ++;
            }
            
            // place the flower
            // 000 -> 010
            if(zero_count == 3) {
                n --;
                zero_count = 1;
            }

        }

        // tail
        if(zero_count == 2)n --;

        if(n <= 0)return true;
        else return false;
    }
}
