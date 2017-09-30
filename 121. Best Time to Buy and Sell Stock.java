class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)return 0;

        int max_ending_here = 0;
        int max_so_far = 0;

        // start from 1 because must buy and sell
        for(int i = 1; i < prices.length; i ++) {
            // try sell the price
            max_ending_here += (prices[i] - prices[i - 1]);
            // stored profits must be positive
            max_ending_here = Math.max(0, max_ending_here);
            // store profit
            max_so_far = Math.max(max_so_far, max_ending_here);
        }

        return max_so_far;
    }
}
