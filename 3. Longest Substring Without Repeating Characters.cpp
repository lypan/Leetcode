class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        std::unordered_map<char, int> dict;
        int answer = 0;
        for(int i = 0, j = 0; j < s.length(); j ++) {
            auto search = dict.find(s[j]);
            if(search != dict.end()) {
                i = max(search->second + 1, i);
                search->second = j;
            }
            else {
                dict.insert(std::make_pair(s[j], j));
            }
            answer = max(answer, j - i + 1);
        }
        return answer;
    }
};
// Thought
1.traverse all substring, just like triange in a matrix
2.i and j only foward and i jump to the encountered index + 1