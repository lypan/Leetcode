class Solution {
public:
    struct myStruct{
      int val;
      int order;

      bool operator<(myStruct const &r) const {
          return val > r.val;
      }
    };
    vector<string> findRelativeRanks(vector<int>& nums) {
        vector<myStruct> data;
        vector<string> result(nums.size(), "");
        for(int i = 0; i < nums.size(); i ++) {
            myStruct myData;
            myData.val = nums[i];
            myData.order = i;

            data.push_back(myData);
        }
        sort(data.begin(), data.end());

        for(int i = 0; i < data.size(); i ++) {
            if(i == 0)result[data[0].order] = "Gold Medal";
            else if(i == 1)result[data[1].order] = "Silver Medal";
            else if(i == 2)result[data[2].order] = "Bronze Medal";
            else result[data[i].order] = to_string(i + 1);
        }

        return result;
    }
};

// sol2:use priority queue
