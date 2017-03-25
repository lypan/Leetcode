class Solution {
public:
    vector<string> generatePossibleNextMoves(string s) {
        vector<string> result;
        for(int i = 1; i < s.size(); i ++) {
            if(s[i - 1] == '+' && s[i] == '+') {
                result.push_back(s.substr(0, i - 1) + "--" + s.substr(i + 1));
            }
        }
        return result;
    }
};
