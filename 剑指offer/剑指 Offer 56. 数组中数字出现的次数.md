# [剑指 Offer 56 - I. 数组中数字出现的次数](https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/)

一个整型数组 `nums` 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。

```
输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]
输入：nums = [1,2,10,4,1,4,3,3]
输出：[2,10] 或 [10,2]
```

如果只有一个数字出现一次，其他均出现两次的话，很容易想到用异或^的方法来实现，但是现在有两个数字出现了一次。

如果我们可以把所有数字分成两组，使得：

1. 两个只出现一次的数字在不同的组中；
2. 相同的数字会被分到相同的组中。

1. 先对所有数字进行一次异或，得到两个出现一次的数字的异或值。
2. 在异或结果中找到任意为 1 的位。 （两个数字某一个不同，他们的异或值才为一，所以可以根据这个把他们分成两组）
3. 根据这一位对所有的数字进行分组。
4. 在每个组内进行异或操作，得到两个数字。

# [剑指 Offer 56 - II. 数组中数字出现的次数 II](https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/)

在一个数组 `nums` 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字

```
输入：nums = [3,4,3,3]
输出：4
输入：nums = [9,1,7,9,7,9,7]
输出：1
```

## 纯位运算

如果使用异或运算，当出现三次的时候，其中的两次就会相互抵消，所以不能使用异或的方法。

**尽管我们这里不能应用异或运算,我们还是可以沿用位运算的思路。**

如果一个数字出现三次,那么它的二进制表示的每一位(0或者1)也出现三次。如果把所有出现三次的数字的二进制表示的每一位都分别加起来,那么每一位的和都能被3整除。如果某一位的和能被3整除,那么那个只出现一次的数字二进制表示中对应的那一位是0;否则就是1;

上述思路同样适用于数组中一个数字出现一次，其他数字出现奇数次问题(如果是偶数次，直接用异或就可)。

这种解法的时间效率是O(n)。我们需要一个长度为32的辅助数组存储二进制表示的每一位的和。由于数组的长度是固定的,因此空间效率是O(1)。

```java
class Solution {
    public int singleNumber(int[] nums) {//本算法同样适用于数组nums中存在负数的情况
        if (nums.length == 0) return -1;//输入数组长度不符合要求，返回-1;
        int[] bitSum = new int[32];//java int类型有32位，其中首位为符号位
        int res = 0;
        for (int num : nums) {
            int bitMask = 1;//需要在这里初始化，不能和res一起初始化
            for (int i = 31; i >= 0; i--) {//bitSum[0]为符号位
                //这里同样可以通过num的无符号右移>>>来实现，否则带符号右移(>>)左侧会补符号位，对于负数会出错。
                //但是不推荐这样做，最好不要修改原数组nums的数据
                if ((num & bitMask) != 0) bitSum[i]++;//这里判断条件也可以写为(num&bitMask)==bitMask,而不是==1
                bitMask = bitMask << 1;//左移没有无符号、带符号的区别，都是在右侧补0
            }
        }
        for (int i = 0; i < 32; i++) {//这种做法使得本算法同样适用于负数的情况
            res = res << 1;
            res ^= bitSum[i] % 3;//这两步顺序不能变，否则最后一步会多左移一次
        }
        return res;
    }
}
```

## 有穷自动机+位运算

智商真的被碾压啊。。。这些人太强了。。

[只出现一次的数字 II - 只出现一次的数字 II - 力扣（LeetCode） (leetcode-cn.com)](https://leetcode-cn.com/problems/single-number-ii/solution/zhi-chu-xian-yi-ci-de-shu-zi-ii-by-leetcode/)

那是真滴牛皮

```java
class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int x: nums) {
            // 之前出现过两次的，这次再出现就是出现了三次
            int threes = twos & x;

            // 之前出现过两次，这次没出现，是出现了两次。
            // 之前出现过一次的，这次再出现，也是出现了两次。
            twos = (twos & ~x) | (ones & x);

            // 统计记录出现了奇数次的，并从其中清除出现三次的。
            // 这样ones里面始终只会记录出现了一次的。
            ones = ones ^ x;
            ones &= ~threes;
        }
        return ones;
    }
}
```

