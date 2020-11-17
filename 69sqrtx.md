以为是一道大水题，发现想的太简单了。。

```java
class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
```

其他方法还有牛顿法等等。。

不用二分法就很慢

```java
class Solution {
    public int mySqrt(int x) {
        if(x == 0)return 0;
        for (int i = 1; i < x; i++) {
            if ((long)i * i > x) return i-1;
        }
        return 1;
    }
}
```

