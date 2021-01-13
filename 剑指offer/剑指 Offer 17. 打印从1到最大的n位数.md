#### [剑指 Offer 17. 打印从1到最大的n位数](https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/)

输入数字 `n`，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

```
输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]
```

最简单的方法。。

```java
class Solution {
    public int[] printNumbers(int n) {
        int[] res = new int[(int) (Math.pow(10, n) - 1)];
        for (int j = 0; j < res.length; j++) {
            res[j] = j + 1;
        }
        return res;
    }
}
```

![image-20210113124515045](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20210113124515045.png)

emm..



后面发现，原来剑指offer上主要考大数问题，用字符串模拟加法。但是leetcode不想更改输出，所以题目变烂了。。下面是（全排列问题）的方法。

```java
import java.util.ArrayList;
import java.util.List;

public class Solution {

    // 用于存储满足条件的字符串
    private List<Integer> list;

    public int[] printNumbers(int n) {
        // 存储符合条件的'数'  '数'的类型是字符串
        list = new ArrayList<>();
        dfs(n, 0, new StringBuilder());
        int[] res = new int[list.size()];
        // 存入数组
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(int n, int index, StringBuilder sb) {
        // 递归结束的条件
        if (index == n) {
            while (sb.length() != 0 && sb.charAt(0) == '0') {
                // 将左边多余的0删除
                sb.deleteCharAt(0);
            }
            // 将字符串形式的'数'，转化为整数
            if (sb.length() != 0) {
                list.add(Integer.valueOf(sb.toString()));
            }
            return;
        }
        for (int j = 0; j < 10; j++) {
            // 深度搜索下一位
            sb.append(j);
            dfs(n, index + 1, sb);
            if (sb.length() != 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
```

![image-20210113130115821](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20210113130115821.png)

只能说明leetcode这题有问题。

还有另外一种算法，就是模拟字符串加法的操作，每次都自增一，特别要注意进位的时候。