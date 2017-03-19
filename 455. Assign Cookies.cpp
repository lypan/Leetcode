class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());

        int i = 0;
        int count = 0;
        for(auto cookie : s) {
            if(i < g.size() && cookie >= g[i]) {
                count ++;
                i ++;
            }
        }

        return count;
    }
};
