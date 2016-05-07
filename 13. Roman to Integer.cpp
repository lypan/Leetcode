class Solution {
public:
    int romanToInt(string s) {
        unordered_map<char, int> dataMap = {
			{'I', 1},
			{'V', 5},
			{'X', 10},
			{ 'L' , 50 },
			{ 'C' , 100 },
			{ 'D' , 500 },
			{ 'M' , 1000 }
		};
		int sum = dataMap[s.back()];
		for (size_t i = 0; i < s.size() - 1; i++) {
			if(dataMap[s[i]] < dataMap[s[i + 1]]) {
				sum -= dataMap[s[i]];
			}
            else {
                sum += dataMap[s[i]];
            }
		}
        return sum;
    }
};
