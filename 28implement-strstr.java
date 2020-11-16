class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        for (int i = 0; i < haystack.length() - needle.length() +1; i++) {
            int index = 0;
            while (i + index < haystack.length() && index < needle.length() && haystack.charAt(i + index) == needle.charAt(0 + index)) {
                if (index == needle.length() - 1) return i;
                index++;
            }
        }
        return -1;
    }
}