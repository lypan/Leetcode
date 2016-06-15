class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        vector<int> result;
        unordered_set<int> hashMap(nums1.begin(), nums1.end());
        for(auto val : nums2) {
            if(hashMap.count(val)) {
                result.push_back(val);
                hashMap.erase(val);
            }
        }
        return result;
    }
};