class Solution {
public:
    bool isAnagram(string s, string t) {
        unordered_map<char,int> counts;
        if(s.size() != t.size())return false;
        for(int i = 0; i < s.size(); i ++){
            counts[s[i]] ++;
            counts[t[i]] --;
        }
        for(auto i:counts){
            if(i.second)return false;
        }
        return true;
    }
};