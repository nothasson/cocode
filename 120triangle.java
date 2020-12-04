// 渣渣做法，只超过35%的人
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) return 0;
        int m = triangle.size();
        int[][] dp = new int[m + 1][m + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= i; j++) {
                if (i == 1 && j == 1) dp[i][j] = triangle.get(i - 1).get(j - 1);
                else if (j >= triangle.get(i - 1).size()) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i - 1).get(j - 1);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i - 1).get(j - 1);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp[m].length; i++) {
            if (min > dp[m][i]) min = dp[m][i];
        }
        return min;
    }
}
//从下到上优雅又牛逼
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // dp[i][j] 表示从点 (i, j) 到底边的最小路径和。
        int[][] dp = new int[n + 1][n + 1];
        // 从三角形的最后一行开始递推。
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
