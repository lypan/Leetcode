class Solution {
public:
    string toHex(int num) {
        if(num == 0)return "0";

        string hexStr = "0123456789abcdef";
        string result = "";

        int hexMask = 0xf;
        unsigned int unsignedMask = 0xffffffff;

        while(num) {
            int index = num & hexMask;
            result = hexStr[index] + result;

            unsignedMask >>= 4;
            num >>= 4;
            num &= unsignedMask;
        }

        return result;
    }
};
