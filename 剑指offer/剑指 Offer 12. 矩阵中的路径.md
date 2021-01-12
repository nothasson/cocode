https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/

请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。

[["a","b","c","e"],
["s","f","c","s"],
["a","d","e","e"]]

但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。

解析见注释。

```
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true
```

```java
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean res = false;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (board[i][j] == word.charAt(0)) {  //（匹配字符串的第一个元素）
                    res = backtracking(board, word, 0, i, j);
                    if (res) return true;
                }
        return false;

    }

    private boolean backtracking(char[][] board, String word, int index, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length   
                || word.charAt(index) != board[x][y])
            //越界，与字符串不匹配
            return false;
        if (index == word.length() - 1) return true;
        char temp = board[x][y];
        board[x][y] = '.';  //去重
        boolean res = backtracking(board, word, index + 1, x + 1, y)  //上下左右四种情况
                || backtracking(board, word, index + 1, x - 1, y)
                || backtracking(board, word, index + 1, x, y + 1)
                || backtracking(board, word, index + 1, x, y - 1);
        board[x][y] = temp;  //回溯
        return res;

    }
}
```

