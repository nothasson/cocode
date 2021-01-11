//https://leetcode-cn.com/problems/jump-game/solution/55-by-ikaruga/
class Solution {
    public boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) return false;
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }
}

//如果能跳到第n个，则表示前n个都可以跳到。。
class Solution {
    public boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i <= k; i++) {
            k = Math.max(k, i + nums[i]);
            if (k >= nums.length - 1) return true;  //跳到了最少第n-1（最后一个了），所以前面的都可以
        }
        return false;
    }
}