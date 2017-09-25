class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }
            else {
                map.put(num, 1);
            }
        }

        int result = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > nums.length / 2) {
                result = entry.getKey();
                break;
            }
        }

        return result;
    }
}
// sol2
// class Solution {
// public:
//     int majorityElement(vector<int>& nums) {
//         unordered_map<int,int> counts;
//         for(auto i:nums){
//             counts[i] ++;
//         }
//         for(auto i:nums){
//             if(counts[i] > nums.size() / 2)return i;
//         }
//     }
// };
