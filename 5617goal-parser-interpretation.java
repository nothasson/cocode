class Solution {
    public String interpret(String command) {
        int len = command.length();
        StringBuilder sb =new StringBuilder();
        for(int i=0; i<len; i++){
            if (command.charAt(i) == 'G'){
                sb.append(command.charAt(i));
                continue;
            }
            if(command.charAt(i) == '(' && command.charAt(i + 1)==')'){
                sb.append("o");
                i++;
            }
            else {
                sb.append("al");
                    i += 3;
            }
        }
        return sb.toString();
    }
}