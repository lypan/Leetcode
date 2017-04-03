class Solution {
public:
    int rob(vector<int>& nums) {
        if(nums.size() == 0)return 0;
        if(nums.size() == 1)return nums[0];
        if(nums.size() == 2)return max(nums[0], nums[1]);


        vector<int> money(nums.size(), 0);

        money[0] = nums[0];
        money[1] = max(nums[0], nums[1]);

        for(int i = 2; i < nums.size(); i ++) {
            // current rob i -> money[i - 2] + nums[i]
            // current not rob i -> money[i - 1]
            money[i] = max(money[i - 2] + nums[i], money[i - 1]);
        }

        return money[nums.size() - 1];
    }
};
