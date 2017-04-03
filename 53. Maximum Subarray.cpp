class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i < nums.size(); i ++) {
            currentSum = max(nums[i], currentSum + nums[i]);
            maxSum = max(maxSum, currentSum);
        }
        return maxSum;
    }
};

// reference:http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
// reference:http://www.geeksforgeeks.org/divide-and-conquer-maximum-sum-subarray/


// sol2
// class Solution {
// public:
//     int maxSubArray(vector<int>& nums) {
//         int l = 0;
//         int r = nums.size() - 1;
//         int m = (l + r) / 2;
//
//
//         int leftMax = getMaxSumOfSubArray(nums, l, m);
//         int rightMax = getMaxSumOfSubArray(nums, m + 1, r);
//
//         int middleMax = getCrossingSumOfSubArray(nums, l, m, r);
//
//         return max(middleMax, max(leftMax, rightMax));
//     }
//
//     int getMaxSumOfSubArray(vector<int>& nums, int l, int r) {
//
//         int m = (l + r) / 2;
//
//         if(l > r)return INT_MIN;
//         else if(l == r)return nums[m];
//
//         int leftMax = getMaxSumOfSubArray(nums, l, m);
//         int rightMax = getMaxSumOfSubArray(nums, m + 1, r);
//
//         int middleMax = getCrossingSumOfSubArray(nums, l, m, r);
//
//         return max(middleMax, max(leftMax, rightMax));
//     }
//
//     int getCrossingSumOfSubArray(vector<int>& nums, int l, int m, int r) {
//         if(l == r)return nums[m];
//
//          // Include elements on left of mid.
//         int sum = 0;
//         int left_sum = INT_MIN;
//         for (int i = m; i >= l; i--)
//         {
//             sum = sum + nums[i];
//             if (sum > left_sum)
//               left_sum = sum;
//         }
//
//         // Include elements on right of mid
//         sum = 0;
//         int right_sum = INT_MIN;
//         for (int i = m+1; i <= r; i++)
//         {
//             sum = sum + nums[i];
//             if (sum > right_sum)
//               right_sum = sum;
//         }
//
//         // Return sum of elements on left and right of mid
//         return left_sum + right_sum;
//     }
// };
