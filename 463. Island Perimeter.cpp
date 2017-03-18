class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        int island_num = 0;
        int overlapped_line_num = 0;
        for(int i = 0; i < grid.size(); i ++) {
            for(int j = 0; j < grid[i].size(); j ++) {
                if(grid[i][j] == 1) {
                    island_num ++;
                    
                    // right
                    if((j + 1) < grid[i].size() && grid[i][j + 1] == 1)overlapped_line_num ++;
                    // down
                    if((i + 1) < grid.size() && grid[i + 1][j] == 1 )overlapped_line_num ++;
                }
            }
        }
        return (island_num * 4 - overlapped_line_num * 2);
    }
};
