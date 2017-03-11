class Solution {
public:
    int reverse(int x) {
        long long result = 0;
        while(x) {
            result *= 10;
            result += x % 10;
            x /= 10;
        }
        return (result < INT_MIN || result > INT_MAX) ? 0 : result;
    }
};
// Thought 
// http://stackoverflow.com/questions/7594508/modulo-operator-with-negative-values
1. For integral operands the / operator yields the algebraic quotient with any fractional part discarded; if the quotient a/b is representable in the type of the result, (a/b)*b + a%b is equal to a.
2. overflow check