class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length + 2];
        dp[0] = 0;  //开始没有钱
        dp[1] = 0;  // 前两天都没钱的
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 2], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }
}