class Solution {
public:
    bool isStrobogrammatic(string num) {
        unordered_map<char, char> map = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};

        for(int l = 0, r = num.size() - 1; l <= r; l ++, r --) {
            char lc = num[l];
            char rc = num[r];

            if(map.count(lc) == 0 || map.count(rc) == 0)return false;
            // because c++ unordered_map will set add entry for nonexist and set default value 0, so we split it to 2 condition
            else if(map[lc] != num[r])return false;
        }
        return true;
    }
};
