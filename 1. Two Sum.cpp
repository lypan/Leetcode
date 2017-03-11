// One pass
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        std::unordered_map<int, int> dict;
        std::vector<int> result;
        int index = 0;
        for(auto i : nums) {
            int complement_number = target - i;
            auto search = dict.find(complement_number);

            // already exists
            if(search != dict.end()) {
                result.push_back(search->second);
                result.push_back(index);
                return result;
            }
            // not exists
            else {
                dict.insert(std::make_pair(i, index));
            }
            index ++;
        }
        return result;
    }
};
// Two pass
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        std::unordered_map<int, int> dict;
        std::vector<int> result;
        int index;

        // first pass
        index = 0;
        for(auto i : nums){
            // values of dulplicate key won't insert
            dict.insert(std::make_pair(i, index));
            index ++;
        }
        // second pass
        index = 0;
        for(auto i : nums) {
            int complement_number = target - i;
            auto search = dict.find(complement_number);

            // not itself
            if(search != dict.end() && search->second != index) {
                result.push_back(index);
                result.push_back(search->second);
                return result;
            }
            index ++;
        }
        return result;
    }
};
// Thought
1.hashmap對於同樣的key，只會插入第一個value，保持1 to 1.
2.make_pair,find 的用法
