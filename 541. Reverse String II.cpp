class Solution {
public:
    string reverseStr(string s, int k) {
        for(int i = 0; i < s.size(); i += 2 * k) {
            int right = i + k - 1;

            if(right > s.size() - 1) {
                right = s.size() - 1;
            }

            int left = i;

            while(left < right) {
                swap(s[left], s[right]);
                left ++;
                right --;
            }

        }
        return s;
    }
};
