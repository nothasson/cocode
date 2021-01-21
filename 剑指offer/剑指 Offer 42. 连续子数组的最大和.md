#### [剑指 Offer 42. 连续子数组的最大和](https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/)

输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

要求时间复杂度为O(n)。

```
输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
```

兜兜转转，发现简单的动态规划还是不会。。

设$dp[j]$]为以$j$结尾的子数组的最大值

![image.png](https://gitee.com/20162180090/piccgo/raw/master/pic/1610541763-uwlIqL-file_1610541762737) ![image-20210119153216289](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20210119153216289.png)

可以看到，四者同时包含$nums[3]$，比较四者哪个更大，其实就是比较$0$、$nums[2]$、$nums[1]+nums[2]$、$nums[0]+nums[1]+nums[2]$四者谁大谁小。

有没有发现规律？$nums[2]、nums[1]+nums[2]、nums[0]+nums[1]+nums[2]$这三者的最大值恰好就是dp[2]。所以，如果$dp[2]>0，dp[3]=dp[2]+nums[3]$，否则，$dp[3] = 0 + nums[3]$。

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int j = 1; j < nums.length; j++) {
            dp[j] = nums[j] + Math.max(0, dp[j - 1]);
            max = Math.max(max, dp[j]);
        }
        return max;
    }
}
```

