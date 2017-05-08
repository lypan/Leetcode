// sol1
class Solution {
public:
    bool canPermutePalindrome(string s) {
        bitset<256> charSet;

        for(auto ch : s) {
            charSet.flip(ch);
        }

        return charSet.count() < 2;
    }
};


// sol2
// class Solution {
// public:
//     bool canPermutePalindrome(string s) {
//         unordered_map<char, int> map;
//
//         bool firstOdd = false;
//         bool secondOdd = false;
//
//         for(char ch : s) {
//             map[ch] ++;
//         }
//
//         for(char ch : s) {
//             if(map[ch] % 2 == 1) {
//                 if(!firstOdd)firstOdd = true;
//                 else secondOdd = true;
//                 map[ch] = 0;
//             }
//         }
//
//         if(firstOdd && secondOdd)return false;
//         else return true;
//     }
// };


// Java
// public class Solution {
//     public boolean canPermutePalindrome(String s) {
//         Set<Character> set = new HashSet<>();
//
//         for(Character ch : s.toCharArray()) {
//             if(set.contains(ch))set.remove(ch);
//             else set.add(ch);
//         }
//
//         return set.size() == 0 || set.size() == 1;
//     }
// }
