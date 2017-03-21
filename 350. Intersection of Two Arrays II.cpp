class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        unordered_map<int, int> map;
        vector<int> result;
        for(auto val : nums1) {
            map[val] ++;
        }
        for(auto val : nums2) {
            if(map.count(val) > 0 && map[val] > 0) {
                map[val] --;
                result.push_back(val);
            }
        }
        return result;
    }
};
