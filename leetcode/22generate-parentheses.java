class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        if (n == 0) return res;
        backtracking(0, n, 0, 0, res, new StringBuffer());
        return res;
    }

    private void backtracking(int cur, int n, int left, int right, List<String> res, StringBuffer sb) {
        if (cur == 2 * n) {
            res.add(sb.toString());
            return;
        }
        if (left > right && right < n) {
            sb.append(')');
            backtracking(cur + 1, n, left, right + 1, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (left < n) {
            sb.append('(');
            backtracking(cur + 1, n, left + 1, right, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}