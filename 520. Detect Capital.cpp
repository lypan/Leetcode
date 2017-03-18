class Solution {
public:
    bool detectCapitalUse(string word) {
        int count = 0;

        for(auto ch : word) {
            if(isupper(ch))count ++;
        }
        return (!count) || (count == word.size()) || (count == 1 && isupper(word[0]));
    }
};
