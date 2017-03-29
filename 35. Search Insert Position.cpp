class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        // pass 1
        for(int i = 0; i < nums.size(); i ++) {
            if(nums[i] == target)return i;
        }

        // pass2
        int less = 0;
        int larger = 0;

        for(int i = 0; i < nums.size(); i ++) {
            if(nums[i] < target)less++;
            if(nums[i] > target)larger++;

            if(larger == 1 && less > 0)return i;
        }

        // if all less or all larger
        if(less > 0) return nums.size();
        else if(larger > 0)return 0;
    }
};

// sol2
// class Solution {
// public:
//     int searchInsert(vector<int>& nums, int target) {
//         int low = 0;
//         int high = nums.size() - 1;
//
//         while(low <= high) {
//             int middle = (low + high) / 2;
//
//             if(nums[middle] == target)return middle;
//             else if(nums[middle] > target) {
//                 high = middle - 1;
//             }
//             else if(nums[middle] < target) {
//                 low = middle + 1;
//             }
//         }
//         return low;
//     }
// };
