// https://leetcode-cn.com/problems/set-mismatch/
//遍历两次即可，每次加(len+1) 注意下标的关系。
class Solution {
    public int[] findErrorNums(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            nums[nums[i] % (len + 1) - 1] += len + 1;
        }
        int a = 0, b = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] < len + 1) a = i + 1;
            if (nums[i] > 2 * (len + 1)) b = i + 1;
        }
        return new int[]{b, a};
    }
}