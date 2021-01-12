https://leetcode-cn.com/problems/jian-sheng-zi-lcof/

给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

```
输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1
输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
```



![image-20210112142912390](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20210112142912390.png)

自己写的时候忘记考虑绿色的部分了，所以有些过不了。

```java
class Solution {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }
}
```

![image-20210112143023257](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20210112143023257.png)

第二种方法是通过数学公式推出来了的。 

```java
class Solution {
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        int res=1;
        //贪心算法，优先切三，其次切二
        while(n>4){
            res=res*3;
            n-=3;
        }
        //出来循环只有三种情况，分别是n=2、3、4
        return (res*n);
    }
}
```

![image-20210112143706634](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20210112143706634.png)

推导的公式：

https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/mian-shi-ti-14-i-jian-sheng-zi-tan-xin-si-xiang-by/