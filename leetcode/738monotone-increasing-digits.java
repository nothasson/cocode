//https://leetcode-cn.com/problems/monotone-increasing-digits/solution/738-dan-diao-di-zeng-de-shu-zi-tan-xin-s-vq4r/

class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] s = String.valueOf(N).toCharArray();
        int flag = s.length;
        for (int i = s.length - 1; i > 0; i--) {
            if (s[i - 1] > s[i]) {
                flag = i;
                s[i - 1]--;
            }
        }
        for (int i = flag; i < s.length; i++) {
            s[i] = '9';
        }
        int res = 0;
        for (int i = 0; i < s.length; i++) {
            res = res * 10 + (s[i] - '0');
        }
        return res;
    }
}