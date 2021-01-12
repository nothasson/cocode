https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/

地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

```
输入：m = 2, n = 3, k = 1
输出：3
输入：m = 3, n = 1, k = 0
输出：1
```

这题和12题差不多，只是判断的条件有些不同。

下面是递归DFS版本。

```java
class Solution {
    static int res = 0;

    public int movingCount(int m, int n, int k) {
        res = 0;
        dfs(m, n, k, 0, 0, new boolean[m][n]);
        return res;
    }

    private void dfs(int m, int n, int k, int i, int j, boolean[][] isVisied) {
        if (i < 0 || j < 0 || i >= m || j >= n || !check(i, j, k) || isVisied[i][j] == true)
            return;
        res++;
        isVisied[i][j] = true;
        dfs(m, n, k, i + 1, j, isVisied);
        //dfs(m, n, k, i - 1, j, isVisied);
        dfs(m, n, k, i, j + 1, isVisied);
        //dfs(m, n, k, i, j - 1, isVisied);
    }

    private boolean check(int i, int j, int k) {  //判断是否符合K
        int res = 0;
        while (i != 0) {
            res += i % 10;
            i /= 10;
        }
        while (j != 0) {
            res += j % 10;
            j /= 10;
        }
        return res <= k;
    }
}
```

![image-20210112140058188](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20210112140058188.png)



迭代BFS版本

```java
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        // 向右和向下的方向数组
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        boolean[][] vis = new boolean[m][n];
        queue.offer(new int[]{0, 0});
        vis[0][0] = true;
        int ans = 1;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 2; ++i) {  //向左和向上的 实际上已经走过了。
                int tx = dx[i] + x;
                int ty = dy[i] + y;
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || vis[tx][ty] || !check(tx, ty, k)) {
                    continue;
                }
                queue.offer(new int[]{tx, ty});
                vis[tx][ty] = true;
                ans++;
            }
        }
        return ans;
    }

    private boolean check(int i, int j, int k) {
        int res = 0;
        while (i != 0) {
            res += i % 10;
            i /= 10;
        }
        while (j != 0) {
            res += j % 10;
            j /= 10;
        }
        return res <= k;
    }
}
```

效率还是没有DFS的高的。。

![image-20210112135823395](https://gitee.com/20162180090/piccgo/raw/master/pic/image-20210112135823395.png)

