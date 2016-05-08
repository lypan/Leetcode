class Solution {
public:
    int myAtoi(string str) {
        long long result = 0;
        int isPositive = 1;
        string whitespace = " \t\n0";
        int i = str.find_first_not_of(whitespace);
        if(i == string::npos) i = 0;
        if(str[i] == '+' ) {
            isPositive = 1;
            i ++;
        }
        else if(str[i] == '-') {
            isPositive = -1;
            i ++;
        }
        while(str[i] >= '0' && str[i] <= '9') {
            result *= 10;
            result += str[i] - '0';
            i ++;
            if(isPositive * result > INT_MAX)return INT_MAX;
            else if(isPositive * result < INT_MIN)return INT_MIN;
        }
        if(result != 0)return isPositive * result;
        else return 0;
    }
};
