class Solution {
public:
    vector<int> constructRectangle(int area) {
        // 1. difference is min  when square root
        // 2. after square root, (w,l) and (l,w) just swap
        int w, l;
        for(int i = 1; i * i <= area; i ++) {
            if(area % i == 0)w = i;// get the number most close to square root but <= square root
        }
        return vector<int>{area / w, w};
    }
};
