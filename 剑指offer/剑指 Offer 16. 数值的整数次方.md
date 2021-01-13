#### [剑指 Offer 16. 数值的整数次方](https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/)

实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。

 

```
输入: 2.00000, 10
输出: 1024.00000
输入: 2.10000, 3
输出: 9.26100
输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
```

![image-20210113132447422](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20210113132447422.png)

递归方法。

```java
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        double half = myPow(x, n / 2);
        double rest = myPow(x, n % 2);
        return rest * half * half;
    }
}
```

迭代方法

```java
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double result = 1.0;
        boolean isMinus = false;
        if (n < 0) {
            isMinus = true;
            n = -n;
        }
        while (n != 0) {
            if (n % 2 == 1) result *= x;
            x *= x;
            n /= 2;
        }
        return isMinus ? 1.0 / result : result;
    }
}
```

然后有个过不了

![image-20210113133545502](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20210113133545502.png)

 n = -n; 这一步的时候会越界，所以提前让一个long b = n在进行后面的操作就不会错了。

![image-20210113133840394](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20210113133840394.png)

