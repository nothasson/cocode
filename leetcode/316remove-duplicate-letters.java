import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        int[] lastInx = new int[26];
        for (int i = 0; i < chars.length ; i++) {
            lastInx[chars[i] - 'a'] = i; //记录每个元素最后一次出现的位置
        }
        Deque<Character> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[26]; //某一个字符是否在栈中出现
        for (int i = 0; i < chars.length; i++) {
            if (visited[chars[i] - 'a']) { //如果出现舍弃当前字符
                continue;
            }
            //当前字符在栈顶元素之前，且栈顶元素在后面还有
            while (!stack.isEmpty() && stack.peekLast() > chars[i] && lastInx[stack.peekLast() - 'a'] > i) {
                Character c = stack.removeLast();  //移除栈顶元素
                visited[c - 'a'] = false; //表示该字符没有在栈中出现
            }
            stack.addLast(chars[i]);
            visited[chars[i] - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(Character c : stack){
            sb.append(c);
        }
        return sb.toString();
    }
}