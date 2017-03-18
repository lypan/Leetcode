class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int count = 0;
        int max_count = 0;

        for(auto val : nums) {
            if(val)max_count = (++count > max_count ? count : max_count);
            else count = 0;
        }

        return max_count;
    }
};
