class Solution {
public:
    string addStrings(string num1, string num2) {
        int index1 = num1.size() - 1;
        int index2 = num2.size() - 1;

        string result = "";
        int carry = 0;
        int sum = 0;

        while(index1 >= 0 || index2 >= 0) {
            int v1 = (index1 >= 0) ? num1[index1] - '0' : 0;
            int v2 = (index2 >= 0) ? num2[index2] - '0' : 0;

            sum = v1 + v2 + carry;
            carry = sum / 10;
            sum = sum % 10;

            index1 --;
            index2 --;

            result = to_string(sum) + result;
        }
        if(carry != 0)result = to_string(1) + result;
        return result;
    }
};
