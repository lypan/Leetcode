class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int maxArea = Integer.MIN_VALUE;
        while(l < r) {
            if(height[l] > height[r]) {
                maxArea = Math.max(maxArea, (r - l) * height[r]);
                r --;
            }
            else {
                maxArea = Math.max(maxArea, (r - l) * height[l]);
                l ++;
            }
        }
        return maxArea;
    }
}
