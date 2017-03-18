class Solution {
public:
    vector<string> findWords(vector<string>& words) {
		//001, 010, 100
        unordered_map<char, int> table( {{'Q', 1}, {'W', 1}, {'E', 1},{'R', 1}, {'T', 1}, {'Y', 1}, {'U', 1}, {'I', 1}, {'I', 1}, {'O', 1}, {'P', 1}, {'A', 2}, {'S', 2}, {'D', 2}, {'F', 2}, {'G', 2}, {'H', 2}, {'J', 2}, {'K', 2}, {'L', 2}, {'Z', 4}, {'X', 4}, {'C', 4}, {'V', 4}, {'B', 4}, {'N', 4}, {'M', 4}} );
        int reference;
        vector<string> result;
        
        for( auto word : words) {
            reference = 7;
            for( auto ch : word) {
                int val = table[toupper(ch)];
                reference &= val;
            }
            if(reference) result.push_back(word);
        }
        return result;
    }
};
