class Solution {
    public int dfs(int[][] grid, int i, int j, int len, int goal) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return 0;
        if (grid[i][j] == 2) {
            if (len == goal)
                return 1;
            else
                return 0;
        }
        if (grid[i][j] != 0)
            return 0;
        int res = 0;
        grid[i][j] = -1;
        res += dfs(grid, i - 1, j, len + 1, goal);
        res += dfs(grid, i + 1, j, len + 1, goal);
        res += dfs(grid, i, j - 1, len + 1, goal);
        res += dfs(grid, i, j + 1, len + 1, goal);
        grid[i][j] = 0;
        return res;
    }

    public int uniquePathsIII(int[][] grid) {
        int si, sj, goal;
        si = sj = goal = 0;
        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] != -1)
                    ++goal;
                if (grid[i][j] == 1) {
                    si = i;
                    sj = j;
                    grid[i][j] = 0;
                }
            }
        return dfs(grid, si, sj, 1, goal);
    }
}