class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& findNums, vector<int>& nums) {
        stack<int> stack;
        unordered_map<int, int> map;
        vector<int> result;

        for(auto val : nums) {
            while(!stack.empty() && val > stack.top()) {
                map.insert(pair<int, int>(stack.top(), val));
                stack.pop();
            }
            stack.push(val);
        }

        while(!stack.empty()) {
            map.insert(pair<int, int>(stack.top(), -1));
            stack.pop();
        }

        for(auto val : findNums) {
            result.push_back(map[val]);
        }
        return result;
    }
};
