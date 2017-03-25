class Solution {
public:
    int minCost(vector<vector<int>>& costs) {

        int n = costs.size();
        vector< vector<int> > table(n + 1, vector<int>(3, 0));

        if(n == 0)return 0;
        for(int i = 1; i < n + 1; i ++) {
            // R:0 G:1 B:2
            // table really used index is 1~n and cost really used index is 0~n - 1
            // so i in table:current, i-1 in cost:current
            table[i][0] = min(table[i - 1][1], table[i - 1][2]) +  costs[i - 1][0];
            table[i][1] = min(table[i - 1][0], table[i - 1][2]) +  costs[i - 1][1];
            table[i][2] = min(table[i - 1][0], table[i - 1][1]) +  costs[i - 1][2];
        }
        return min(min(table[n][0], table[n][1]), table[n][2]);
    }
};
