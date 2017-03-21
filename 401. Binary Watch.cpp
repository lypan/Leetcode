class Solution {
public:
    vector<string> readBinaryWatch(int num) {
        vector<string> result;
        for(int i = 0; i < 12; i ++) {
            for(int j = 0; j < 60; j ++) {
                bitset<8> set1(i);
                bitset<8> set2(j);

                string s = "";
                if(set1.count() + set2.count() == num) {
                    s += to_string(i);
                    s += ":";
                    s += (j < 10) ? "0" + to_string(j): to_string(j);

                    result.push_back(s);
                }
            }
        }
        return result;
    }
};
