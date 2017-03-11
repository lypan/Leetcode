class Solution {
public:
    string convert(string s, int numRows) {
        if(numRows == 1) return s;
        
        bool down = true;
        vector<string> rowsOfString(numRows);
        int row_idx = 0;
        for(int i = 0; i < s.length(); i ++) {
            
            rowsOfString[row_idx] += s[i];

            if(row_idx == numRows - 1) {
                down = false;
            }
            else if(row_idx == 0) {
                down = true;
            }
            
            row_idx = down ? row_idx + 1 : row_idx - 1;
        }
        string result = "";
        for(int i = 0; i < numRows; i ++) {
            cout << rowsOfString[1] << endl;
            result += rowsOfString[i];
        }
        return result;
    }
};
// Thought
1. every character is assigned a row index
2. use up and down to control it