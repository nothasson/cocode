如果不会还是写一个md文件吧，这样以后还能看一下

## 贪心算法

**如果之前的序列和小于0，则舍弃之前的序列和，重新开始计算。**

![image-20200919152339446](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20200919152339446.png)

![image-20200919152303514](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20200919152303514.png)

![image-20200919152355575](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20200919152355575.png)

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int preSum = -1 * Integer.MAX_VALUE;
        int curSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum = curSum;
            if (preSum < 0) curSum = nums[i];
            else curSum += nums[i];
            if (maxSum < curSum) maxSum = curSum;
        }
        return maxSum;
    }
}
```

## 动态规划

如果前一下标的元素大于0，则将其加入到这个元素中，其实和贪心算法差不多，只是修改了数组。

![image-20200919153130262](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20200919153130262.png)

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0)
                nums[i] += nums[i - 1];
            if (nums[i] > max) max = nums[i];
        }
        return max;
    }
}
```

