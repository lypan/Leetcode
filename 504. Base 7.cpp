class Solution {
public:
    string convertToBase7(int num) {
        if(num == 0)return "0";

        string result = "";
        bool isNegative = num < 0;
        num = abs(num);

        while(num) {
            int r = num % 7;
            result = to_string(r) + result;
            num = num / 7;
        }
        if(isNegative)result = "-" + result;
        return result;
    }
};
