class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        int rightest_diff_bit = 0;
        for(int i:nums){
            rightest_diff_bit ^= i;
        }
        int a = 0, b = 0;
        rightest_diff_bit &= -rightest_diff_bit;
        for(int i:nums){
            if(i & rightest_diff_bit)a ^= i;
            else b ^= i;
        }
        return {a,b};
    }
};