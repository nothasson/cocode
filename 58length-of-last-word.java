class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int length = 0;
        for (; i >= 0; i--)
            if (s.charAt(i) != ' ') break;
        for (; i >= 0; i--) {
            if (s.charAt(i) == ' ') break;
            length++;
        }
        return length;
    }
}