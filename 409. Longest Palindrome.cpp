class Solution {
public:
    int longestPalindrome(string s) {
        unordered_map<char, int> map;
        bool firstOdd = false;

        for(char ch : s) {
            map[ch] ++;
        }

        int odd_count = 0;
        for(auto it = map.begin(); it != map.end(); ++it) {
            if(it->second % 2 == 1)odd_count ++;
        }

        return s.size() - odd_count + (odd_count > 0);
    }
};

// sol2
class Solution {
public:
    int longestPalindrome(string s) {
        unordered_map<char, int> map;
        bool firstOdd = false;

        for(char ch : s) {
            map[ch] ++;
        }

        int count = 0;
        for(auto it = map.begin(); it != map.end(); ++it) {
            if(it->second % 2 == 0) {
                count += it->second;
            }
            else if(it->second % 2 == 1) {
                if(firstOdd) count += it->second - 1;
                else {
                    firstOdd = true;
                    count += it->second;
                }
            }
        }

        return count;
    }
};
