class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int cur = 0;
        int non_zero = 0;
        while(cur < nums.size()){
            if(nums[cur] != 0){
                swap(nums[cur], nums[non_zero]);
                non_zero ++;
            }
            cur ++;
        }
    }
};