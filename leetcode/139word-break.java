class Solution {
    public HashMap<String, Boolean> hash = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1]; //dp[i]表示s前i个字符能否拆分
        for (String word : wordDict) {
            hash.put(word, true);
        }
        dp[0] = true;
        for (int j = 1; j <= s.length(); j++) {
            for (int i = j - 1; i >= 0; i--) {
                boolean flag = hash.getOrDefault(s.substring(i, j), false);
                dp[j] = dp[i] && flag;
                if (dp[j]) break;
            }
        }
        return dp[s.length()];
    }
}