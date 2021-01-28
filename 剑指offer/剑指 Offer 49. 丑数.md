#### [剑指 Offer 49. 丑数](https://leetcode-cn.com/problems/chou-shu-lcof/)

我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数

```
输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
```

提前把表打印好久OK了

```java
class Ugly {
  public int[] nums = new int[1690];
  Ugly() {
    nums[0] = 1;
    int ugly, i2 = 0, i3 = 0, i5 = 0;

    for(int i = 1; i < 1690; ++i) {
      ugly = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 5);
      nums[i] = ugly;
      if (ugly == nums[i2] * 2) ++i2;
      if (ugly == nums[i3] * 3) ++i3;
      if (ugly == nums[i5] * 5) ++i5;
    }
  }
}

class Solution {
  public static Ugly u = new Ugly();
  public int nthUglyNumber(int n) {
    return u.nums[n - 1];
  }
}
```

![Picture1.png](https://gitee.com/20162180090/piccgo/raw/master/pic/837411664f096417badf857fa51e77fd30cb1309a5637c37d24d8a4a48a42b03-Picture1.png)

