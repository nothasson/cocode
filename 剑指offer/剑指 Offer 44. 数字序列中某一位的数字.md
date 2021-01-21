#### [剑指 Offer 44. 数字序列中某一位的数字](https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/)

数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。

请写一个函数，求任意第n位对应的数字。

 

```
输入：n = 3
输出：3
输入：n = 11
输出：0
```

题解摘自[面试题44. 数字序列中某一位的数字（迭代 + 求整 / 求余，清晰图解） - 数字序列中某一位的数字 - 力扣（LeetCode） (leetcode-cn.com)](https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/solution/mian-shi-ti-44-shu-zi-xu-lie-zhong-mou-yi-wei-de-6/)

1. 将 $101112 ···$中的每一位称为 **数位** ，记为 $n$ ；
2. 将 10,11,12,⋯ 称为 **数字** ，记为 $num$ ；
3. 数字 10 是一个两位数，称此数字的 **位数** 为 22 ，记为 $digit$
4. 每 $digit$ 位数的起始数字（即：$1, 10, 100, \cdots$），记为 $start$ 。

<img src="https://gitee.com/20162180090/piccgo/raw/master/pic/2cd7d8a6a881b697a43f153d6c10e0e991817d78f92b9201b6ab71e44cb619de-Picture1.png" alt="Picture1.png" style="zoom:33%;" />

1. ##### 确定所求数位的所在数字的位数 

![image-20210121131236231](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20210121131236231.png)



##### 2. 确定所求数位所在的数字![image-20210121131254669](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20210121131254669.png)

##### 3. 确定所求数位在 $num$ 的哪一数位

![image-20210121131334335](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20210121131334335.png)

```java
class Solution {
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }
}

作者：jyd
链接：https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/solution/mian-shi-ti-44-shu-zi-xu-lie-zhong-mou-yi-wei-de-6/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

