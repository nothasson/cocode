import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char now;
        char nowPair;
        for (int i = 0; i < s.length(); i++) {
            now = s.charAt(i);
            if (now == '(' || now == '[' || now == '{') stack.push(now);
            else {
                nowPair = getPair(now);
                if (stack.size()==0||stack.peek() != nowPair) return false;
                stack.pop();
            }
        }
        return stack.size() == 0;
    }

    private char getPair(char c) {
        switch (c) {
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
        }
        return '.';
    }
}