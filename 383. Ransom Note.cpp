class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        unordered_map<char, int> map;
        for(auto ch : magazine) {
            map[ch] ++;
        }
        for(auto ch : ransomNote) {
            if(map.count(ch) != 0 && map[ch] > 0) {
                map[ch] --;
            }
            else return false;
        }
        return true;
    }
};
