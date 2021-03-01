#### [剑指 Offer 67. 把字符串转换成整数](https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/)

写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。

 

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0。

>  说明：
>
>  假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或  INT_MIN (−231) 。

```java
class Solution {
    public int strToInt(String str) {
        int sum = 0;
        boolean isMinus = false;
        int i = 0;
        char[] chars = str.toCharArray();
        for (i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') continue;
            else if (chars[i] == '-') {
                i++;
                isMinus = true;
                break;
            } else if (chars[i] == '+') {
                i++;
                break;
            } else if (chars[i] >= '0' && chars[i] <= '9') break;
            else return sum;
        }
        if (i == chars.length) return 0;
        if (chars[i] < '0' || chars[i] > '9') return sum;
        for (; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && (chars[i] - '0') > Integer.MAX_VALUE % 10))
                    return Integer.MAX_VALUE;
                if (sum < Integer.MIN_VALUE / 10 || (sum == Integer.MIN_VALUE / 10 && (chars[i] - '0') > -(Integer.MIN_VALUE % 10))) {
                    return Integer.MIN_VALUE;
                }
                sum = sum * 10 + (isMinus ? -1 * (chars[i] - '0') : (chars[i] - '0'));
            } else break;
        }
        return sum;
    }
}
```

