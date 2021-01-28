#### [剑指 Offer 46. 把数字翻译成字符串](https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/)

给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。

```
输入: 12258
输出: 5
解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
```

这题其实就是斐波拉契数列的变种，也是一种比较简单的动态规划。

每种状态只考虑他前面两种状态的情况，如何他前面两个数是在10-25范围内的，也就是说他可以被翻译。那么就有$f(i) = f(i-1) + f(i-2)$

如果不能被翻译，则$f(i)=f(i-1)$

这就是他的状态转移方程，其他的都可以套用斐波拉契数列的那一套。

```java
class Solution {
    public int translateNum(int num) {
        String n = String.valueOf(num);
        int a = 1,b = 1;
        for(int i = 2 ; i <= n.length(); i++){
            String temp = n.substring(i - 2,i);
            int tempSum = 10 * (temp.charAt(0)-'0') + (temp.charAt(1)-'0');
            int c;
            if(tempSum <= 25 && tempSum >=10) c = a + b;
            else c = a;
            b = a;
            a = c;
        }
        return a;
    }
}
```

