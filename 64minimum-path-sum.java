//自己写的一道动态规划。。虽然才超过16.21的人。。
class Solution {
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i - 1 < 0 && j - 1 < 0)
                    continue;
                grid[i][j] = Math.min(i - 1 < 0 ? grid[i][j - 1] : grid[i - 1][j], j - 1 < 0 ? grid[i - 1][j] : grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}

