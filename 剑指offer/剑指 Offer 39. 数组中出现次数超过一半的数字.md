#### [剑指 Offer 39. 数组中出现次数超过一半的数字](https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/)

数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

```
输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
输出: 2
```

摩尔投票法，投我++，不投--，超过一半以上的人投我

```java
class Solution {
    public int majorityElement(int[] nums) {
        int majorNumber = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majorNumber) count++;
            else count--;
            if (count <= 0) {
                count = 1;
                majorNumber = nums[i];
            }
        }
        return majorNumber;
    }
}
```

