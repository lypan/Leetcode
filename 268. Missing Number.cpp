class Solution {
public:
    int missingNumber(vector<int>& nums) {
    	int result = 0;
    	for(int i = 0; i < nums.size(); i ++) {
    		result ^= (i ^ nums[i]);
    	}
    	return result ^ nums.size();
    }
};
// ex: i:0 1 2
//     v:0 1 3
//     size:3
//     so xor all will get result 2 