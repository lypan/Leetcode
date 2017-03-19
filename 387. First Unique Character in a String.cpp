class Solution {
public:
    int firstUniqChar(string s) {
        unordered_map<char, int> map;
        int index = -1;

        for(auto ch : s) map[ch] ++;
        for(int i = 0; i < s.size(); i ++) {
            if(map.count(s[i]) > 0 && map[s[i]] == 1)return i;
        }
        return index;
    }
};
