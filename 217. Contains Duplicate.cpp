class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_map<int,int> counts;
        for(auto i:nums){
            counts[i] ++;
        }
        for(auto i:counts){
            if(i.second >= 2)return true;
        }
        return false;
    }
};