class Solution {
public:
    int majorityElement(vector<int>& nums) {
        unordered_map<int,int> counts;
        for(auto i:nums){
            counts[i] ++;
        }
        for(auto i:nums){
            if(counts[i] > nums.size() / 2)return i;
        }
    }
};