class Solution {
public:
    int numberOfBoomerangs(vector<pair<int, int>>& points) {
        int count = 0;

        for(auto &i : points) {
            unordered_map<double, int> map;

            for(auto &j : points) {
                double distance = hypot(i.first - j.first, i.second - j.second);

                map[distance] ++;
            }

            for(auto &p : map) {
            /*
             * for all the groups of points,
             * number of ways to select 2 from n is
             * C(n, 2) = n * n - 1
             * Then the two points can be swapped, ex:[a, b, c], [a, c, b], so we multiply it by 2
             */
                if(p.first != 0) {
                    count += (p.second * (p.second - 1) / 2) * 2;
                }
            }
            cout << "count:" << count << endl;
        }
        return count;

    }
};
