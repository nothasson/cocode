#### [剑指 Offer 64. 求1+2+…+n](https://leetcode-cn.com/problems/qiu-12n-lcof/)

求 `1+2+...+n` ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

```
输入: n = 3
输出: 6
输入: n = 9
输出: 45
```

看了别人的想法，真的是太秀了！

## 逻辑符短路

```
n > 1 && sumNums(n - 1) // 当 n = 1 时 n > 1 不成立 ，此时 “短路” ，终止后续递归
```

```java
class Solution {
    int res = 0;
    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }
}
```

## 等差数列求和公式

```java
class Solution {
    public int sumNums(int n) {
         return (int) (Math.pow(n, 2) + n) >> 1;
    }
}
```

