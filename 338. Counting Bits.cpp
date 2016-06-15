class Solution {
public:
    vector<int> countBits(int num) {
        vector<int> result(num + 1);
        for(int i = 1; i < num + 1; i ++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
};