class Solution {
public:
    bool isValid(string s) {
        size_t i = 0;
        string left = "({[";
        stack<char> temp;
        bool valid = true;
        while(true) {
            for(auto &c : s) {
                if(left.find(c) != string::npos) {
                    temp.push(c);
                }
                else {
                    if(temp.empty())return false;
                    char lc = temp.top();
                    temp.pop();
                    switch(lc) {
                        case '(':
                            if(c != ')') return false;
                            break;
                        case '{':
                            if(c != '}') return false;
                            break;
                        case '[':
                            if(c != ']') return false;
                            break;
                    }
                } 
            }
            return temp.empty();
        }
    }
};