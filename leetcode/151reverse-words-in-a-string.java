// https://leetcode-cn.com/problems/reverse-words-in-a-string/submissions/
// https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
// 剑指offer的，顺带提交了吧
class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        StringBuilder temp;
        int j = s.length() - 1;
        int i = j + 1;
        while (j >= 0) {
            j = i - 1;
            while (j >= 0 && s.charAt(j) == ' ') j--;
            i = j;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            i++;
            if (i >= 0 && j >= 0)
                res.append(s.substring(i, j + 1) + " ");
        }
        if (res.length() >= 1)
            res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}