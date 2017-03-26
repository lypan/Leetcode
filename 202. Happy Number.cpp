class Solution {
public:
    bool isHappy(int n) {
        // result of square of sum as the node
        // process of square of sum as the link
        // find the loop in the linked list
        // Floyd’s Cycle-Finding Algorithm

        int fast = n, slow = n;

        do{
            slow = sumOfDigitsSquare(slow);

            fast = sumOfDigitsSquare(fast);
            fast = sumOfDigitsSquare(fast);
        }while(fast != slow);// because sumOfDigitsSquare(1) will be 1, no change anymore
        if(fast == 1 && slow == 1)return true;
        else return false;
    }

    int sumOfDigitsSquare(int n) {
        int sum = 0;
        while(n) {
            sum += pow(n%10, 2);
            n /= 10;
        }
        return sum;
    }
};
// solution 2
// class Solution {
// public:
//     bool isHappy(int n) {
//         unordered_map<int, int> map;
//
//         while(1) {
//             int sum = 0;
//
//             while(n) {
//                 sum += pow(n%10, 2);
//                 n /= 10;
//             }
//
//             if(sum == 1)return true;
//
//             if(map.count(sum) == 0) {
//                 map[sum] ++;
//                 n = sum;
//             }
//             else return false;
//         }
//
//     }
// };
//
// reference:http://www.geeksforgeeks.org/happy-number/
// reference:http://www.geeksforgeeks.org/write-a-c-function-to-detect-loop-in-a-linked-list/
