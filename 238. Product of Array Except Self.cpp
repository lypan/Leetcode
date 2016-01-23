class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> result(nums.size(), 1);
        for(int i = 1; i < result.size(); i ++){
            result[i] = result[i - 1] * nums[i - 1];
        }
        int right_accum = 1;
        for(int i = result.size() - 1; i >= 0; i --){
            result[i] *= right_accum;
            right_accum *= nums[i];
        }
    return result;
    }
};