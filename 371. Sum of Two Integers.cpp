class Solution {
public:
    int getSum(int a, int b) {

        if(a == 0)return b;
        if(b == 0)return a;


        while(b != 0) {
            int carry = (a & b);
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }
};

// class Solution {
// public:
//     int getSum(int a, int b) {
//
//         if(a == 0)return b;
//         if(b == 0)return a;
//
//         int sum = a ^ b;
//         int carry = a & b;
//
//         while(carry != 0) {
//             carry = carry << 1;
//
//             int temp = carry;
//             carry = sum & carry;
//             sum = sum ^ temp;
//         }
//
//         return sum;
//     }
// };
