class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int max = 0;
        int smallHeight, temp;
        while (i < j) {
            smallHeight = height[i] > height[j] ? height[j] : height[i];
            temp = (j - i) * smallHeight;
            if (temp > max)
                max = temp;
            if(height[i] > height[j]) j--;  //可以假设小的移动之后有最优解
            else i++;
        }
        return max;
    }
}