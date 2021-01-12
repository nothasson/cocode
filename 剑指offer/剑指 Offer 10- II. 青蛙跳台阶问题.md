https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/

一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

同 Fib

```java
class Solution {
    public int numWays(int n) {
        if (n == 1 || n == 0) return 1;
        int x = 0, y = 1;
        for (int i = 0; i < n; i++) {
            int temp = (x + y) % 1000000007;
            x = y;
            y = temp;
        }
        return y;
    }
}
```





