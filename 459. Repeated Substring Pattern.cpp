class Solution {
public:
    bool repeatedSubstringPattern(string s) {
        int strLen = s.length();
        for(int subStrlen = strLen / 2; subStrlen >=1 ; subStrlen --) {
            if(strLen % subStrlen == 0) {
                string result = "";
                int count = strLen / subStrlen;

                for(int j = 0; j < count; j ++)result += s.substr(0, subStrlen);
                if(result == s)return true;
            }
        }
        return false;
    }
};

// sol2
// class Solution {
// public:
//     bool repeatedSubstringPattern(string s) {
//         string tempStr = s + s;
//
//         tempStr = tempStr.substr(1, tempStr.length() - 2 );
//         size_t found = tempStr.find(s);
//
//         if(found == string::npos)return false;
//         else return true;
//     }
// };
