https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/

写一个函数，输入 `n` ，求斐波那契（Fibonacci）数列的第 `n` 项。斐波那契数列的定义如下：

```java
class Solution {
    public int fib(int n) {
        if (n == 1 || n == 0) return n;
        int x = 0, y = 1;
        for (int i = 0; i < n; i++) {
            int temp = (x + y) % 1000000007;
            x = y;
            y = temp;
        }
        return x;
    }
}
```

