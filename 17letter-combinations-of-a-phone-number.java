import java.util.LinkedList;
import java.util.List;
//自己写了一个全排列，应该是大三的时候厉害许多了
class Solution {
    static int[] start = new int[11];


    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();

        if (digits == null || digits.length() == 0) return res;
        start[2] = 0;
        start[3] = 3;
        start[4] = 6;
        start[5] = 9;
        start[6] = 12;
        start[7] = 15;
        start[8] = 19;
        start[9] = 22;
        start[10] = 26;
        StringBuffer sb = new StringBuffer();
        dfs(res, 0, digits, sb);
        return res;
    }

    private void dfs(List<String> res, int i, String digits, StringBuffer sb) {
        if (i == digits.length()) {
            res.add(sb.toString());
            return;
        } else {
            int s = start[digits.charAt(i) - '0'];
            int e = start[digits.charAt(i) - '0' + 1];
            while (s < e) {
                sb.append((char) (s + 'a'));
                s++;
                dfs(res, i + 1, digits, sb);
                sb.deleteCharAt(i);
            }
        }
    }
}