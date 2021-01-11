class Solution {
    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] ss = s.toCharArray();
        char temp = ' ';
        while (i < j) {
            while (i < j && !isVowel(ss[i]))
                i++;
            while (i < j && !isVowel(ss[j]))
                j--;
            temp = ss[i];
            ss[i] = ss[j];
            ss[j] = temp;
            i++;
            j--;
        }
        return new String(ss);
    }
    private boolean isVowel(char a){
        return (a == 'a'||a == 'e'||a == 'i'||a == 'o'||a == 'u'||a == 'A'||a == 'E'||a == 'I'||a == 'O'||a == 'U');
    }
}