class Solution {
public:
    int minMoves(vector<int>& nums) {
        // increment n-1 elements 1 == decrease 1 element 1
        int min = INT_MAX;
        int sum = 0;
        for(auto val : nums) {
            sum += val;
            min = (val < min) ? val : min;
        }
        return sum - nums.size() * min;
    }
};
