import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> number = new Stack<>();
        String temp;
        int num1, num2;
        for (int i = 0; i < tokens.length; i++) {
            temp = tokens[i];
            switch (temp) {
                case "+":
                    num1 = number.pop();
                    num2 = number.pop();
                    number.push(num2 + num1);
                    break;
                case "-":
                    num1 = number.pop();
                    num2 = number.pop();
                    number.push(num2 - num1);
                    break;
                case "*":
                    num1 = number.pop();
                    num2 = number.pop();
                    number.push(num2 * num1);
                    break;
                case "/":
                    num1 = number.pop();
                    num2 = number.pop();
                    number.push(num2 / num1);
                    break;
                default:
                    number.push(Integer.valueOf(temp));
                    break;
            }
        }
        return number.peek();
    }
}