// // first zero will stop
// class Solution {
// public:
//     void moveZeroes(vector<int>& nums) {
//         int cur = 0;
//         int first_zero = 0;
//         while(cur < nums.size()){
//             if(nums[cur] != 0){
//                 swap(nums[cur], nums[first_zero]);
//                 first_zero ++;
//             }
//             cur ++;
//         }
//     }
// };

class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int idx = 0;
        for(auto&& n : nums) {
            if(n != 0) {
                nums[idx ++] = n;
            }
        }
        for(int i = idx; i < nums.size(); i ++) {
            nums[i] = 0;
        }
        
    }
};