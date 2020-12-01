class Solution {
  public int uniquePaths(int m, int n) {
    // 用double，因为计算出的数值会很大
    double num = 1, denom = 1;
    // 找出更小的数，这样可以减少计算次数和计算出的数值
    int small = m > n ? n : m;
    for (int i = 1; i <= small - 1; ++i) {
      num *= m + n - 1 - i;
      denom *= i;
     }
     return (int)(num / denom);
  }
}

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];  
    }
}