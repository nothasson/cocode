#### [剑指 Offer 29. 顺时针打印矩阵](https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/)

输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

```
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
```

这道题曾经也是困扰我很久的题目，现在会了。

维护四个指针，分别代表最左，最右，最上，最下分别对应的边界。

```java
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[]{};
        List<Integer> res = new LinkedList<>();
        int left = 0, up = 0, right = matrix[0].length - 1, down = matrix.length - 1;
        int index = 0;
        while (true) {
            index = left;
            while (index <= right) {
                res.add(matrix[up][index++]);
            } //最上面的一行
            if (++up > down) break; 
            index = up;
            while (index <= down) {
                res.add(matrix[index++][right]);
            } //最右边的一列
            if (--right < left) break;
            index = right;
            while (index >= left) {
                res.add(matrix[down][index--]);
            } //最下面的一行
            if (--down < up) break;
            index = down;
            while (index >= up) {
                res.add(matrix[index--][left]);
            }//最左边的一列
            if (++left > right) break;
        }
        int[] resArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }
        return resArray;
    }
}
```

放一张比较容易理解的图

![image.png](https://gitee.com/20162180090/piccgo/raw/master/pic/d11f32dcf913a6ba57a712ad61d3fa5b6826a448d9998da607deb9c6ed618102-image.png)摘自https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/solution/shou-hui-tu-jie-liang-chong-bian-li-de-ce-lue-na-c/