class Solution {
    public String sortString(String s) {
        if(s.length()==0||s.length()==1)return s;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) count[s.charAt(i) - 'a']++;
        int index = s.length();
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (index != 0) {
            for (; i < 26; i++)
                if (count[i] != 0) {
                    sb.append((char) (i + 'a'));
                    count[i]--;
                    index--;
                }
            i--;
            for (; i >= 0; i--)
                if (count[i] != 0) {
                    sb.append((char) (i + 'a'));
                    count[i]--;
                    index--;
                }
            i++;
        }
        return sb.toString();
    }
}