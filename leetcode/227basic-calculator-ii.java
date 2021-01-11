class Solution {
    public int calculate(String s) {
        int res = 0, d = 0;
        char op = '+';
        Stack<Integer> nums = new Stack<>();
        char curChar;
        for (int i = 0; i < s.length(); i++) {
            curChar = s.charAt(i);
            if (curChar >= '0')
                d = d * 10 + curChar - '0';
            if ((curChar < '0' && curChar != ' ') || i == s.length() - 1) {
                if (op == '+')
                    nums.add(d);
                else if (op == '-')
                    nums.add(-d);
                else if (op == '*')
                    nums.add(d * nums.pop());
                else if (op == '/')
                    nums.add(nums.pop() / d);
                op = curChar;
                d = 0;
            }
        }
        while (!nums.isEmpty()) {
            res += nums.pop();
        }
        return res;
    }
}