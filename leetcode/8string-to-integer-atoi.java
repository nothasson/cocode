class Solution {
    public int myAtoi(String s) {
        int sum = 0;
        boolean isMinus = false;
        int i = 0;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') continue;
            if (s.charAt(i) == '-') {
                i++;
                isMinus = true;
                break;
            } else if (s.charAt(i) == '+'){
                i++;
                break;
            } else if(s.charAt(i) >= '0' && s.charAt(i) <= '9') break;
            else i = s.length();
        }
        for (; i < s.length(); i++) {
            if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                if (sum > Integer.MAX_VALUE / 10 || (sum == Integer.MAX_VALUE / 10 && (s.charAt(i) - '0') > Integer.MAX_VALUE % 10))
                    return Integer.MAX_VALUE;
                if (sum < Integer.MIN_VALUE / 10 || (sum == Integer.MIN_VALUE / 10 && (s.charAt(i) - '0') > -(Integer.MIN_VALUE % 10))) {
                    return Integer.MIN_VALUE;
                }
                sum = sum * 10 + (isMinus ? -1 * (s.charAt(i) - '0') : (s.charAt(i) - '0'));
            } else break;
        }
        return sum;
    }
}