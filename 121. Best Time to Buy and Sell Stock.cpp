class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int min = INT_MAX;
        int max = 0;
        for(auto &val : prices) {
            if(val < min)min = val;
            else if(val - min > max)max = val - min;
        }
        return max;
    }
};

// other solution:http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
// public int maxProfit(int[] prices) {
//     int maxCur = 0, maxSoFar = 0;
//     for(int i = 1; i < prices.length; i++) {
//         maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
//         maxSoFar = Math.max(maxCur, maxSoFar);
//     }
//     return maxSoFar;
// }
