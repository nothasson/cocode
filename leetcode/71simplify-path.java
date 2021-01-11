class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] s = path.split("/");
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals(".") || s[i].equals("")) continue;
            else if (!s[i].equals("..")) stack.push(s[i]);
            else if (!stack.isEmpty()) stack.pop();
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        if (sb.length() == 0) sb.append("/");
        return sb.toString();
    }
}