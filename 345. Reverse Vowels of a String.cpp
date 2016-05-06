class Solution {
public:
    string reverseVowels(string s) {
        size_t i = 0;
        size_t j = s.size() - 1;
        string vowels = "aeiouAEIOU";
        while(true) {
            i = s.find_first_of(vowels, i);
            j = s.find_last_of(vowels, j);
            if(i < j) swap(s[i], s[j]);
            else break; 
            i ++;
            j --;
        }
        return s;
    }
};