#### [剑指 Offer 62. 圆圈中最后剩下的数字](https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/)

0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。

例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。

```
输入: n = 5, m = 3
输出: 3
输入: n = 10, m = 17
输出: 2
```

好像是大一的时候写的约瑟夫链。虽然当时并不会

```java
class Solution {
    public int lastRemaining(int n, int m) {
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            l.add(i);
        }
        int index = 0;
        while (l.size() != 1) {
            index = (index + m - 1) % l.size();
            l.remove(index);
        }
        return l.get(0);
    }
}
```

![image-20210226152349195](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20210226152349195.png)

可以看到效率很低很低，看看题解

[Java解决约瑟夫环问题，告诉你为什么模拟会超时！ - 圆圈中最后剩下的数字 - 力扣（LeetCode） (leetcode-cn.com)](https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh/)

很强，很秀

```java
class Solution {
    public int lastRemaining(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}
```

